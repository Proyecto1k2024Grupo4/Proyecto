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
     * @param numPasaporte El número del pasaporte del ciudadano el cual es su clave primaria
     * @param nombre El nombre del ciudadano
     * @param primerApellido El primer apellido del ciudadano
     * @param segundoApellido El segundo apellido del ciudadano
     * @param fnac La fecha de nacimiento del ciudadano
     * @param sexo El sexo del ciudadano
     * @param paisNacimiento El pais de nacimiento del ciudadano
     */
    public Ciudadano(String numPasaporte, String nombre, String primerApellido, String segundoApellido, Date fnac,
                     Sexo sexo, int paisNacimiento) {
        super(numPasaporte, nombre, primerApellido, segundoApellido, fnac, sexo, paisNacimiento);
    }


}