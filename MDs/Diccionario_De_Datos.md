### Diccionario de Datos

**PAIS**
| Columna | Tipo de Dato | Descripción |
|--------------|--------------|--------------|
| id | INT |Clave primaria. Número identificador del país. |
| nombre | VARCHAR(64) |Nombre del país |


**CONGRESO**
| Columna | Tipo de Dato | Descripción |
|--------------|--------------|--------------|
| id | INT | Clave primaria. Número que identifica al congreso |
| idPais | INT | Clave foránea y única que apunta a PAIS.id e indica el país al que pertenece el congreso. |


**PERSONA**
| Columna | Tipo de Dato | Descripción |
|--------------|--------------|--------------|
| numPasaporte | VARCHAR(16) | Clave primaria. Indica el número de pasaporte de la persona |
| nombre | VARCHAR(32) | Nombre de la persona |
| primerApellido | VARCHAR (32) | Primer apellido de la persona |
| segundoApellido | VARCHAR (32) | Segundo apellido de la persona |
| fnac | DATE | Fecha de nacimiento de la persona |
| sexo | ENUM | Género biológico de la persona |
| paisNacimiento | INT | Clave foránea que apunta a PAIS.id e indica el país en el que nació la persona |


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
| idPais | INT | Clave foránea y única que apunta a PAIS.id e indica el país a que pertenece el código civil |


**LEY**
| Columna | Tipo de Dato | Descripción |
|--------------|--------------|--------------|
| id | INT | Clave primaria. Número que identifica una ley |
| descripcion | VARCHAR(2000) | Descripción de la ley |
| fechaAplicacion | DATE | Fecha en la que se aplican los efectos de la ley |
| fechaModificacion | DATE | Fecha en la que se modifica la ley |
| fechaImplementacion | DATE | Fecha de la vez en la que se creó la ley |
| idCodigoCivil | INT | Clave foránea que apunta a CODIGO_CIVIL.id e indica el código civil al que pertenece la ley |


**DESARROLLAR**
| Columna | Tipo de Dato | Descripción |
|--------------|--------------|--------------|
| idPropuesta | INT | Clave primaria y foránea que apunta a PROPUESTA.id e indica la propuesta que desarrolla a una ley |
| idLey | INT | Clave primaria y foránea que apunta a LEY.id e indica la ley que se está desarrollando |
