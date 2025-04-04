package model;

public class Ciudadano extends Persona {


    public String numPasaporte;


    public Ciudadano(String numPasaporte, String nombre, String primerApellido, String segundoApellido, String fnac,
                     Sexo sexo, int paisNacimiento) {
        super(numPasaporte, nombre, primerApellido, segundoApellido, fnac, sexo, paisNacimiento);
        this.numPasaporte = numPasaporte;
    }
}