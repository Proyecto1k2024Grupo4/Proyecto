CREATE TABLE PROPUESTA(
    id INT UNSIGNED AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    descripcion VARCHAR(2000) NOT NULL,
    fechaExpiracion DATE,
    estado ENUM('ACEPTACION', 'PUBLICACION', 'VOTACION', 'TERMINADA') NOT NULL,
    idCongreso INT UNSIGNED NOT NULL,
    numPasaportePolitico VARCHAR(16) NOT NULL,
    fechaProposicion DATE NOT NULL,
    fechaAceptacion DATE,
    fechaPublicacion DATE,
    CONSTRAINT PK_PROPUESTA PRIMARY KEY (id),
    CONSTRAINT FK_PROPUESTA_CONGRESO FOREIGN KEY (idCongreso) REFERENCES CONGRESO(id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
    CONSTRAINT FK_PROPUESTA_POLITICO FOREIGN KEY (numPasaportePolitico) REFERENCES POLITICO(numPasaporte)
        ON DELETE NO ACTION
        ON UPDATE CASCADE,
    CONSTRAINT CK_PROPUESTA_FECHA_ACEPTACION CHECK (fechaAceptacion > fechaProposicion),
    CONSTRAINT CK_PROPUESTA_FECHA_PUBLICACION CHECK (fechaPublicacion > fechaProposicion),
    CONSTRAINT CK_PROPUESTA_FECHA_EXPIRACION CHECK (fechaExpiracion > fechaPublicacion)
);