# Eventos, Triggers, Procedimientos, Funciones y Cursores

**Participantes:**

- Diego Fernando Valencia Correa
- Jonathan Villalba Moran
- Samini Abdel

#### Definición de 2 eventos que automaticen tareas con diferente periodicidad

**Antes de insertar una propuesta, verifica que la fecha de expiración sea posterior a la fecha actual**

``` sql
        CREATE EVENT actualizar_estado_propuestas
        ON SCHEDULE EVERY 1 MONTH
        DO
        BEGIN
            UPDATE PROPUESTA
            SET estado = 'Expirada'
            WHERE fechaExpiracion < NOW();
        END;
```
**Este evento se ejecuta diariamente para marcar como inactivo a los políticos cuya fecha de retiro ha pasado**

``` sql
CREATE EVENT revisar_politicos_retirados
ON SCHEDULE EVERY 1 DAY
DO
BEGIN
    UPDATE POLITICO
    SET estado = 'Retirado'
    WHERE fechaRetirada < NOW();
END;

```
#### Definición de 2 disparadores sobre operaciones asociadas al modelo de datos.

 **Antes de insertar una propuesta, verifica que la fecha de expiración sea posterior a la fecha actual**

 ``` sql
CREATE TRIGGER verificar_fecha_propuesta
BEFORE INSERT ON PROPUESTA
FOR EACH ROW
BEGIN
    IF NEW.fechaExpiracion <= NOW() THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Error: La fecha de expiración debe ser futura.';
    END IF;
END;
```

**Cuando una propuesta es aceptada, se incrementa el contador de propuestas aprobadas en el Congreso**

``` sql

CREATE TRIGGER actualizar_propuestas_aprobadas
AFTER UPDATE ON PROPUESTA
FOR EACH ROW
BEGIN
    IF OLD.estado <> 'Aceptada' AND NEW.estado = 'Aceptada' THEN
        UPDATE CONGRESO c
        JOIN PROPUESTA p ON c.id = p.idCongreso
        SET c.propAprobadas = c.propAprobadas + 1
        WHERE p.id = NEW.id;
    END IF;
END;
```


#### Definición de 2 procedimientos almacenados que realicen más de una operación dentro de una transacción, haciendo una gestión adecuada de los errores, ya sea mediante señales o excepciones, y sus consiguientes manejadores.

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

Definición de 2 procedimientos almacenados que utilicen cursores que recorran cierta cantidad de datos, realizando operaciones sobre una o más tablas, haciendo una gestión adecuada de los errores, ya sea mediante señales o excepciones, y sus consiguientes manejadores