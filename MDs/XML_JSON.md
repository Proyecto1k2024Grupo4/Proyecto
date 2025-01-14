# XML & JSON

Para nuestro proyecto hemos definido los siguientes formatos XML y JSON para realizar informes de nuestra base de datos.

## XML

```
<?xml version="1.0" encoding="UTF-8"?>
<Entidades>
    <PAISES>
        <PAIS>
            <id></id>
            <nombre></nombre>
        </PAIS>
    </PAISES>
    <CONGRESOS>
        <CONGRESO>
            <id></id>
            <idPais></idPais>
        </CONGRESO>
    </CONGRESOS>
    <PERSONAS>
        <PERSONA>
            <numPasaporte></numPasaporte>
            <nombre></nombre>
            <primerApellido></primerApellido>
            <segundoApellido></segundoApellido>
            <fnac></fnac>
            <sexo></sexo>
            <paisNacimiento></paisNacimiento>
        </PERSONA>
    </PERSONAS>
    <POLITICOS>
        <POLITICO>
            <numPasaporte></numPasaporte>
            <fechaIniciacion></fechaIniciacion>
            <fechaRetirada></fechaRetirada>
            <idCongreso></idCongreso>
        </POLITICO>
    </POLITICOS>
    <CIUDADANOS>
        <CIUDADANO>
            <numPasaporte></numPasaporte>
        </CIUDADANO>
    </CIUDADANOS>
    <PROPUESTAS>
        <PROPUESTA>
            <id></id>
            <titulo></titulo>
            <descripcion></descripcion>
            <fechaExpiracion></fechaExpiracion>
            <estado></estado>
            <idCongreso></idCongreso>
            <numPasaportePolitico></numPasaportePolitico>
            <fechaProposicion></fechaProposicion>
            <fechaAceptacion></fechaAceptacion>
            <fechaPublicacion></fechaPublicacion>
        </PROPUESTA>
    </PROPUESTAS>
    <VOTOS>
        <VOTO>
            <numPasaporteCiudadano></numPasaporteCiudadano>
            <idPropuesta></idPropuesta>
            <decision></decision>
        </VOTO>
    </VOTOS>
    <CODIGOS_CIVILES>
        <CODIGO_CIVIL>
            <id></id>
            <idPais></idPais>
        </CODIGO_CIVIL>
    </CODIGOS_CIVILES>
    <LEYES>
        <LEY>
            <id></id>
            <descripcion></descripcion>
            <fechaAplicacion></fechaAplicacion>
            <fechaModificacion></fechaModificacion>
            <fechaImplementacion></fechaImplementacion>
            <idCodigoCivil></idCodigoCivil>
        </LEY>
    </LEYES>
    <DESARROLLOS>
        <DESARROLLO>
            <idPropuesta></idPropuesta>
            <idLey></idLey>
        </DESARROLLO>
    </DESARROLLOS>
</Entidades>
```

Se ha escogido este formato por que así podemos transmitir información de cualqueiera de nuestras entidades y además, al tener etiquetas de entidad en plural permitimos que se puedan añadir más de una en cada informe.

## JSON

```
{
  "Entidades": {
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
}
```

Se ha utilizado el siguiente formato JSON teniendo en cuenta el tipo de dato que se utiliza en los atributos de los diferentes objetos.