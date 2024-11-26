CREATE TABLE PERSONA(
    numPasaporte VARCHAR(16),
    nombre VARCHAR(32) NOT NULL,
    primerApellido VARCHAR(32),
    segundoApellido VARCHAR(32),
    fnac DATE,
    sexo CHAR(1),
    paisNacimiento VARCHAR(64) NOT NULL,
    CONSTRAINT PK_PERSONA PRIMARY KEY (numPasaporte),
    CONSTRAINT FK_PERSONA_PAIS FOREIGN KEY (paisNacimiento) REFERENCES PAIS(nombre)
 );