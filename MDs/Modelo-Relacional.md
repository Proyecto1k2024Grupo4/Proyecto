### Modelo Relacional

``` 
PAIS (_id_, nombre)  
    PK (id)

CONGRESO (_id_, idPais*)
    PK (id)
    FK (idPais) -> PAIS
    VNN (idPais)
    UK (idPais)

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

CODIGO_CIVIL (_id_, idPais*)
    PK (id)
    FK (idPais) -> PAIS
    VNN (idPais)
    UK (idPais)

LEY (_id_, descripcion, fechaAplicacion, fechaModificacion, fechaImplementacion, idCodigoCivil*)
    PK (id)
    FK (idCodigoCivil) -> CODIGO_CIVIL
    VNN (idCodigoCivil, descripcion, fechaImplementacion)
  
DESARROLLAR (_idPropuesta_*, _idLey_*)
    PK (idPropuesta, idLey)
    FK (idPropuesta) -> PROPUESTA
       (idLey) -> LEY
``` 

**Perdida expresiva**

En el modelo relacional no se ha incluido la relación entre ciudadano y político debido a que cuando un ciudadano capacitado oposita para político y accede al cargo se eliminan sus datos del registro de ciudadanos capacitados, ya que un político no puede votar.
