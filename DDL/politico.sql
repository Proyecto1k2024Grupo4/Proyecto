CREATE TABLE POLITICO(
    numPasaporte VARCHAR(16),
    fechaIniciacion DATE NOT NULL,
    idCongreso INT UNSIGNED NOT NULL,
    CONSTRAINT PK_POLITICO PRIMARY KEY (numPasaporte),
    CONSTRAINT FK_POLITICO_PERSONA FOREIGN KEY (numPasaporte) REFERENCES PERSONA(numPasaporte),
    CONSTRAINT FK_POLITICO_CONGRESO FOREIGN KEY (idCongreso) REFERENCES CONGRESO(id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);