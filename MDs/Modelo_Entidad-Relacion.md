### Modelo Entidad-Relación

![image](https://github.com/user-attachments/assets/286a4e48-9f22-4737-ba12-0a234fe314d5)

En país hemos puesto como atributos derivados el número de ciudadanos y políticos ya que eso se conoce por la relación que existe entre ellos. Lo mismo pasa con los demás atributos derivados que aparecen, como por ejemplo: Codigo civil y número de leyes o Propuesta y votos.

Hemos creado una superclase PERSONA para almacenar los datos de POLITICO y CIUDADANO porque ambos comparten muchos atributos iguales. Es una relación total porque todas las personas que almacenamos en el sitema son obligatoriamente o un POLITICO o un CIUDADANO y además es una generalización disjunta porque un POLITICO no puede ser un CIUDADANO ni viceversa.

En el modelo entidad relación que hemos creado, las propuestas tienen un id único independientemente del páis que sea, es decir, si en Estados Unidos se crea una propuesta con el id 1, no puede haber una propuesta en el Reino Unido con el mismo id.

En político hay un atributo derivado "estado" que indica si está retirado o no y viene de las fechas de iniciación y retirada. La fecha de retirada debe ser posterior a la fecha de iniciación.

La fecha de proposición es anterior a la fecha de aceptación, la fecha de aceptación es anterior a la fecha de publicación y la fecha de publicación es anterior a la fecha de expiración. La fecha de expiración puede ser anterior o igual a la fecha de modificación o implementación. La fecha de aplicación debe ser posterior a la fecha de modificación o implementación.

El estado de una propuesta es dictaminado por las fechas entre las que se encuentre, es decir, si una propuesta ha sido presentada al congreso y todavía no se ha aceptado, se encuentra en estado de aceptación.

La entidad LEY representa una ley en concreto. Cuando una propuesta desarrolla una ley, si la crea, su fecha de implementación y modificación serán la misma, ya que la fecha de implementación indica cuando se creó dicha ley.
