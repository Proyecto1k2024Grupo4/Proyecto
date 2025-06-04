package model;


import java.sql.Date;

/**
 * Clase Ley que sirve para almacenar la información de las leyes
 * @author Diego Fernando Valencia Correa 1ºK
 * @version 7-4-2025
 */
public class Ley {

    // Propiedades
    private int id;
    private String descripcion;
    private Date fechaAplicacion;
    private Date fechaModificacion;
    private Date fechaImplementacion;
    private int idCodigoCivil;
    //private int idPais;
    //private String nombrePais;
    Pais pais;

    /**
     * Constructor sin ID
     * @param descripcion
     * @param fechaAplicacion
     * @param fechaModificacion
     * @param fechaImplementacion
     * @param idCodigoCivil
     */
    public Ley(String descripcion, Date fechaAplicacion, Date fechaModificacion, Date fechaImplementacion, int idCodigoCivil) {
        setDescripcion(descripcion);
        setFechaAplicacion(fechaAplicacion);
        setFechaModificacion(fechaModificacion);
        setFechaImplementacion(fechaImplementacion);
        setIdCodigoCivil(idCodigoCivil);
    }

    /**
     * Constructor de Ley con todos los parámetros
     * @param id Id de la ley
     * @param descripcion Descripción de la ley
     * @param fechaAplicacion Fecha de apliación de la ley
     * @param fechaModificacion Fecha de modificación de la ley
     * @param fechaImplementacion Fecha de implementación de la ley
     * @param idCodigoCivil Id del código civil de la ley
     */
    public Ley(int id, String descripcion, Date fechaAplicacion, Date fechaModificacion, Date fechaImplementacion, int idCodigoCivil) {
        this.id = id;
        setDescripcion(descripcion);
        setFechaAplicacion(fechaAplicacion);
        setFechaModificacion(fechaModificacion);
        setFechaImplementacion(fechaImplementacion);
        setIdCodigoCivil(idCodigoCivil);
    }
    /**
     * Constructor completo de Ley, incluyendo país.
     * @param id                  Identificador de la ley
     * @param descripcion         Descripción de la ley
     * @param fechaAplicacion     Fecha de aplicación
     * @param fechaModificacion   Fecha de modificación
     * @param fechaImplementacion Fecha de implementación
     * @param idCodigoCivil       Id del código civil
     * @param idPais              Id del país asociado
     * @param nombrePais          Nombre del país asociado
     */
    public Ley(int id,
               String descripcion,
               Date fechaAplicacion,
               Date fechaModificacion,
               Date fechaImplementacion,
               int idCodigoCivil,
               int idPais,
               String nombrePais) {
        this.id = id;
        setDescripcion(descripcion);
        setFechaAplicacion(fechaAplicacion);
        setFechaModificacion(fechaModificacion);
        setFechaImplementacion(fechaImplementacion);
        setIdCodigoCivil(idCodigoCivil);
        this.pais = new Pais(idPais,nombrePais);
    }


    /**
     * Metodo que tranforma la información de una ley en formato JSON
     * @return JSON con la información
     */
    public String toJson(){
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("\"LEY\": {\n")
                .append("\t")
                .append("\"id\": ").append(this.id)
                .append("\n")
                .append("\t")
                .append("\"descripcion\": \"").append(this.descripcion).append("\"")
                .append("\n")
                .append("\t")
                .append("\"fechaAplicacion\": \"").append(this.fechaAplicacion).append("\"")
                .append("\n")
                .append("\t")
                .append("\"fechaModificacion\": \"").append(this.fechaModificacion).append("\"")
                .append("\n")
                .append("\t")
                .append("\"fechaImplementacion\": \"").append(this.fechaImplementacion).append("\"")
                .append("\n")
                .append("\t")
                .append("\"idCodigoCivil: ").append(this.idCodigoCivil)
                .append("\n")
                .append("}");
        return String.valueOf(jsonBuilder);
    }

