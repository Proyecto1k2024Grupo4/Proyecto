# XML & JSON

Para nuestro proyecto hemos definido los siguientes formatos XML y JSON para realizar informes de nuestra base de datos.

## XML

```
<?xml version="1.0" encoding="UTF-8"?>
<Entidades>
    <Paises>
        <Pais>
            <Pais:id></Pais:id>
            <Pais:nombre></Pais:nombre>
        </Pais>
    </Paises>
    <Congresos>
        <Congreso>
            <Congreso:id></Congreso:id>
            <Congreso:idPais></Congreso:idPais>
        </Congreso>
    </Congresos>
    <Personas>
        <Persona>
            <Persona:numPasaporte></Persona:numPasaporte>
            <Persona:nombre></Persona:nombre>
            <Persona:primerApellido></Persona:primerApellido>
            <Persona:segundoApellido></Persona:segundoApellido>
            <Persona:fnac></Persona:fnac>
            <Persona:sexo></Persona:sexo>
            <Persona:paisNacimiento></Persona:paisNacimiento>
        </Persona>
    </Personas>
    <Politicos>
        <Politico>
            <Politico:numPasaporte></Politico:numPasaporte>
            <Politico:fechaIniciacion></Politico:fechaIniciacion>
            <Politico:fechaRetirada></Politico:fechaRetirada>
            <Politico:idCongreso></Politico:idCongreso>
        </Politico>
    </Politicos>
    <Ciudadanos>
        <Ciudadano>
            <Ciudadano:numPasaporte></Ciudadano:numPasaporte>
        </Ciudadano>
    </Ciudadanos>
    <Propuestas>
        <Propuesta>
            <Propuesta:id></Propuesta:id>
            <Propuesta:titulo></Propuesta:titulo>
            <Propuesta:descripcion></Propuesta:descripcion>
            <Propuesta:fechaExpiracion></Propuesta:fechaExpiracion>
            <Propuesta:estado></Propuesta:estado>
            <Propuesta:idCongreso></Propuesta:idCongreso>
            <Propuesta:numPasaportePolitico></Propuesta:numPasaportePolitico>
            <Propuesta:fechaProposicion></Propuesta:fechaProposicion>
            <Propuesta:fechaAceptacion></Propuesta:fechaAceptacion>
            <Propuesta:fechaPublicacion></Propuesta:fechaPublicacion>
        </Propuesta>
    </Propuestas>
    <Votos>
        <Voto>
            <Voto:numPasaporteCiudadano></Voto:numPasaporteCiudadano>
            <Voto:idPropuesta></Voto:idPropuesta>
            <Voto:decision></Voto:decision>
        </Voto>
    </Votos>
    <CodigosCiviles>
        <CodigoCivil>
            <CodigoCivil:id></CodigoCivil:id>
            <CodigoCivil:idPais></CodigoCivil:idPais>
        </CodigoCivil>
    </CodigosCiviles>
    <Leyes>
        <Ley>
            <Ley:id></Ley:id>
            <Ley:descripcion></Ley:descripcion>
            <Ley:fechaAplicacion></Ley:fechaAplicacion>
            <Ley:fechaModificacion></Ley:fechaModificacion>
            <Ley:fechaImplementacion></Ley:fechaImplementacion>
            <Ley:idCodigoCivil></Ley:idCodigoCivil>
        </Ley>
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
