DELIMITER //
CREATE PROCEDURE eliminar(IN numPasaporte_ VARCHAR(16))
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