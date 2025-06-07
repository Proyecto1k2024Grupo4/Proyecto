DELIMITER //
CREATE OR REPLACE PROCEDURE eliminar(IN numPasaporte_ VARCHAR(16))
Begin

    DECLARE esPolitico INT;
    SELECT COUNT(*) into esPolitico FROM POLITICO WHERE numPasaporte = numPasaporte_;

    IF (esPolitico > 0) THEN
        DELETE FROM POLITICO WHERE numPasaporte = numPasaporte_;
        DELETE FROM PERSONA where numPasaporte = numPasaporte_;
        
    ELSE
        DELETE FROM CIUDADANO WHERE numPasaporte = numPasaporte_;
        DELETE FROM PERSONA where numPasaporte = numPasaporte_;
    END IF;
END;
//
DELIMITER ;


Estas es para que al crear un politico si existe el ciudadano que lo borre
DELIMITER //
CREATE OR REPLACE PROCEDURE insertar_politico (IN numPasaporte_ VARCHAR(64), IN nombre_ VARCHAR(32), IN primerApellido_ VARCHAR(32),
IN segundoApellido_ VARCHAR(32), IN fnac_ DATE, IN sexo_ char(1), IN paisNacimiento_ INT UNSIGNED, IN fechaIniciacion_ DATE , IN fechaRetirada_ DATE,
IN idCongreso_ INT UNSIGNED)
BEGIN

    DECLARE existe INT;
    SELECT COUNT(*) INTO existe from CIUDADANO WHERE numPasaporte = numPasaporte_;
    
    IF (existe > 0) THEN
        DELETE FROM CIUDADANO WHERE numPasaporte = numPasaporte_;
        INSERT INTO POLITICO VALUES(numPasaporte_, fechaIniciacion_, fechaRetirada_, idCongreso_);
    ElSE
        INSERT INTO PERSONA VALUES(numPasaporte_, nombre_, primerApellido_, segundoApellido_, fnac_, sexo_, paisNacimiento_);
        INSERT INTO POLITICO VALUES(numPasaporte_, fechaIniciacion_, fechaRetirada_, idCongreso_);
    END IF;
END;
//
DELIMITER ;

DELIMITER //
CREATE OR REPLACE PROCEDURE actualizar_politico (IN numPasaporte_ VARCHAR(64), IN nombre_ VARCHAR(32), IN primerApellido_ VARCHAR(32),
IN segundoApellido_ VARCHAR(32), IN fnac_ DATE, IN sexo_ char(1), IN paisNacimiento_ INT UNSIGNED, IN fechaIniciacion_ DATE , IN fechaRetirada_ DATE,
IN idCongreso_ INT UNSIGNED)
BEGIN
UPDATE PERSONA SET numPasaporte = numPasaporte_, nombre = nombre_, primerApellido = primerApellido_,
segundoApellido = segundoApellido_, fnac = fnac_, sexo = sexo_, paisNacimiento = paisNacimiento_
WHERE numPasaporte = numPasaporte_;
UPDATE POLITICO SET numPasaporte = numPasaporte_, fechaIniciacion = fechaIniciacion_, fechaRetirada = fechaRetirada_, idCongreso = idCongreso_
WHERE numPasaporte = numPasaporte_;
END;
//
DELIMITER ;