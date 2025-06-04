# Consultas Extra 

Estas son consultas que no vienen de una tarea sino que han sido añadidas por voluntad propia a fin de mejorar el proyecto.

**Participantes**:
- Diego Fernando Valencia Correa 
- Jonathan Villalba Moran
- Samini Abdel


### Procedimiento que crea un país, un congreso y un código civil al mismo tiempo.
``` sql
DELIMITER //
CREATE OR REPLACE PROCEDURE insertar_pais (IN nombre_pais VARCHAR(64))
BEGIN
    DECLARE nuevo_id_pais INT UNSIGNED;

    -- Insertar el nuevo país
    INSERT INTO PAIS (nombre) VALUES (nombre_pais);
    SET nuevo_id_pais = LAST_INSERT_ID();

    -- Insertar el código civil asociado al nuevo país
    INSERT INTO CODIGO_CIVIL (id, idPais) VALUES (nuevo_id_pais, nuevo_id_pais);

    -- Insertar el congreso asociado al nuevo país
    INSERT INTO CONGRESO (id, idPais) VALUES (nuevo_id_pais, nuevo_id_pais);
END;
//
DELIMITER ;
```

### Procedimiento que crea un ciudadano y una persona al mismo tiempo.
``` sql
DELIMITER //
CREATE OR REPLACE PROCEDURE insertar_ciudadano (IN numPasaporte_ VARCHAR(64), IN nombre_ VARCHAR(32), IN primerApellido_ VARCHAR(32),
    IN segundoApellido_ VARCHAR(32), IN fnac_ DATE, IN sexo_ char(1), IN paisNacimiento_ INT UNSIGNED)
BEGIN
    INSERT INTO PERSONA VALUES(numPasaporte_, nombre_, primerApellido_, segundoApellido_, fnac_, sexo_, paisNacimiento_);
    INSERT INTO CIUDADANO VALUES(numPasaporte_);
END;
//
DELIMITER ;
```

### Procedimiento que crea un político y una persona al mismo tiempo.
``` sql
DELIMITER //
CREATE OR REPLACE PROCEDURE insertar_politico (IN numPasaporte_ VARCHAR(64), IN nombre_ VARCHAR(32), IN primerApellido_ VARCHAR(32),
    IN segundoApellido_ VARCHAR(32), IN fnac_ DATE, IN sexo_ char(1), IN paisNacimiento_ INT UNSIGNED, IN fechaIniciacion_ DATE , IN fechaRetirada_ DATE,
    IN idCongreso_ INT UNSIGNED)
BEGIN
    INSERT INTO PERSONA VALUES(numPasaporte_, nombre_, primerApellido_, segundoApellido_, fnac_, sexo_, paisNacimiento_);
    INSERT INTO POLITICO VALUES(numPasaporte_, fechaIniciacion, fechaRetirada, idCongreso);
END;
//
DELIMITER ;
```

### Actualizar ciudadano y persona al mismo tiempo.
``` sql
DELIMITER //
CREATE OR REPLACE PROCEDURE actualizar_ciudadano (IN numPasaporte_ VARCHAR(64), IN nombre_ VARCHAR(32), IN primerApellido_ VARCHAR(32),
    IN segundoApellido_ VARCHAR(32), IN fnac_ DATE, IN sexo_ char(1), IN paisNacimiento_ INT UNSIGNED)
BEGIN
    UPDATE PERSONA SET numPasaporte = numPasaporte_, nombre = nombre_, primerApellido = primerApellido_, 
        segundoApellido = segundoApellido_, fnac = fnac_, sexo = sexo_, paisNacimiento = paisNacimiento_ 
            WHERE numPasaporte = numPasaporte_;
    UPDATE PERSONA SET numPasaporte = numPasaporte_ WHERE numPasaporte = numPasaporte_;
END;
//
DELIMITER ;
```


### Actualizar político y persona al mismo tiempo.
``` sql
DELIMITER //
CREATE OR REPLACE PROCEDURE actualizar_politico (IN numPasaporte_ VARCHAR(64), IN nombre_ VARCHAR(32), IN primerApellido_ VARCHAR(32),
    IN segundoApellido_ VARCHAR(32), IN fnac_ DATE, IN sexo_ char(1), IN paisNacimiento_ INT UNSIGNED, IN fechaIniciacion_ DATE , IN fechaRetirada_ DATE,
    IN idCongreso INT UNSIGNED)
BEGIN
    UPDATE PERSONA SET numPasaporte = numPasaporte_, nombre = nombre_, primerApellido = primerApellido_, 
        segundoApellido = segundoApellido_, fnac = fnac_, sexo = sexo_, paisNacimiento = paisNacimiento_ 
            WHERE numPasaporte = numPasaporte_;
    UPDATE POLITICO SET numPasaporte = numPasaporte_, fechaIniciacion = fechaIniciacion_, fechaRetirada = fechaRetirada_, idCongreso = idCongreso_
        WHERE numPasaporte = numPasaporte_;
END;
//
DELIMITER ;
```