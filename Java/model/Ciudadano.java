package model;

import java.sql.Date;

/**
 * Clase Ciudadano que extiende de Persona, gurda la misma información que Persona
 * @author Jonathan Villalba Morán
 * @version 7/4/25
 */
public class Ciudadano extends Persona {

    /**
     *
     * @param persona con la que construiremos al ciudadano
     */
    public Ciudadano(Persona persona) {
       super(persona.getNumPasaporte(), persona.getNombre(), persona.getPrimerApellido(), persona.getSegundoApellido(), persona.getFnac(), persona.getSexo(), persona.getPaisNacimiento());
    }


}