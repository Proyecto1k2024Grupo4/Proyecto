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

![image](https://github.com/user-attachments/assets/ec7b4b3c-fce2-4ac1-8120-ad3f614f0db0)

Hemos creado una superclase PERSONA para almacenar los datos de POLITICO y CIUDADANO porque ambos comparten muchos atributos iguales.

La entidad LEY representa una ley en concreto

La fecha de expiración de una propuesta tiene que ser anterior a la fecha de aplicación de esta misma.


### Modelo Relacional

``` 
PAIS (_nombre_)  
  PK (nombre)

PERSONA (numPasaporte, nombre, primerApellido, segundoApellido, fnac, sexo, paisNacimiento*)
  PK (numPasaporte)
  FK (paisNacimiento) -> PAIS
```

**POLITICO** (numPasaporte, fechaIniciacion)
PK (numPasaporte)
FK (numPasaporte) -> PERSONA

**CIUDADANO** (numPasaporte)
PK (numPasaporte)
FK (numPasaporte) -> PERSONA
