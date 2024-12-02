CREATE DATABASE IF NOT EXISTS RPI;

USE RPI;

CREATE TABLE PAIS (
    nombre VARCHAR(64),
    CONSTRAINT PK_PAIS PRIMARY KEY (nombre)
);

CREATE TABLE CODIGO_CIVIL(
    id INT UNSIGNED AUTO_INCREMENT,
    nombrePais VARCHAR(64) NOT NULL,
    CONSTRAINT PK_CODIGO_CIVIL PRIMARY KEY (id),
    CONSTRAINT FK_CODIGO_CIVIL_PAIS FOREIGN KEY (nombrePais) REFERENCES PAIS(nombre)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
    CONSTRAINT UK_CODIGO_CIVIL_NOMBRE_PAIS UNIQUE KEY (nombrePais)
);

CREATE TABLE CONGRESO(
    id INT UNSIGNED AUTO_INCREMENT,
    nombrePais VARCHAR(64) NOT NULL,
    CONSTRAINT PK_CONGRESO PRIMARY KEY (id),
    CONSTRAINT FK_CONGRESO_PAIS FOREIGN KEY (nombrePais) REFERENCES PAIS(nombre)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
    CONSTRAINT UK_CONGRESO_NOMBRE_PAIS UNIQUE KEY (nombrePais)
);

CREATE TABLE PERSONA(
    numPasaporte VARCHAR(16),
    nombre VARCHAR(32) NOT NULL,
    primerApellido VARCHAR(32),
    segundoApellido VARCHAR(32),
    fnac DATE NOT NULL,
    sexo ENUM ('H', 'M'),
    paisNacimiento VARCHAR(64) NOT NULL,
    CONSTRAINT PK_PERSONA PRIMARY KEY (numPasaporte),
    CONSTRAINT FK_PERSONA_PAIS FOREIGN KEY (paisNacimiento) REFERENCES PAIS(nombre)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
 );

CREATE TABLE POLITICO(
    numPasaporte VARCHAR(16),
    fechaIniciacion DATE NOT NULL,
    fechaRetirada DATE,
    idCongreso INT UNSIGNED NOT NULL,
    CONSTRAINT PK_POLITICO PRIMARY KEY (numPasaporte),
    CONSTRAINT CK_POLITICO_FECHA_RETIRADA CHECK (fechaRetirada > fechaIniciacion),
    CONSTRAINT FK_POLITICO_PERSONA FOREIGN KEY (numPasaporte) REFERENCES PERSONA(numPasaporte)
        ON DELETE NO ACTION 
        ON UPDATE CASCADE,
    CONSTRAINT FK_POLITICO_CONGRESO FOREIGN KEY (idCongreso) REFERENCES CONGRESO(id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);

CREATE TABLE CIUDADANO(
    numPasaporte VARCHAR(16),
    CONSTRAINT PK_CIUDADANO PRIMARY KEY (numPasaporte),
    CONSTRAINT FK_CIUDADANO_PERSONA FOREIGN KEY (numPasaporte) REFERENCES PERSONA(numPasaporte)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

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
        ON UPDATE NO ACTION
);

CREATE TABLE PROPUESTA(
    id INT UNSIGNED AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    descripcion VARCHAR(2000) NOT NULL,
    fechaExpiracion DATE,
    estado ENUM('ACEPTACION', 'PUBLICACION', 'VOTACION', 'TERMINADA') NOT NULL,
    idCongreso INT UNSIGNED NOT NULL,
    numPasaportePolitico VARCHAR(16) NOT NULL,
    fechaProsicion DATE NOT NULL,
    fechaAceptacion DATE,
    fechaPublicacion DATE,
    CONSTRAINT PK_PROPUESTA PRIMARY KEY (id),
    CONSTRAINT FK_PROPUESTA_CONGRESO FOREIGN KEY (idCongreso) REFERENCES CONGRESO(id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
    CONSTRAINT FK_PROPUESTA_POLITICO FOREIGN KEY (numPasaportePolitico) REFERENCES POLITICO(numPasaporte)
        ON DELETE NO ACTION
        ON UPDATE CASCADE
);

CREATE TABLE DESARROLLAR (
    idPropuesta INT UNSIGNED,
    idLey INT UNSIGNED,
    CONSTRAINT PK_DESARROLLAR PRIMARY KEY (idPropuesta, idLey),
    CONSTRAINT FK_DESARROLLAR_PROPUESTA FOREIGN KEY (idPropuesta) REFERENCES PROPUESTA(id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
    CONSTRAINT FK_DESARROLLAR_LEY FOREIGN KEY (idLey) REFERENCES LEY(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE VOTAR(
    numPasaporteCiudadano VARCHAR(16),
    idPropuesta INT UNSIGNED,
    decision BOOLEAN NOT NULL,
    CONSTRAINT PK_VOTAR PRIMARY KEY (numPasaporteCiudadano, idPropuesta),
    CONSTRAINT FK_VOTAR_CIUDADANO FOREIGN KEY (numPasaporteCiudadano) REFERENCES CIUDADANO(numPasaporte)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT FK_VOTAR_PROPUESTA FOREIGN KEY (idPropuesta) REFERENCES PROPUESTA(id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);