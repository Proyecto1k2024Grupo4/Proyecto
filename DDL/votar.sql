CREATE TABLE VOTAR(
    numPasaporteCiudadano VARCHAR(16),
    idPropuesta INT UNSIGNED,
    decision BOOLEAN NOT NULL,
    CONSTRAINT PK_VOTAR PRIMARY KEY (numPasaporteCiudadano, idPropuesta),
    CONSTRAINT FK_VOTAR_CIUDADANO FOREIGN KEY (numPasaporteCiudadano) REFERENCES CIUDADANO(numPasaporte),
        ON DELETE SET NULL
        ON UPDATE CASCADE
    CONSTRAINT FK_VOTAR_PROPUESTA FOREIGN KEY (idPropuesta) REFERENCES PROPUESTA(id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);