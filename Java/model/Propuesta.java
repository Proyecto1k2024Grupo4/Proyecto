package model;

import java.sql.Date;

/**
 * Clase Propuesta que almacena la información de las propuestas
 * @author Diego Fernando Valencia Correa 1ºK
 * @version
 */
public class Propuesta {

    private int id;
    private String titulo;
    private String descripcion;
    private Date fechaExpiracion;
    private EstadoPropuesta estado;
    private int idCongreso;
    private String numPasaportePolitico;
    private Date fechaProposicion;
    private Date fechaAceptacion;
    private Date fechaPublicacion;

    /**
     * Constructor de la clase Propuesta con todos los parámeteros menos el id
     * @param titulo Título de la propuesta
     * @param descripcion Descripción de la propuesta
     * @param fechaExpiracion Fecha de expiración de la propuesta
     * @param estado Estado actual de la propuesta
     * @param idCongreso Id del congreso al que pertenece la propuesta
     * @param numPasaportePolitico Número de pasaporte del político que creó la propuesta
     * @param fechaProposicion Fecha de la proposición de la propuesta
     * @param fechaAceptacion Fecha de la aceptación de la propuesta
     * @param fechaPublicacion Fecha de publicación de la propuesta
     */
    public Propuesta(String titulo, String descripcion, Date fechaExpiracion, EstadoPropuesta estado, int idCongreso,
                     String numPasaportePolitico, Date fechaProposicion, Date fechaAceptacion, Date fechaPublicacion) {
        setTitulo(titulo);
        setDescripcion(descripcion);
        setFechaExpiracion(fechaExpiracion);
        setEstado(estado);
        setIdCongreso(idCongreso);
        setNumPasaportePolitico(numPasaportePolitico);
        setFechaProposicion(fechaProposicion);
        setFechaAceptacion(fechaAceptacion);
        setFechaPublicacion(fechaPublicacion);
    }

    /**
     * Constructor de la clase Propuesta con todos los parámeteros menos el id
     * @param id Id de la propuesta
     * @param titulo Título de la propuesta
     * @param descripcion Descripción de la propuesta
     * @param fechaExpiracion Fecha de expiración de la propuesta
     * @param estado Estado actual de la propuesta
     * @param idCongreso Id del congreso al que pertenece la propuesta
     * @param numPasaportePolitico Número de pasaporte del político que creó la propuesta
     * @param fechaProposicion Fecha de la proposición de la propuesta
     * @param fechaAceptacion Fecha de la aceptación de la propuesta
     * @param fechaPublicacion Fecha de publicación de la propuesta
     */
    public Propuesta(int id, String titulo, String descripcion, Date fechaExpiracion, EstadoPropuesta estado, int idCongreso,
                     String numPasaportePolitico, Date fechaProposicion, Date fechaAceptacion, Date fechaPublicacion) {
        this.id = id;
        setTitulo(titulo);
        setDescripcion(descripcion);
        setFechaExpiracion(fechaExpiracion);
        setEstado(estado);
        setIdCongreso(idCongreso);
        setNumPasaportePolitico(numPasaportePolitico);
        setFechaProposicion(fechaProposicion);
        setFechaAceptacion(fechaAceptacion);
        setFechaPublicacion(fechaPublicacion);
    }

    /**
     * Metodo que tranforma la información de la propuesta a formato XML
     * @return XML con la información de la propuesta
     */
    public String toXML(){

        StringBuilder xmlBuilder = new StringBuilder();

        xmlBuilder.append("<model.Propuesta>\n")
                .append("\t<model.Propuesta:id>").append(this.id).append("</model.Propuesta:id>\n")
                .append("\t<model.Propuesta:titulo>").append(this.titulo).append("</model.Propuesta:titulo>\n")
                .append("\t<model.Propuesta:descripcion>").append(this.descripcion).append("</model.Propuesta:descripcion>\n")
                .append("\t<model.Propuesta:fechaExpiracion>").append(this.fechaExpiracion).append("</model.Propuesta:fechaExpiracion>\n")
                .append("\t<model.Propuesta:estado>").append(this.estado).append("</model.Propuesta:estado>\n")
                .append("\t<model.Propuesta:idCongreso>").append(this.idCongreso).append("</model.Propuesta:idCongreso>\n")
                .append("\t<model.Propuesta:numPasaportePolitico>").append(this.numPasaportePolitico).append("</model.Propuesta:numPasaportePolitico>\n")
                .append("\t<model.Propuesta:fechaProposicion>").append(this.fechaProposicion).append("</model.Propuesta:fechaProposicion>\n")
                .append("\t<model.Propuesta:fechaAceptacion>").append(this.fechaAceptacion).append("</model.Propuesta:fechaAceptacion>\n")
                .append("\t<model.Propuesta:fechaPublicacion>").append(this.fechaPublicacion).append("</model.Propuesta:fechaPublicacion>\n")
                .append("</model.Propuesta>");

        return String.valueOf(xmlBuilder);

    }

