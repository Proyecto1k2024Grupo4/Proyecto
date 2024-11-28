CREATE TABLE LEY(
    id INT UNSIGNED,
    descripcion VARCHAR(2000) NOT NULL,
    fechaAplicacion DATE,
    fechaModificacion DATE,
    fechaImplementacion DATE,
    idCodigoCivil INT UNSIGNED,
    CONSTRAINT PK_LEY PRIMARY KEY (id),
    CONSTRAINT FK_LEY_CODIGO_CIVIL FOREIGN KEY (idCodigoCivil) REFERENCES CODIGO_CIVIL(id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION

);