# Proyecto: 
Sistema de Gestión de Votaciones y Propuestas de Reforma Legal a Nivel Internacional

### Participantes:
- [Diego Fernando Valencia Correa](https://github.com/DocD1306)
- [Pablo Bernabeu Robles](https://github.com/bernabeu17)
- [Jonathan Villalba Moran](https://github.com/JonathanWick21)
- [Abdel Moghit Samini](https://github.com/Samini04)

### Descripción del proyecto:
Somos una **organización mundial** conformada por varios países y queremos almacenar las votaciones de propuestas de reforma de ley de cada país.

De cada **ciudadano** que esté capacitado (ha pasado por una prueba de conocimentos mínimos) para votar se desea conocer su nombre, apellidos, sexo, fecha de nacimiento, pasaporte y país de nacimiento.

De los **políticos** también queremos saber su nombre, apellidos, sexo, fecha de nacimiento, pasaporte, fecha en la que tomaron el cargo y fecha en la que se retiraron (en caso de que lo hayan hecho). Estos proponen propuestas y queremos almacenar el número de propuestas que han iniciado.

Un ciudadano capacitado puede opositar para convertirse en político, aunque también pueden haber ciudadanos no capacitados (de los cuales no guardamos información) que opositen y se conviertan en políticos directamente.

Los políticos forman un **congreso**, el cual hace una votación para decidir si hacer públicas las propuestas y del cual queremos saber el número de propuestas que han aceptado para ser públicas, además queremos saber el número de políticos que lo conforma.

De las **propuestas** necesitamos saber su código, su título, su descripción, la fecha de presentación al congreso, la fecha de publicación, la fecha en la que acaba el plazo de su votación, el número total de votos, los votos a favor y los votos en contra.

Las propuestas pueden ser votadas por los ciudadanos capacitados pero no por los políticos. Las propuestas pueden ser votadas únicamente por ciudadanos que hayan nacido en el país en el que se publica la propuesta. Para que la votación sea valida tienen que votar como mínimo el 51% de los ciudadanos. Para que la propuesta sea aceptada ha de tener mínimo un 51% de votos a favor.

Las propuestas desarrollan **leyes**, de las que deseamos conocer su código identificativo, su descripción, fecha de última modificación, fecha de primera implementación y la fecha en la que se aplican sus efectos.

Las leyes forman un **código civil**, del que necesitamos conocer, su código identificadivo, la cantidad de leyes que lo conforman y fecha de última modificación.

El código civil rige a un **país** (del que se quiere conocer su nombre, cantidad de políticos y ciudadanos capacitados que tiene) y un país solo puede ser regido por un único código civil. 

### Modelo Entidad-Relación

![image](https://github.com/user-attachments/assets/286a4e48-9f22-4737-ba12-0a234fe314d5)

En país hemos puesto como atributos derivados el número de ciudadanos y políticos ya que eso se conoce por la relación que existe entre ellos. Lo mismo pasa con los demás atributos derivados que aparecen, como por ejemplo: Codigo civil y número de leyes o Propuesta y votos.

Hemos creado una superclase PERSONA para almacenar los datos de POLITICO y CIUDADANO porque ambos comparten muchos atributos iguales. Es una relación total porque todas las personas que almacenamos en el sitema son obligatoriamente o un POLITICO o un CIUDADANO y además es una generalización disjunta porque un POLITICO no puede ser un CIUDADANO ni viceversa.

En el modelo entidad relación que hemos creado, las propuestas tienen un id único independientemente del páis que sea, es decir, si en Estados Unidos se crea una propuesta con el id 1, no puede haber una propuesta en el Reino Unido con el mismo id.

En político hay un atributo derivado "estado" que indica si está retirado o no y viene de las fechas de iniciación y retirada. La fecha de retirada debe ser posterior a la fecha de iniciación.

La fecha de proposición es anterior a la fecha de aceptación, la fecha de aceptación es anterior a la fecha de publicación y la fecha de publicación es anterior a la fecha de expiración. La fecha de expiración puede ser anterior o igual a la fecha de modificación o implementación. La fecha de aplicación debe ser posterior a la fecha de modificación o implementación.

El estado de una propuesta es dictaminado por las fechas entre las que se encuentre, es decir, si una propuesta ha sido presentada al congreso y todavía no se ha aceptado, se encuentra en estado de aceptación.

La entidad LEY representa una ley en concreto. Cuando una propuesta desarrolla una ley, si la crea, su fecha de implementación y modificación serán la misma, ya que la fecha de implementación indica cuando se creó dicha ley.


### Modelo Relacional

``` 
PAIS (_nombre_)  
    PK (nombre)

CONGRESO (_id_, nombrePais*)
    PK (id)
    FK (nombrePais) -> PAIS
    VNN (nombrePais)
    UK (nombrePais)

PERSONA (_numPasaporte_, nombre, primerApellido, segundoApellido, fnac, sexo, paisNacimiento*)
    PK (numPasaporte)
    FK (paisNacimiento) -> PAIS
    VNN (paisNacimiento, nombre, fnac)

POLITICO (_numPasaporte_*, fechaIniciacion, fechaRetirada, idCongreso*)
    PK (numPasaporte)
    FK (numPasaporte) -> PERSONA
       (idCongreso) -> CONGRESO
    VNN (idCongreso, fechaIniciacion)

CIUDADANO (_numPasaporte_*)
    PK (numPasaporte)
    FK (numPasaporte) -> PERSONA

PROPUESTA (_id_, titulo, descripcion, fechaExpiracion, estado, idCongreso*, numPasaportePolitico*, fechaProposicion, fechaAceptacion, fechaPublicacion)
    PK (id)
    FK (idCongreso) -> CONGRESO
       (numPasaportePolitico) -> POLITICO
    VNN (idCongreso, numPasaportePolitico, titulo, descripcion, estado, fechaProposicion)

VOTAR (_numPasaporteCiudadano_*, _idPropuesta_*, decision)
    PK (numPasaporteCiudadano, idPropuesta)
    FK (numPasaporteCiudadano) -> CIUDADANO
       (idPropuesta) -> PROPUESTA
    VNN (decision)

CODIGO_CIVIL (_id_, nombrePais*)
    PK (id)
    FK (nombrePais) -> PAIS
    VNN (nombrePais)
    UK (nombrePais)

LEY (_id_, descripcion, fechaAplicacion, fechaModificacion, fImplementacion, idCodigoCivil*)
    PK (id)
    FK (idCodigoCivil) -> CODIGO_CIVIL
    VNN (idCodigoCivil, descripcion, fechaImplementacion)
  
DESARROLLAR (_idPropuesta_*, _idLey_*)
    PK (idPropuesta, idLey)
    FK (idPropuesta) -> PROPUESTA
       (idLey) -> LEY
```

En el modelo relacional no se ha incluido la relación entre ciudadano y político debido a que cuando un ciudadano capacitado oposita para político y accede al cargo se eliminan sus datos del registro de ciudadanos capacitados, ya que un político no puede votar.

### Diccionario de Datos

**PAIS**
| Columna | Tipo de Dato | Descripción |
|--------------|--------------|--------------|
| nombre | VARCHAR(64) | Clave primaria. Nombre del país |


**CONGRESO**
| Columna | Tipo de Dato | Descripción |
|--------------|--------------|--------------|
| id | INT | Clave primaria. Número que identifica al congreso |
| nombrePais | VARCHAR(64) | Clave foránea y única que apunta a PAIS.nombre e indica el país al que pertenece el congreso. |


**PERSONA**
| Columna | Tipo de Dato | Descripción |
|--------------|--------------|--------------|
| numPasaporte | VARCHAR(16) | Clave primaria. Indica el número de pasaporte de la persona |
| nombre | VARCHAR(32) | Nombre de la persona |
| primerApellido | VARCHAR (32) | Primer apellido de la persona |
| segundoApellido | VARCHAR (32) | Segundo apellido de la persona |
| fnac | DATE | Fecha de nacimiento de la persona |
| sexo | ENUM | Género biológico de la persona |
| paisNacimiento | VARCHAR(64) | Clave foránea que apunta a PAIS.nombre e indica el país en el que nació la persona |


**POLITICO**
| Columna | Tipo de Dato | Descripción |
|--------------|--------------|--------------|
| numPasaporte | VARCHAR(16) | Clave primaria y foránea que apunta a PERSONA.numPasaporte e indica el número de pasaporte del político |
| fechaIniciacion | DATE | Indica la fecha en la que el político tomó su cargo |
| fechaRetirada | DATE | Indica la fecha en la que el político se retíro de su cargo |
| idCongreso | INT | Clave foránea que apunta a CONGRESO.id e indica el congreso al que pertenece el político |


**CIUDADANO**
| Columna | Tipo de Dato | Descripción |
|--------------|--------------|--------------|
| numPasaporte | VARCHAR(16) | Clave primaria y foránea que apunta a PERSONA.numPasaporte e indica el número de pasaporte del ciudadano |


**PROPUESTA**
| Columna | Tipo de Dato | Descripción |
|--------------|--------------|--------------|
| id | INT | Clave primaria. Número que identifica la propuesta |
| titulo | VARCHAR(100) | Titulo de la propuesta |
| descripcion | VARCHAR(2000) | Descripción de la propuesta |
| fechaExpiracion | DATE | Fecha en la que termina el plazo para votar la propuesta |
| estado | ENUM | Indica el estado/fase en la que se encuentra la propuesta |
| idCongreso | INT | Clave foránea que apunta a CONGRESO.id e indica el congreso que acepta la propuesta para que sea pública |
| numPasaportePolitico | VARCHAR(16) | Clave foránea que apunta a POLITICO.numPasaporte e indica el político que inició la propuesta |
| fechaProposicion | DATE | Indica la fecha en la que la se presentó la propuesta al congreso |
| fechaAceptacion | DATE | Indica la fecha en la que el congresó aceptó o no la propuesta para que fuese pública |
| fechaPublicacion | DATE | Indica la fecha en la que, después de ser aceptada por el congreso, la propuesta se hizo pública |


**VOTAR**
| Columna | Tipo de Dato | Descripción |
|--------------|--------------|--------------|
| numPasaporteCiudadano | VARCHAR(16) | Clave primaria y foránea que apunta a CIUDADANO.numPasaporte e indica qué ciudadano vota  |
| idPropuesta | INT | Clave primaria y foránea que apunta a PROPUESTA.id e indica la propuesta a la que se vota |
| decision | BOOLEAN | Indica si el voto fué a favor o en contra |


**CODIGO_CIVIL**
| Columna | Tipo de Dato | Descripción |
|--------------|--------------|--------------|
| id | INT | Clave primaria. Número que identifica el código civil |
| nombrePais | VARCHAR(64) | Clave foránea y única que apunta a PAIS.nombre e indica el país a que pertenece el código civil |


**LEY**
| Columna | Tipo de Dato | Descripción |
|--------------|--------------|--------------|
| id | INT | Clave primaria. Número que identifica una ley |
| descripcion | VARCHAR(2000) | Descripción de la ley |
| fechaAplicacion | DATE | Fecha en la que se aplican los efectos de la ley |
| fechaModificacion | DATE | Fecha en la que se modifica la ley |
| fImplementacion | DATE | Fecha de la vez en la que se creó la ley |
| idCodigoCivil | INT | Clave foránea que apunta a CODIGO_CIVIL.id e indica el código civil al que pertenece la ley |


**DESARROLLAR**
| Columna | Tipo de Dato | Descripción |
|--------------|--------------|--------------|
| idPropuesta | INT | Clave primaria y foránea que apunta a PROPUESTA.id e indica la propuesta que desarrolla a una ley |
| idLey | INT | Clave primaria y foránea que apunta a LEY.id e indica la ley que se está desarrollando |


### Restricciones de modificaciones/eliminaciones en tablas

**Eliminaciones RECHAZADAS**

La eliminacion de cualquier instancia de las siguientes entidades se rechazará:

- **PAIS**
- **CONGRESO**
- **CODIGO_CIVIL**
- **PROPUESTA**
- **POLITICO**


**Eliminaciones PROPAGADAS**

La eliminación de cualquier instancia de las siguientes entidades se propagará, es decir, se borrará la instancia y todas las instancias que apunten a esta

- **LEY**
- **PERSONA**


**Eliminaciones ANULADAS**

La eliminacion de cualquier instancia de las siguientes entidades se anulará, es decir, se eliminará la instancia y en las claves foráneas que apunten a esta se marcarán como nulas:

- **CIUDADANO**


**Modificaciones RECHAZADAS**

La modificación de cualquier instancia de las siguientes entidades se rechazará:

- **PAIS**
- **CODIGO_CIVIL**
- **CONGRESO**
- **PROPUESTA**

**Modificaciones PROPAGADAS**

La modificación de cualquier instancia de las siguientes entidades será propagada, es decir, se modificará la instancia y todos los campos que la referencien desde otras instancias:

- **PERSONA**
- **POLITICO**
- **CIUDADANO**
- **LEY**


### Instrucciones DDL 

```
CREATE DATABASE IF NOT EXISTS RPI;

USE RPI;

CREATE TABLE PAIS (
    id INT UNSIGNED AUTO_INCREMENT,
    nombre VARCHAR(64),
    CONSTRAINT PK_PAIS PRIMARY KEY (id)
);

CREATE TABLE CODIGO_CIVIL(
    id INT UNSIGNED AUTO_INCREMENT,
    idPais INT UNSIGNED NOT NULL,
    CONSTRAINT PK_CODIGO_CIVIL PRIMARY KEY (id),
    CONSTRAINT FK_CODIGO_CIVIL_PAIS FOREIGN KEY (idPais) REFERENCES PAIS(id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
    CONSTRAINT UK_CODIGO_CIVIL_NOMBRE_PAIS UNIQUE KEY (idPais)
);

CREATE TABLE CONGRESO(
    id INT UNSIGNED AUTO_INCREMENT,
    idPais INT UNSIGNED NOT NULL,
    CONSTRAINT PK_CONGRESO PRIMARY KEY (id),
    CONSTRAINT FK_CONGRESO_PAIS FOREIGN KEY (idPais) REFERENCES PAIS(id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
    CONSTRAINT UK_CONGRESO_NOMBRE_PAIS UNIQUE KEY (idPais)
);

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
        ON UPDATE NO ACTION,
    CONSTRAINT CK_LEY_FECHA_APLICACION CHECK (fechaAplicacion > fechaImplementacion),
    CONSTRAINT CK_LEY_FECHA_MODIFICACION CHECK (fechaModificacion >= fechaImplementacion)
);

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
```

Se han seguido todas las restricciones sobre modificación/eliminación en la creación de las instrucciones DDL, además se han utilizado checks para verificar que ciertas fechas sean posteriores a otras.

El tipo de datos de los atributos en las tablas de las instrucciones DDL es acorde al diccionario de datos.

#### Script para vaciar todas las tablas

```
use RPI;

set foreign_key_checks = 0;

TRUNCATE TABLE CIUDADANO;
TRUNCATE TABLE CODIGO_CIVIL;
TRUNCATE TABLE CONGRESO;
TRUNCATE TABLE DESARROLLAR;
TRUNCATE TABLE PAIS;
TRUNCATE TABLE LEY;
TRUNCATE TABLE PERSONA;
TRUNCATE TABLE POLITICO;
TRUNCATE TABLE PROPUESTA;
TRUNCATE TABLE VOTAR;

set foreign_key_checks = 1;
```

### Instrucciones DML

```
INSERT INTO PAIS(nombre) VALUES
("España"),
("Colombia"),
("Estados Unidos"),
("Rusia"),
("China"),
("Mongolia"),
("Italia"),
("Grecia"),
("Francia"),
("Reino Unido");

INSERT INTO CONGRESO(idPais) VALUES 
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10);

INSERT INTO CODIGO_CIVIL(idPais) VALUES 
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10);

INSERT INTO PERSONA(numPasaporte, nombre, primerApellido, segundoApellido, fnac, sexo, paisNacimiento) VALUES
("123456789A", "Desiderio", "Alcazares", "Segundo", '2000/1/10', 'H', 1),
("234567891A", "Juan", "Pericles", NULL, '1900/2/10', 'H', 1),
("345678912A", "Pepe", "Villuela", "Morcon", '1966/3/19', 'M', 1),
("456789123A", "Maria", "Unpa", "Lumpa", '2001/9/11', 'M', 1),
("12345678B", "Lucia", NULL, "Artida", '1995/3/10', 'M', 2),
("23456789B", "Cullera", "Macia", "Roberto", '2006/4/25', 'H', 2),
("34567891B", "Alpa", "Chino", "Mandarino", '1996/3/10', 'H', 2),
("A1234567C", "Wilson", "Jackson", "Person", '2001/5/1', 'H', 3),
("A2345678C", "Tracy", "Mary", "Larson", '1999/5/10', 'M', 3),
("12345678901D", "Bladimyr", "Bostov", "Artyom", '1997/6/15', 'H', 4),
("23456789012D", "Marie", "Azkaya", "Ligla", '1980/9/15', 'M', 4),
("12345E", "Xi", "Ginpin", "Tzu", '1997/6/15', 'H', 5),
("23456E", "Xensue", "Laocao", "Lu", '2002/8/17', 'H', 5),
("123456789F", "Gengis", "Khan", "Yangau", '2002/9/17', NULL, 6),
("234567891F", "Curimi", "Bukyak", "Nica", '1980/9/13', 'H', 6),
("123G", "Pesto", "Di", "Cuesto", '1998/10/6', 'H', 7),
("234G", "Carabina", "Na", "Politana", '1990/10/26', 'M', 7),
("1234567890123H", "Yikmir", "Amir", "Palir", '1980/11/30', 'H', 8),
("2345678901234H", "Bracut", "Nagal", "Sinsi", '1960/1/30', 'H', 8),
("123456I", "Bagguette", "Croisant", "Eifel", '1999/12/1', 'H', 9),
("234567I", "Wi", "Wi", "Lacamoua", '2003/12/2', 'M', 9),
("23456789J", "Charles", "Darwin", "Natural", '1950/2/2', 'H', 10),
("12345678J", "Isabel", "The", "Queen", '1200/1/25', 'M', 10);


INSERT INTO POLITICO(numPasaporte, fechaIniciacion, fechaRetirada, idCongreso) VALUES
("123456789A", '2008/5/5', NULL, 1),
("345678912A", '2010/8/15', NULL, 1),
("34567891B", '2009/6/3', '2010/8/5', 2),
("12345678B", '2009/5/5', NULL, 2),
("A1234567C", '2010/5/5', NULL, 3),
("23456789012D", '2011/5/5', NULL, 4),
("12345E", '2008/5/5', NULL, 5),
("234567891F", '2008/5/5', NULL, 6),
("234G", '2009/5/5', NULL, 7),
("2345678901234H", '2009/5/5', NULL, 8),
("123456I", '2012/5/5', NULL, 9),
("23456789J", '2012/5/5', NULL, 10);


INSERT INTO CIUDADANO(numPasaporte) VALUES
("234567891A"),
("456789123A"),
("23456789B"),
("A2345678C"),
("12345678901D"),
("23456E"),
("123456789F"),
("123G"),
("1234567890123H"),
("234567I"),
("12345678J");

INSERT INTO LEY(descripcion, fechaAplicacion, fechaModificacion, fechaImplementacion, idCodigoCivil) VALUES
("Ley de Salud", '2030/1/1','1999/1/1','1998/1/1',1),
("Ley de Salud", '2028/1/1','1999/1/3','1999/1/3',2),
("Ley de Justicia", '2026/1/5','2001/1/5','2001/1/1',3),
("Ley de Trabajadores", '2026/1/1','1998/1/1','1998/1/1',4),
("Ley de Perros", '2025/1/1','2023/2/3','2017/1/1',5),
("Ley de Gatos", NULL,'1998/6/2','1998/1/1',6),
("Ley de Pensiones", '2026/1/1', NULL,'1998/1/1',7),
("Ley de Comida", '2040/1/1','1998/1/2','1998/1/1',8),
("Ley de Turismo", NULL, NULL,'1998/1/1',9),
("Ley de Coches", NULL,'2024/5/2','2024/1/1',10);


INSERT INTO PROPUESTA(titulo, descripcion, fechaExpiracion, estado, idCongreso, numPasaportePolitico, fechaProposicion, fechaAceptacion, fechaPublicacion) VALUES
("Reforma ley de Salud", "Cambiar la ley de salud",'2025/2/2', "VOTACION", 1, "123456789A", '2023/2/2', '2024/2/3', '2024/12/15'),
("Reforma ley de Salud", "Cambiar la ley de salud",'2025/2/2', "VOTACION", 2, "12345678B", '2023/2/2', '2024/2/3', '2024/12/15'),
("Reforma ley de Perros", "Cambiar la ley de perros", NULL, "ACEPTACION", 3, "A1234567C", '2024/2/2', NULL, NULL),
("Reforma ley de Gatos", "Cambiar la ley de gatos", NULL, "PUBLICACION", 4, "23456789012D", '2023/2/2', '2023/3/2', NULL),
("Reforma ley de Perros", "Cambiar la ley de Perros",'2023/2/2', "TERMINADA", 5, "12345E", '2022/2/2', '2022/3/3', '2022/4/15'),
("Reforma ley de Comida", "Cambiar la ley de comida",'2026/2/2', "VOTACION", 6, "234567891F", '2023/2/2', '2023/3/3', '2024/4/15'),
("Reforma ley de Comida", "Cambiar la ley de comida",'2026/2/2', "VOTACION", 6, "234567891F", '2024/2/2', '2024/3/3', '2024/4/15'),
("Reforma ley de Turismo", "Cambiar la ley de turismo",'2027/2/2', "VOTACION", 7, "234G", '2023/2/2', '2023/3/3', '2024/4/15'),
("Reforma ley de Coches", "Cambiar la ley de coches",'2027/2/2', "VOTACION", 8, "2345678901234H", '2023/2/2', '2023/3/3', '2024/4/15'),
("Reforma ley de Justicia", "Cambiar la ley de justicia",'2027/2/2', "VOTACION", 9, "123456I", '2023/2/2', '2023/3/3', '2024/4/15'),
("Reforma ley de Justicia", "Cambiar la ley de justicia",'2027/2/2', "VOTACION", 10, "23456789J", '2023/2/2', '2023/3/3', '2024/4/15');


INSERT INTO VOTAR(numPasaporteCiudadano, idPropuesta, decision) VALUES
("234567891A", 1, TRUE),
("456789123A", 1, TRUE),
("23456789B", 2, FALSE),
("23456E", 5, TRUE),
("123456789F", 6, TRUE),
("123G", 7, TRUE),
("1234567890123H", 8, FALSE),
("234567I", 9, TRUE),
("12345678J", 10, FALSE);

INSERT INTO DESARROLLAR(idPropuesta, idLey) VALUES 
(5, 5);
```

Solo se ha añadido un registro en DESARROLLAR porque solo hay una propuesta terminada

Se han añadido menos registros en VOTAR porque no todas las propuestas están en votación o terminadas
