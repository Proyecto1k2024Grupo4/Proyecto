# XML & JSON

Para nuestro proyecto hemos definido los siguientes formatos XML y JSON para realizar informes de nuestra base de datos.

## XML

```
<?xml version="1.0" encoding="UTF-8"?>
<Entidades>
    <Paises>
        <model.Pais>
            <model.Pais:id></model.Pais:id>
            <model.Pais:nombre></model.Pais:nombre>
        </model.Pais>
    </Paises>
    <Congresos>
        <model.Congreso>
            <model.Congreso:id></model.Congreso:id>
            <model.Congreso:idPais></model.Congreso:idPais>
        </model.Congreso>
    </Congresos>
    <Personas>
        <model.Persona>
            <model.Persona:numPasaporte></model.Persona:numPasaporte>
            <model.Persona:nombre></model.Persona:nombre>
            <model.Persona:primerApellido></model.Persona:primerApellido>
            <model.Persona:segundoApellido></model.Persona:segundoApellido>
            <model.Persona:fnac></model.Persona:fnac>
            <model.Persona:sexo></model.Persona:sexo>
            <model.Persona:paisNacimiento></model.Persona:paisNacimiento>
        </model.Persona>
    </Personas>
    <Politicos>
        <model.Politico>
            <model.Politico:numPasaporte></model.Politico:numPasaporte>
            <model.Politico:fechaIniciacion></model.Politico:fechaIniciacion>
            <model.Politico:fechaRetirada></model.Politico:fechaRetirada>
            <model.Politico:idCongreso></model.Politico:idCongreso>
        </model.Politico>
    </Politicos>
    <Ciudadanos>
        <model.Ciudadano>
            <model.Ciudadano:numPasaporte></model.Ciudadano:numPasaporte>
        </model.Ciudadano>
    </Ciudadanos>
    <Propuestas>
        <model.Propuesta>
            <model.Propuesta:id></model.Propuesta:id>
            <model.Propuesta:titulo></model.Propuesta:titulo>
            <model.Propuesta:descripcion></model.Propuesta:descripcion>
            <model.Propuesta:fechaExpiracion></model.Propuesta:fechaExpiracion>
            <model.Propuesta:estado></model.Propuesta:estado>
            <model.Propuesta:idCongreso></model.Propuesta:idCongreso>
            <model.Propuesta:numPasaportePolitico></model.Propuesta:numPasaportePolitico>
            <model.Propuesta:fechaProposicion></model.Propuesta:fechaProposicion>
            <model.Propuesta:fechaAceptacion></model.Propuesta:fechaAceptacion>
            <model.Propuesta:fechaPublicacion></model.Propuesta:fechaPublicacion>
        </model.Propuesta>
    </Propuestas>
    <Votos>
        <Voto>
            <Voto:numPasaporteCiudadano></Voto:numPasaporteCiudadano>
            <Voto:idPropuesta></Voto:idPropuesta>
            <Voto:decision></Voto:decision>
        </Voto>
    </Votos>
    <CodigosCiviles>
        <model.CodigoCivil>
            <model.CodigoCivil:id></model.CodigoCivil:id>
            <model.CodigoCivil:idPais></model.CodigoCivil:idPais>
        </model.CodigoCivil>
    </CodigosCiviles>
    <Leyes>
        <model.Ley>
            <model.Ley:id></model.Ley:id>
            <model.Ley:descripcion></model.Ley:descripcion>
            <model.Ley:fechaAplicacion></model.Ley:fechaAplicacion>
            <model.Ley:fechaModificacion></model.Ley:fechaModificacion>
            <model.Ley:fechaImplementacion></model.Ley:fechaImplementacion>
            <model.Ley:idCodigoCivil></model.Ley:idCodigoCivil>
        </model.Ley>
    </Leyes>
    <Desarrollos>
        <Desarrollo>
            <Desarrollo:idPropuesta></Desarrollo:idPropuesta>
            <Desarrollo:idLey></Desarrollo:idLey>
        </Desarrollo>
    </Desarrollos>
</Entidades>
```

Se ha escogido este formato por que así podemos transmitir información de cualqueiera de nuestras entidades y además, al tener etiquetas de entidad en plural permitimos que se puedan añadir más de una en cada informe.

## JSON

```
{
  "PAIS": {
    "id": 0,
    "nombre": ""
  },
  "CONGRESO": {
    "id": 0,
    "idPais": 0
  },
  "PERSONA": {
    "numPasaporte": "",
    "nombre": "",
    "primerApellido": "",
    "segundoApellido": "",
    "fnac": "",
    "sexo": "",
    "paisNacimiento": 0
  },
  "POLITICO": {
    "numPasaporte": "",
    "fechaIniciacion": "",
    "fechaRetirada": "",
    "idCongreso": 0
  },
  "CIUDADANO": {
    "numPasaporte": ""
  },
  "PROPUESTA": {
    "id": 0,
    "titulo": "",
    "descripcion": "",
    "fechaExpiracion": "",
    "estado": "",
    "idCongreso": 0,
    "numPasaportePolitico": "",
    "fechaProposicion": "",
    "fechaAceptacion": "",
    "fechaPublicacion": ""
  },
  "VOTAR": {
    "numPasaporteCiudadano": "",
    "idPropuesta": 0,
    "decision": false
  },
  "CODIGO_CIVIL": {
    "id": 0,
    "idPais": 0
  },
  "LEY": {
    "id": 0,
    "descripcion": "",
    "fechaAplicacion": "",
    "fechaModificacion": "",
    "fechaImplementacion": "",
    "idCodigoCivil": 0
  },
  "DESARROLLAR": {
    "idPropuesta": 0,
    "idLey": 0
  }
}
```

Se ha utilizado el siguiente formato JSON teniendo en cuenta el tipo de dato que se utiliza en los atributos de los diferentes objetos.
