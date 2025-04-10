package model;

/**
 * Clase Politico que extiende de persona y guarda información de los politicos
 *
 * @author Jonathan Villalba Moran
 * @version 7-4-2025
 */
public class Politico extends Persona{

    // Propiedades
    public String numPasaporte;
    public String fechaIniciacion;
    public String fechaRetirada;
    public int idCongreso;

    /**
     * Constructor de Politico
     * @param numPasaporte El numero de pasaporte del ciudadano que se usa como clave primaria
     * @param nombre Nombre de la persona
     * @param primerApellido Primer apellido de la persona
     * @param segundoApellido Segundo apellido de la persona
     * @param fnac La fecha de nacimiento de la persona
     * @param sexo El sexo de la persona
     * @param paisNacimiento El pais de nacimiento de la persona
     * @param fechaIniciacion La fecha en la que se convirtió en politico
     * @param fechaRetirada La fecha en la que se retiro de su puesto
     * @param idCongreso El id del congreso al que pertenece
     */
    public Politico(String numPasaporte, String nombre, String primerApellido, String segundoApellido, String fnac, Sexo sexo, int paisNacimiento, String fechaIniciacion, String fechaRetirada, int idCongreso) {
        super(numPasaporte, nombre, primerApellido, segundoApellido, fnac, sexo, paisNacimiento);
        this.numPasaporte = numPasaporte;
        this.fechaIniciacion = fechaIniciacion;
        this.fechaRetirada = fechaRetirada;
        this.idCongreso = idCongreso;
    }

    /**
     * Metodo para crear una nueva propuesta
     * @param titulo
     * @param descripcion
     */
    public void proponer(String titulo, String descripcion) {

    }

    /**
     * Metodo para transformar a XML
     * @return XML del objeto actual
     */
    @Override
    public String toXml(){
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<model.Persona>\n")
                .append("\t<model.Persona:numPasaporte>").append(this.numPasaporte).append("</model.Persona:numPasaporte>\n")
                .append("\t<model.Persona:fechaIniciacion>").append(this.fechaIniciacion).append("</model.Persona:fechaIniciacion>\n")
                .append("\t<model.Persona:fechaRetirada>").append(this.fechaRetirada).append("</model.Persona:fechaRetirada>\n")
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
     * Metodo para transformar a Json
     * @return el objeto actual en formato Json
     */
    @Override
    public String toJson(){
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("\"PERSONA\": {\n")
                .append("\t\"numPasaporte\": \"").append(this.numPasaporte).append("\",\n")
                .append("\t\"fechaIniciacion\": \"").append(this.fechaIniciacion).append("\",\n")
                .append("\t\"fechaRetirada\": \"").append(this.fechaRetirada).append("\",\n")
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
     * Metodo que devuelve la fecha de iniciación
     * @return la fecha de iniciación
     */
    public String getFechaIniciacion() {
        return fechaIniciacion;
    }

    /**
     * Metodo que establece la fecha de iniciación
     * @param fechaIniciacion
     */
    public void setFechaIniciacion(String fechaIniciacion) {
        this.fechaIniciacion = fechaIniciacion;
    }

    /**
     * Metodo que devuelve la fecha de retirada
     * @return la fecha de iniciación
     */
    public String getFechaRetirada() {
        return fechaRetirada;
    }

    /**
     * Metodo que establece la fecha de retirada
     * @param fechaRetirada
     */
    public void setFechaRetirada(String fechaRetirada) {
        this.fechaRetirada = fechaRetirada;
    }

    /**
     * Metodo que devuelve el id del congreso al que pertenece
     * @return el id del congreso
     */
    public int getIdCongreso() {
        return idCongreso;
    }

    /**
     * Establece el id del congreso al que pertenece
     * @param idCongreso
     */
    public void setIdCongreso(int idCongreso) {
        this.idCongreso = idCongreso;
    }
}