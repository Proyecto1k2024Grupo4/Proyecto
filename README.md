# Proyecto: 
Sistema de Gestión de Votaciones y Propuestas de Reforma Legal a Nivel Internacional

### Participantes:
- [Diego Fernando Valencia Correa](https://github.com/DocD1306)
- [Pablo Bernabeu Robles](https://github.com/bernabeu17)
- [Jonathan Villalba Moran](https://github.com/JonathanWick21)
- [Abdel Moghit Samini](https://github.com/Samini04)

### Descripción del proyecto:
Somos una organización mundial conformada por varios países y queremos almacenar las votaciones de propuestas de reforma de ley de cada país.

De cada ciudadano que esté capacitado (ha pasado por una prueba de conocimentos mínimos) para votar se desea conocer su nombre, apellidos, sexo, fecha de nacimiento, pasaporte.

De los políticos también queremos saber su nombre, apellidos, sexo, fecha de nacimiento, pasaporte y además la fecha en la que tomaron el cargo. Estos proponen propuestas y queremos almacenar el número de propuestas públicas que han aportado y de esas propuestas, las que han sido aceptadas y las que han sido rechazadas por la población.

Un ciudadano capacitado puede opositar para convertirse en político, aunque también pueden haber ciudadanos no capacitados (de los cuales no guardamos información) que opositen y se conviertan en políticos directamente.

Los políticos forman un congreso, el cual hace una votación para decidir si hacer públicas las propuestas y del cual queremos saber el número de propuestas que han aceptado para ser públicas y de estas mismas las que han sido aceptadas o rechazadas por la población, además queremos saber el número de políticos que lo conforma.

De las propuestas necesitamos saber su código, la fecha de presentación al congreso, la fecha de publicación, la fecha en la que acaba el plazo de su votación, la fecha en la que se aplican sus efectos en caso de ser aceptada por los ciudadanos, la descripción de la propuesta y el título.

Las propuestas pueden ser votadas por los ciudadanos capacitados pero no por los políticos.

Las propuestas desarrollan leyes, de las que deseamos conocer su código identificativo, su descripción, fecha de última modificación y fecha de primera implementación.

Las leyes forman un código civil, del que necesitamos conocer, su código identificadivo, la cantidad de leyes que lo conforman y fecha de última modificación.

El código civil rige a un país (del que se quiere conocer su nombre, cantidad de políticos y ciudadanos capacitados que tiene) y un país solo puede ser regido por un único código civil. 

### Modelo Entidad-Relación

![ModeloER](https://github.com/user-attachments/assets/6cc000e3-1a23-4c12-b1f2-129a3832ae3c)

![image](https://github.com/user-attachments/assets/420e302a-43a3-423e-ae1e-bd084eaf2799)

Hemos creado una superclase PERSONA para almacenar los datos de POLITICO y CIUDADANO porque ambos comparten muchos atributos iguales.






