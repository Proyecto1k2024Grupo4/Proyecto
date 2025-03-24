# Eventos, Triggers, Procedimientos, Funciones y Cursores

**Participantes:**

- Diego Fernando Valencia Correa
- Jonathan Villalba Moran
- Samini Abdel

#### Definición de 2 eventos que automaticen tareas con diferente periodicidad


#### Definición de 2 disparadores sobre operaciones asociadas al modelo de datos.



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