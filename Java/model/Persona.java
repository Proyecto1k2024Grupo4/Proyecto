package model;

import java.sql.Date;

/**
 * Clase de Persona con información de la persona
 * @author Jonathan Villalba Morán
 * @version 10/04/2025
 */
public class Persona {

    protected String numPasaporte;
    protected String nombre;
    protected String primerApellido;
    protected String segundoApellido;
    protected Date fnac;
    protected Sexo sexo;
    protected int paisNacimiento;

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
    public Persona(String numPasaporte, String nombre, String primerApellido, String segundoApellido, Date fnac, Sexo sexo, int paisNacimiento) {
        this.numPasaporte = numPasaporte;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fnac = fnac;
        this.sexo = sexo;
        this.paisNacimiento = paisNacimiento;
    }

    /**
     * Convierte los datos a XML
     * @return el objeto actual en formato XML
     */
    public String toXml(){
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<model.Persona>\n")
                .append("\t<model.Persona:numPasaporte>").append(this.numPasaporte).append("</model.Persona:numPasaporte>\n")
                .append("\t<model.Persona:nombre>").append(this.nombre).append("</model.Persona:nombre>\n")
                .append("\t<model.Persona:primerApellido>").append(this.primerApellido).append("</model.Persona:primerApellido>\n")
                .append("\t<model.Persona:segundoApellido>").append(this.segundoApellido).append("</model.Persona:segundoApellido>\n")
                .append("\t<model.Persona:fnac>").append(this.fnac).append("</model.Persona:fnac>\n")
                .append("\t<model.Persona:sexo>").append(this.sexo).append("</model.Persona:sexo>\n")
                .append("\t<model.Persona:paisNacimiento>").append(this.paisNacimiento).append("</model.Persona:paisNacimiento>\n")
                .append("</model.Persona>");

            return String.valueOf(xmlBuilder);
    }

    /**
     * Convierte los datos a Json
     * @return el objeto actual en formato Json
     */
    public String toJson(){
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("\"PERSONA\": {\n")
                .append("\t\"numPasaporte\": \"").append(this.numPasaporte).append("\",\n")
                .append("\t\"nombre\": \"").append(this.nombre).append("\",\n")
                .append("\t\"primerApellido\": \"").append(this.primerApellido).append("\",\n")
                .append("\t\"segundoApellido\": \"").append(this.segundoApellido).append("\",\n")
                .append("\t\"fnac\": \"").append(this.fnac).append("\",\n")
                .append("\t\"sexo\": \"").append(this.sexo).append("\",\n")
                .append("\t\"paisNacimiento\": ").append(this.paisNacimiento).append("\n")
                .append("}");

        return String.valueOf(jsonBuilder);
    }

    /**
     * Metodo que devuelve el número del pasaporte del ciudadano.
     * @return número de pasaporte del ciudadano
     */
    public String getNumPasaporte() {
        return numPasaporte;
    }

    /**
     * Metodo que establece el número de pasaporte del ciudadano.
     * @param numPasaporte número de pasaporte a asignar
     */
    public void setNumPasaporte(String numPasaporte) throws IllegalArgumentException{
        if (!(numPasaporte.length() > 16))
            this.numPasaporte = numPasaporte;
        else
            throw new IllegalArgumentException("Error: el formato del pasaporte es incorrecto");
    }

    /**
     * Metodo que devuelve el nombre del ciudadano.
     * @return nombre del ciudadano
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que establece el nombre del ciudadano.
     * @param nombre nombre a asignar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que devuelve el primer apellido del ciudadano.
     * @return primer apellido del ciudadano
     */
    public String getPrimerApellido() {
        return primerApellido;
    }

    /**
     * Metodo que establece el primer apellido del ciudadano.
     * @param primerApellido primer apellido a asignar
     */
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    /**
     * Metodo que devuelve el segundo apellido del ciudadano.
     * @return segundo apellido del ciudadano
     */
    public String getSegundoApellido() {
        return segundoApellido;
    }

    /**
     * Metodo que establece el segundo apellido del ciudadano.
     * @param segundoApellido segundo apellido a asignar
     */
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    /**
     * Metodo que devuelve la fecha de nacimiento del ciudadano.
     * @return fecha de nacimiento del ciudadano
     */
    public Date getFnac() {
        return fnac;
    }

    /**
     * Metodo que establece la fecha de nacimiento del ciudadano.
     * @param fnac fecha de nacimiento a asignar
     */
    public void setFnac(Date fnac) {
        this.fnac = fnac;
    }

    /**
     * Metodo que devuelve el sexo del ciudadano.
     * @return sexo del ciudadano
     */
    public Sexo getSexo() {
        return sexo;
    }

    /**
     * Metodo que establece el sexo del ciudadano.
     * @param sexo sexo a asignar
     */
    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    /**
     * Metodo que devuelve el código del país de nacimiento del ciudadano.
     * @return código del país de nacimiento
     */
    public int getPaisNacimiento() {
        return paisNacimiento;
    }

    /**
     * Metodo que establece el código del país de nacimiento del ciudadano.
     * @param paisNacimiento código del país a asignar
     */
    public void setPaisNacimiento(int paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "numPasaporte='" + numPasaporte + '\'' +
                ", nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", fnac=" + fnac +
                ", sexo=" + sexo +
                ", paisNacimiento=" + paisNacimiento +
                '}';
    }
}