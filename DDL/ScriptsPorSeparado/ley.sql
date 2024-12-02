CREATE TABLE LEY(
    id INT UNSIGNED AUTO_INCREMENT,
    descripcion VARCHAR(2000) NOT NULL,
    fechaAplicacion DATE,
    fechaModificacion DATE,
    fechaImplementacion DATE NOT NULL,
    idCodigoCivil INT UNSIGNED NOT NULL,
    CONSTRAINT PK_LEY PRIMARY KEY (id),
    CONSTRAINT FK_LEY_CODIGO_CIVIL FOREIGN KEY (idCodigoCivil) REFERENCES CODIGO_CIVIL(id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
    CONSTRAINT CK_LEY_FECHA_APLICACION CHECK (fechaAplicacion > fechaImplementacion),
    CONSTRAINT CK_LEY_FECHA_MODIFICACION CHECK (fechaModificacion >= fechaImplementacion)
);