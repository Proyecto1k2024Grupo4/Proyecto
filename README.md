# Proyecto: 
Sistema de Gestión de Votaciones y Propuestas de Reforma Legal a Nivel Internacional

### Participantes:
- [Diego Fernando Valencia Correa](https://github.com/DocD1306)
- [Pablo Bernabeu Robles](https://github.com/bernabeu17)
- [Jonathan Villalba Moran](https://github.com/JonathanWick21)
- [Abdel Moghit Samini](https://github.com/Samini04)

### Descripción del proyecto:
Somos una organización mundial conformada por varios países y queremos almacenar las votaciones de propuestas de reforma de ley de cada país.

De cada ciudadano que esté capacitado (ha pasado por una prueba de conocimentos mínimos) para votar se desea conocer su nombre, apellidos, sexo, fecha de nacimiento, pasaporte y país de nacimiento.

De los políticos también queremos saber su nombre, apellidos, sexo, fecha de nacimiento, pasaporte y además la fecha en la que tomaron el cargo. Estos proponen propuestas y queremos almacenar el número de propuestas públicas que han aportado y de esas propuestas, las que han sido aceptadas y las que han sido rechazadas por la población.

Un ciudadano capacitado puede opositar para convertirse en político, aunque también pueden haber ciudadanos no capacitados (de los cuales no guardamos información) que opositen y se conviertan en políticos directamente.

Los políticos forman un congreso, el cual hace una votación para decidir si hacer públicas las propuestas y del cual queremos saber el número de propuestas que han aceptado para ser públicas y de estas mismas las que han sido aceptadas o rechazadas por la población, además queremos saber el número de políticos que lo conforma.

De las propuestas necesitamos saber su código, la fecha de presentación al congreso, la fecha de publicación, la fecha en la que acaba el plazo de su votación, la descripción de la propuesta y el título.

Las propuestas pueden ser votadas por los ciudadanos capacitados pero no por los políticos. Las propuestas pueden ser votadas únicamente por ciudadanos que hayan nacido en el país en el que se publica la propuesta. Para que la votación sea valida tienen que votar como mínimo el 51% de los ciudadanos. Para que la propuesta sea aceptada ha de tener mínimo un 51% de votos a favor.

Las propuestas desarrollan leyes, de las que deseamos conocer su código identificativo, su descripción, fecha de última modificación, fecha de primera implementación y la fecha en la que se aplican sus efectos.

Las leyes forman un código civil, del que necesitamos conocer, su código identificadivo, la cantidad de leyes que lo conforman y fecha de última modificación.

El código civil rige a un país (del que se quiere conocer su nombre, cantidad de políticos y ciudadanos capacitados que tiene) y un país solo puede ser regido por un único código civil. 

### Modelo Entidad-Relación

![image](https://github.com/user-attachments/assets/2094ab2c-4eaf-4dc7-ab9a-057e69edd438)

Hemos creado una superclase PERSONA para almacenar los datos de POLITICO y CIUDADANO porque ambos comparten muchos atributos iguales.

La entidad LEY representa una ley en concreto

La fecha de expiración de una propuesta tiene que ser anterior a la fecha de aplicación de esta misma.


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
    VNN (paisNacimiento)

POLITICO (_numPasaporte_*, fechaIniciacion, idCongreso*)
    PK (numPasaporte)
    FK (numPasaporte) -> PERSONA
       (idCongreso) -> CONGRESO
    VNN (idCongreso)

CIUDADANO (_numPasaporte_*)
    PK (numPasaporte)
    FK (numPasaporte) -> PERSONA

PROPUESTA (_id_, titulo, descripcion, fechaExpiracion, estado, idCongreso*, numPasaportePolitico*, fechaProposicion, fechaAceptacion, fechaPublicacion)
    PK (id)
    FK (idCongreso) -> CONGRESO
       (numPasaportePolitico) -> POLITICO
    VNN (idCongreso)
        (numPasaportePolitico)

VOTAR (_numPasaporteCiudadano_*, _idPropuesta_*, decision)
    PK (numPasaporteCiudadano, idPropuesta)
    FK (numPasaporteCiudadano) -> CIUDADANO
       (idPropuesta) -> PROPUESTA

CODIGO_CIVIL (_id_, nombrePais*)
    PK (id)
    FK (nombrePais) -> PAIS
    VNN (nombrePais)
    UK (nombrePais)

LEY (_id_, descripcion, fechaAplicacion, fechaModificacion, fImplementacion, idCodigoCivil*)
    PK (id)
    FK (idCodigoCivil) -> CODIGO_CIVIL
    VNN (idCodigoCivil)
  
DESARROLLAR (_idPropuesta_*, _idLey_*)
    PK (idPropuesta, idLey)
    FK (idPropuesta) -> PROPUESTA
       (idLey) -> LEY
```

### Diccionario de Datos

**PAIS**
| Columna | Tipo de Dato | Descripción |
|--------------|--------------|--------------|
| nombre | VARCHAR(64) | Clave primaria. Nombre del país |


**CONGRESO**
| Columna | Tipo de Dato | Descripción |
|--------------|--------------|--------------|
| id | INT | Clave primaria. Número que identifica al congreso |
| nombrePais | VARCHAR(64) | Clave foránea que apunta a PAIS.nombre e indica el país al que pertenece el congreso. |


**PERSONA**
| Columna | Tipo de Dato | Descripción |
|--------------|--------------|--------------|
| numPasaporte | VARCHAR(32) | Clave primaria. Indica el número de pasaporte de la persona |
| nombre | VARCHAR(64) | Nombre de la persona |
| primerApellido | VARCHAR (32) | Primer apellido de la persona |
| segundoApellido | VARCHAR (32) | Segundo apellido de la persona |
| fnac | DATE | Fecha de nacimiento de la persona |
| sexo | VARCHAR(1) | Género biológico de la persona |
| paisNacimiento | VARCHAR(64) | Clave foránea que apunta a PAIS.nombre e indica el país en el que nació la persona |


**POLITICO**
| Columna | Tipo de Dato | Descripción |
|--------------|--------------|--------------|
| numPasaporte | VARCHAR(32) | Clave primaria y foránea que apunta a PERSONA.numPasaporte e indica el número de pasaporte del político |
| fechaIniciacion | DATE | Indica la fecha en la que el político tomó su cargo |
| idCongreso | INT | Clave foránea que apunta a CONGRESO.id e indica el congreso al que pertenece el político |


**CIUDADANO**
| Columna | Tipo de Dato | Descripción |
|--------------|--------------|--------------|
| numPasaporte | VARCHAR(32) | Clave primaria y foránea que apunta a PERSONA.numPasaporte e indica el número de pasaporte del ciudadano |


**PROPUESTA**
| Columna | Tipo de Dato | Descripción |
|--------------|--------------|--------------|
| id | INT | Clave primaria. Número que identifica la propuesta |
| titulo | VARCHAR(100) | Titulo de la propuesta |
| descripcion | VARCHAR(2000) | Descripción de la propuesta |
| fechaExpiracion | DATE | Fecha en la que termina el plazo para votar la propuesta |
| estado | VARCHAR(16) | Indica el estado/fase en la que se encuentra la propuesta |
| idCongreso | INT | Clave foránea que apunta a CONGRESO.id e indica el congreso que acepta la propuesta para que sea pública |
| numPasaportePolitico | VARCHAR(32) | Clave foránea que apunta a POLITICO.numPasaporte e indica el político que inició la propuesta |
| fechaProposicion | DATE | Indica la fecha en la que la se presentó la propuesta al congreso |
| fechaAceptacion | DATE | Indica la fecha en la que el congresó aceptó o no la propuesta para que fuese pública |
| fechaPublicacion | DATE | Indica la fecha en la que, después de ser aceptada por el congreso, la propuesta se hizo pública |


**VOTAR**
| Columna | Tipo de Dato | Descripción |
|--------------|--------------|--------------|
| numPasaporteCiudadano | VARCHAR(32) | Clave primaria y foránea que apunta a CIUDADANO.numPasaporte e indica qué ciudadano vota  |
| idPropuesta | INT | Clave primaria y foránea que apunta a PROPUESTA.id e indica la propuesta a la que se vota |
| decision | VARCHAR(1) | Indica si el voto fué a favor o en contra |


**CODIGO_CIVIL**
| Columna | Tipo de Dato | Descripción |
|--------------|--------------|--------------|
| id | INT | Clave primaria. Número que identifica el código civil |
| nombrePais | VARCHAR(64) | Clave foránea que apunta a PAIS.nombre e indica el país a que pertenece el código civil |


**LEY**
| Columna | Tipo de Dato | Descripción |
|--------------|--------------|--------------|
| id | INT | Clave primaria. Número que identifica una ley |
| descripcion | VARCHAR(2000) | Descripción de la ley |
| fechaAplicacion | DATE | Fecha en la que se aplican los efectos de la ley |
| fechaModificacion | DATE | Fecha en la que se modifica la ley |
| fImplementacion | DATE | Fecha de la vez en la que se creó la ley |
| idCodigoCivil | INT | Clave foránea que apunta a CODIGO_CIVIL.id e indica el código civil al que pertenece la ley |


**DESAROLLAR**
| Columna | Tipo de Dato | Descripción |
|--------------|--------------|--------------|
| idPropuesta | INT | Clave primaria y foránea que apunta a PROPUESTA.id e indica la propuesta que desarrolla a una ley |
| idLey | INT | Clave primaria y foránea que apunta a LEY.id e indica la ley que se está desarrollando |