    /**
     * Metodo que transorma la información de una ley en formato XML
     * @return XML con la información de la ley
     */
    public String toXml(){
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<model.Ley>\n")
                .append("\t")
                .append("<model.Ley:id>").append(this.id).append("</model.Ley:id>\n")
                .append("\t")
                .append("<model.Ley:descripcion>").append(this.descripcion).append("</model.Ley:descripcion>\n")
                .append("\t")
                .append("<model.Ley:fechaAplicacion>").append(this.fechaAplicacion).append("<model.Ley:fechaAplicacion\n")
                .append("\t")
                .append("<model.Ley:fechaModificacion").append(this.fechaModificacion).append("</model.Ley:fechaModificacion>\n")
                .append("\t")
                .append("<model.Ley:fechaImplementacion").append(this.fechaImplementacion).append("</model.Ley:fechaImplementacion\n")
                .append("\t")
                .append("model.Ley:idCodigoCivil").append(this.idCodigoCivil).append("</model.Ley:idCodigoCivil")
                .append("</model.Ley");

        return String.valueOf(xmlBuilder);
    }

    /**
     * Establece el identificador único de la ley.
     * @param id identificador generado por la base de datos
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el identificador del país asociado a esta ley.
     * @return identificador del país (proviene del código civil)
     */
    public Pais getPais() {
        return pais ;
    }

    /**
     * Establece el identificador del país asociado a esta ley.
     * @param pais identificador del país (proviene del código civil)
     */
    public void setPais(Pais pais) {
        this.pais = pais;
    }
    /**
     * Metodo que devuelve el id de la ley
     * @return Id de la ley
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo que devuelve la descripción de la ley
     * @return String con la descripción
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Metodo que establece la descripción de la ley
     * @param descripcion Descripción de la ley
     */
    public void setDescripcion(String descripcion) throws IllegalArgumentException{
        if (!(descripcion.length() > 2000)){
            this.descripcion = descripcion;
        } else {
            throw new IllegalArgumentException("Error, la descripción de la ley no puede tener más de 2000 caracteres");
        }
    }

    /**
     * Metodo que devuelve la fecha de aplicación de la ley
     * @return Fecha de aplicación
     */
    public Date getFechaAplicacion() {
        return fechaAplicacion;
    }

    /**
     * Metodo que establece la fecha de aplicación de la ley
     * @param fechaAplicacion Fecha de aplicación
     */
    public void setFechaAplicacion(Date fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    /**
     * Metodo que devuelve la fecha de modificación de la ley
     * @return Fecha de modificación
     */
    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    /**
     * Metodo que establece la fecha de modificación de la ley
     * @param fechaModificacion Fecha de modificación
     */
    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    /**
     * Metodo que devuelve la fecha de implementación de la ley
     * @return Fecha de implementación de la ley
     */
    public Date getFechaImplementacion() {
        return fechaImplementacion;
    }

    /**
     * Metodo que establece la fecha de implementación de la ley
     * @param fechaImplementacion Fecha de implementación de la ley
     */
    public void setFechaImplementacion(Date fechaImplementacion) {
        this.fechaImplementacion = fechaImplementacion;
    }

    /**
     * Metodo que devuelve el id del código civil relacionado con la ley
     * @return int Id del código civil
     */
    public int getIdCodigoCivil() {
        return idCodigoCivil;
    }

    /**
     * Metodo que establece el id del código civil relacionado con la ley
     * @param idCodigoCivil Id del código civil
     */
    public void setIdCodigoCivil(int idCodigoCivil) {
        this.idCodigoCivil = idCodigoCivil;
    }

    @Override
    public String toString() {
        return "Ley{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", fechaAplicacion=" + fechaAplicacion +
                ", fechaModificacion=" + fechaModificacion +
                ", fechaImplementacion=" + fechaImplementacion +
                ", idCodigoCivil=" + idCodigoCivil +
                ", pais=" + pais +
                '}';
    }
}
