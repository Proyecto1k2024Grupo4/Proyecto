CREATE TABLE CODIGO_CIVIL(
    id INT UNSIGNED AUTO_INCREMENT,
    nombrePais VARCHAR(64) NOT NULL,
    CONSTRAINT PK_CODIGO_CIVIL PRIMARY KEY (id),
    CONSTRAINT FK_CODIGO_CIVIL_PAIS FOREIGN KEY (nombrePais) REFERENCES PAIS(nombre)
);