    /**
     * Metodo que tranforma la información de la propuesta a formato JSON
     * @return JSON con la información de la propuesta
     */
    public String toJSON(){

        StringBuilder jsonBuilder = new StringBuilder();

        jsonBuilder.append("\"PROPUESTA\": {\n")
                .append("\t\"id\": ").append(this.id).append(",\n")
                .append("\t\"titulo\": \"").append(this.titulo).append("\",\n")
                .append("\t\"descripcion\": \"").append(this.descripcion).append("\",\n")
                .append("\t\"fechaExpiracion\": \"").append(this.fechaExpiracion).append("\",\n")
                .append("\t\"estado\": \"").append(this.estado).append("\",\n")
                .append("\t\"idCongreso\": ").append(this.idCongreso).append(",\n")
                .append("\t\"numPasaportePolitico\": \"").append(this.numPasaportePolitico).append("\",\n")
                .append("\t\"fechaProposicion\": \"").append(this.fechaProposicion).append("\",\n")
                .append("\t\"fechaAceptacion\": \"").append(this.fechaAceptacion).append("\",\n")
                .append("\t\"fechaPublicacion\": \"").append(this.fechaPublicacion).append("\",\n")
                .append("}");

        return String.valueOf(jsonBuilder);

    }

    /**
     * Metodo que devuelve el id de la propuesta
     * @return Id de la propuesta
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo que devuelve el título de la propuesta
     * @return String con el Título de la propuesta
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Metodo que establece el título de la propuesta
     * @param titulo Título de la propuesta
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Metodo que devuelve la descripción de la propuesta
     * @return String con la descripción de la propuesta
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Metodo que establece la descripción de la propuesta
     * @param descripcion Descripcion de la propuesta
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Metodo que devuelve la fecha de expiración de la propuesta
     * @return Date Fecha de la expiración de la propuesta
     */
    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    /**
     * Metodo que establece la fecha de expiración de la propuesta
     * @param fechaExpiracion Fecha de expiración de la propuesta
     */
    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    /**
     * Metodo que devuelve el estado de la propuesta
     * @return EstadoPropuesta Estado actual de la propuesta
     */
    public EstadoPropuesta getEstado() {
        return estado;
    }

    /**
     * Metodo que establece el estado de la propuesta
     * @param estado Estado actual de la propuesta
     */
    public void setEstado(EstadoPropuesta estado) {
        this.estado = estado;
    }

    /**
     * Metodo que devuelve el id del congreso asociado a la propuesta
     * @return int Id del congreso
     */
    public int getIdCongreso() {
        return idCongreso;
    }

    /**
     * Metodo que establece el id del congreso asociado a la propuesta
     * @param idCongreso Id del congreso
     */
    public void setIdCongreso(int idCongreso) {
        this.idCongreso = idCongreso;
    }

    /**
     * Metodo que devuelve el número de pasaporte político del proponente
     * @return String Número de pasaporte político
     */
    public String getNumPasaportePolitico() {
        return numPasaportePolitico;
    }

    /**
     * Metodo que establece el número de pasaporte político del proponente
     * @param numPasaportePolitico Número de pasaporte político
     */
    public void setNumPasaportePolitico(String numPasaportePolitico) {
        this.numPasaportePolitico = numPasaportePolitico;
    }

    /**
     * Metodo que devuelve la fecha en que se propuso la propuesta
     * @return Date Fecha de proposición de la propuesta
     */
    public Date getFechaProposicion() {
        return fechaProposicion;
    }

    /**
     * Metodo que establece la fecha en que se propuso la propuesta
     * @param fechaProposicion Fecha de proposición de la propuesta
     */
    public void setFechaProposicion(Date fechaProposicion) {
        this.fechaProposicion = fechaProposicion;
    }

    /**
     * Metodo que devuelve la fecha en que se aceptó la propuesta
     * @return Date Fecha de aceptación de la propuesta
     */
    public Date getFechaAceptacion() {
        return fechaAceptacion;
    }

    /**
     * Metodo que establece la fecha en que se aceptó la propuesta
     * @param fechaAceptacion Fecha de aceptación de la propuesta
     */
    public void setFechaAceptacion(Date fechaAceptacion) {
        this.fechaAceptacion = fechaAceptacion;
    }

    /**
     * Metodo que devuelve la fecha en que se publicó la propuesta
     * @return Date Fecha de publicación de la propuesta
     */
    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    /**
     * Metodo que establece la fecha en que se publicó la propuesta
     * @param fechaPublicacion Fecha de publicación de la propuesta
     */
    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
}