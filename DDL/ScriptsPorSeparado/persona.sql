CREATE TABLE PERSONA(
    numPasaporte VARCHAR(16),
    nombre VARCHAR(32) NOT NULL,
    primerApellido VARCHAR(32),
    segundoApellido VARCHAR(32),
    fnac DATE NOT NULL,
    sexo ENUM ('H', 'M'),
    paisNacimiento INT UNSIGNED NOT NULL,
    CONSTRAINT PK_PERSONA PRIMARY KEY (numPasaporte),
    CONSTRAINT FK_PERSONA_PAIS FOREIGN KEY (paisNacimiento) REFERENCES PAIS(id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
 );