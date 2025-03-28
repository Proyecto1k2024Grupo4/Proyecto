# Eventos, Triggers, Procedimientos, Funciones y Cursores

**Participantes:**

- Diego Fernando Valencia Correa
- Jonathan Villalba Moran
- Samini Abdel

<br>

## Definición de 2 eventos que automaticen tareas con diferente periodicidad

**1. Actualizar cada día el estado de las propuestas a `TERMINADA` que tengan una fecha de expiración anterior a la actual**

``` sql
delimiter //
create or replace event actualizar_estado_propuestas
on schedule every 1 day starts timestamp(current_date, '00:00:00')
do
begin
     update PROPUESTA
     set estado = 'TERMINADA'
     where fechaExpiracion < now();
end;
//
delimiter ;
```

**2. Evento que se ejectua a final de cada mes que crea una tabla en la que guardamos los votos a favor de las propuestas**

``` sql
delimiter //
create or replace event crearPropuestaConVotos
on schedule every 1 month starts timestamp(last_day(current_date), '23:59:59')
do
begin
    drop table PROPUESTA_VOTAR;

    create table PROPUESTA_VOTAR(
    id int unsigned auto_increment,
    titulo varchar(100) not null,
    descripcion varchar(2000) not null,
    fechaExpiracion date,
    estado enum('ACEPTACION', 'PUBLICACION', 'VOTACION', 'TERMINADA') not null,
    idCongreso int unsigned not null,
    numPasaportePolitico varchar(16) not null,
    fechaProposicion date not null,
    fechaAceptacion date,
    fechaPublicacion date,
    votosAFavor int unsigned,
    votosEnContra int unsigned,
    totalVotos int unsigned,
    constraint PK_PROPUESTA_VOTAR primary key (id)
    );

    call desnormalizarPropuestaVotar();
end;
//
delimiter ;
```

<br>

## Definición de 2 disparadores sobre operaciones asociadas al modelo de datos.

 **1. Cada vez que se actualize la tabla `PROPUESTA` se verificará que las fechas tienen un orden cronológico coherente**

 ``` sql
delimiter //
create or replace trigger verificar_fechas_propuesta
after update on PROPUESTA
for each row
begin
    if new.fechaExpiracion < new.fechaPublicacion then
        signal sqlstate '45000'
            set message_text = 'Error: La fecha de expiración debe ser posterior a la de publicación';
    if new.fechaPublicacion < new.fechaAceptacion then
        signal sqlstate '45001'
            set message_text = 'Error: La fecha de publicación debe ser posterior a la de aceptación';
    if new.fechaAceptacion < new.fechaProposicion then
        signal sqlstate '45002'
            set message_text = 'Error: La fecha de aceptación debe ser posterior a la proposición.';
    end if;
end;
//
delimiter ;
```

**2. Cuando una propuesta es aceptada, se incrementa el contador de propuestas aprobadas en el congreso**

``` sql
delimiter //
CREATE TRIGGER actualizar_propuestas_aprobadas
AFTER UPDATE ON PROPUESTA
FOR EACH ROW
BEGIN
    IF OLD.estado != 'Aceptada' AND NEW.estado = 'Aceptada' THEN
        UPDATE CONGRESO c
        JOIN PROPUESTA p ON c.id = p.idCongreso
        SET c.propAprobadas = c.propAprobadas + 1
        WHERE p.id = NEW.id;
    END IF;
END;
//
delimiter ;
```

<br>

## Definición de 2 procedimientos almacenados que realicen más de una operación dentro de una transacción, haciendo una gestión adecuada de los errores, ya sea mediante señales o excepciones, y sus consiguientes manejadores.

**1. Procedimiento que inserta una persona y que acepta un valor para comprobar si es político o ciudadano e insertarlo también en su respectiva tabla.**

``` sql
delimiter //
create or replace procedure insertPersona(in numPasaporte varchar(16), in _nombre varchar(32), in _primerApellido varchar(32), in _segundoApellido varchar(32), in _fnac date, in _sexo char(1), in _paisNacimiento int unsigned, in _ciudadanoPolitico int)
begin

end;
//
delimiter ;

```

``` sql
delimiter //
create or replace procedure upsertLey()
begin

end;
//
delimiter ;

```

<br>

## Definición de 2 procedimientos almacenados que utilicen cursores que recorran cierta cantidad de datos, realizando operaciones sobre una o más tablas, haciendo una gestión adecuada de los errores, ya sea mediante señales o excepciones, y sus consiguientes manejadores


**1. Procedimiento utilizado por el evento crearPropuestaConVotos que inserta los datos de `PROPUESTA` en la tabla `PROPUESTA_VOTAR` añadiendo campos para contabilizar los votos a favor, en contra y el total.** 
``` sql
delimiter //
create or replace procedure desnormalizarPropuestaVotar()
begin
    declare fin int default 1;
    declare votosFavor int unsigned;
    declare votosEnContra int unsigned;
    declare totalVotos int unsigned;
    declare rowPropuesta row type PROPUESTA;
    declare curPropuesta cursor for select * from PROPUESTA;
    declare continue handler for not found set fin = 0;

    declare exit handler for sqlexception
    begin
        rollback;
    end;


    start transaction;

    open curPropuesta;

    while fin = 1 do
        fetch curPropuesta into rowPropuesta;

        if fin = 1 then

            set votosAFavor = (select count(*) from VOTAR where decision = 1 and idPropuesta = rowPropuesta.id);
            set votosEnContra = (select count(*) from VOTAR where decision = 0 and idPropuesta = rowPropuesta.id);
            set totalVotos = (select count(*) from VOTAR where idPropuesta = rowPropuesta.id);

            insert into PROPUESTA_VOTAR(id, titulo, descripcion, fechaExpiracion, estado, idCongreso, numPasaportePolitico, fechaProposicion, fechaAceptacion, fechaPublicacion, votosAFavor, votosEnContra, totalVotos)
                values 
                    (rowPropuesta.id, rowPropuesta.titulo, rowPropuesta.descripcion, rowPropuesta.fechaExpiracion, rowPropuesta.estado, rowPropuesta.idCongreso, rowPropuesta.numPasaportePolitico, rowPropuesta.fechaProposicion, rowPropuesta.fechaAceptacion, rowPropuesta.fechaPublicacion, votosAFavor, votosEnContra, totalVotos);
            
        end if;

    end while;

    commit;

end;
//
delimiter ;

```


**2.**
``` sql
delimiter //
create or replace procedure upsertLey(_id INT UNSIGNED, _descripcion VARCHAR(2000), _fechaAplicacion DATE, _fechaModificacion DATE, _fechaImplementacion DATE, _idCodigoCivil INT UNSIGNED)
begin

    declare fin int default 1;
    declare rowPropuesta row type PROPUESTA;
    declare curPropuesta for select * from PROPUESTA;
    declare continue handler for not found set fin = 1;

    declare exit handler for sqlexception
    begin
        rollaback;
    end;

    star transaction;
    
    open curPropuesta;
    
    while fin = 1 do
        fecth curPropuesta into rowPropuesta;

        if fin = 1 do

            if _id = rowPropuesta.id do
                update LEY
                    set
            

end;
//
delimiter ;

```