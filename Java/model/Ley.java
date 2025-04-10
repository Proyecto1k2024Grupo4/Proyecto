package model;


import java.util.Date;

public class Ley {

    // Propiedades
    private int id;
    private String descripcion;
    private java.sql.Date fechaAplicacion;
    private java.sql.Date fechaModificacion;
    private java.sql.Date fechaImplementacion;
    private int idCodigoCivil;


    /**
     * Default constructor
     */
    public Ley() {
    }

    /**
     * Constructor sin ID
     * @param descripcion
     * @param fechaAplicacion
     * @param fechaModificacion
     * @param fechaImplementacion
     * @param idCodigoCivil
     */
    public Ley(String descripcion, java.sql.Date fechaAplicacion, java.sql.Date fechaModificacion, java.sql.Date fechaImplementacion, int idCodigoCivil) {
        setDescripcion(descripcion);
        setFechaAplicacion(fechaAplicacion);
        setFechaModificacion(fechaModificacion);
        setFechaImplementacion(fechaImplementacion);
        setIdCodigoCivil(idCodigoCivil);
    }

    /**
     * Constructor con todos los parametros
     * @param id
     * @param descripcion
     * @param fechaAplicacion
     * @param fechaModificacion
     * @param fechaImplementacion
     * @param idCodigoCivil
     */
    public Ley(int id, String descripcion, java.sql.Date fechaAplicacion, java.sql.Date fechaModificacion, java.sql.Date fechaImplementacion, int idCodigoCivil) {
        this.id = id;
        setDescripcion(descripcion);
        setFechaAplicacion(fechaAplicacion);
        setFechaModificacion(fechaModificacion);
        setFechaImplementacion(fechaImplementacion);
        setIdCodigoCivil(idCodigoCivil);
    }

    public Ley(int id, String descripcion, String fImpl, String fAplica, String fMod) {
    }

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

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public java.sql.Date getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(java.sql.Date fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public java.sql.Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(java.sql.Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public java.sql.Date getFechaImplementacion() {
        return fechaImplementacion;
    }

    public void setFechaImplementacion(java.sql.Date fechaImplementacion) {
        this.fechaImplementacion = fechaImplementacion;
    }

    public int getIdCodigoCivil() {
        return idCodigoCivil;
    }

    public void setIdCodigoCivil(int idCodigoCivil) {
        this.idCodigoCivil = idCodigoCivil;
    }
}