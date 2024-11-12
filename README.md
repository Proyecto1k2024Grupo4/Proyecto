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

De los **políticos** también queremos saber su nombre, apellidos, sexo, fecha de nacimiento, pasaporte y además la fecha en la que tomaron el cargo. Estos proponen propuestas y queremos almacenar el número de propuestas que han iniciado.

Un ciudadano capacitado puede opositar para convertirse en político, aunque también pueden haber ciudadanos no capacitados (de los cuales no guardamos información) que opositen y se conviertan en políticos directamente.

Los políticos forman un **congreso**, el cual hace una votación para decidir si hacer públicas las propuestas y del cual queremos saber el número de propuestas que han aceptado para ser públicas, además queremos saber el número de políticos que lo conforma.

De las **propuestas** necesitamos saber su código, su título, su descripción, la fecha de presentación al congreso, la fecha de publicación, la fecha en la que acaba el plazo de su votación, el número total de votos, los votos a favor y los votos en contra.

Las propuestas pueden ser votadas por los ciudadanos capacitados pero no por los políticos. Las propuestas pueden ser votadas únicamente por ciudadanos que hayan nacido en el país en el que se publica la propuesta. Para que la votación sea valida tienen que votar como mínimo el 51% de los ciudadanos. Para que la propuesta sea aceptada ha de tener mínimo un 51% de votos a favor.

Las propuestas desarrollan **leyes**, de las que deseamos conocer su código identificativo, su descripción, fecha de última modificación, fecha de primera implementación y la fecha en la que se aplican sus efectos.

Las leyes forman un **código civil**, del que necesitamos conocer, su código identificadivo, la cantidad de leyes que lo conforman y fecha de última modificación.

El código civil rige a un **país** (del que se quiere conocer su nombre, cantidad de políticos y ciudadanos capacitados que tiene) y un país solo puede ser regido por un único código civil. 

### Modelo Entidad-Relación

![image (1)](https://github.com/user-attachments/assets/3c6bcb00-c5f3-4f60-9b57-262b172e94b7)

En país hemos puesto como atributos derivados el número de ciudadanos y políticos ya que eso se conoce por la relación que existe entre ellos. Lo mismo pasa con los demás atributos derivados que aparecen, como por ejemplo: Codigo civil y número de leyes o Propuesta y votos.

Hemos creado una superclase PERSONA para almacenar los datos de POLITICO y CIUDADANO porque ambos comparten muchos atributos iguales.

En el modelo entidad relación que hemos creado, las propuestas tienen un id único independientemente del páis que sea, es decir, si en Estados Unidos se crea una propuesta con el id 1, no puede haber una propuesta en el Reino Unido con el mismo id.

La fecha de proposición es anterior a la fecha de aceptación, la fecha de aceptación es anterior a la fecha de publicación y la fecha de publicación es anterior a la fecha de expiración. La fecha de expiración puede ser anterior o igual a la fecha de modificación o implementación. La fecha de aplicación debe ser posterior a la fecha de modificación o implementación.

El estado de una propuesta es dictaminado por la fechas fechas entre las que se encuentre, es decir, si una propuesta ha sido presentada al congreso y todavía no se ha aceptado, se encuentra en estado de aceptación.

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


**DESARROLLAR**
| Columna | Tipo de Dato | Descripción |
|--------------|--------------|--------------|
| idPropuesta | INT | Clave primaria y foránea que apunta a PROPUESTA.id e indica la propuesta que desarrolla a una ley |
| idLey | INT | Clave primaria y foránea que apunta a LEY.id e indica la ley que se está desarrollando |

