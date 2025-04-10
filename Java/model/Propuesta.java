package model;

import java.sql.Date;

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

    public Propuesta() {
    }

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

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public EstadoPropuesta getEstado() {
        return estado;
    }

    public void setEstado(EstadoPropuesta estado) {
        this.estado = estado;
    }

    public int getIdCongreso() {
        return idCongreso;
    }

    public void setIdCongreso(int idCongreso) {
        this.idCongreso = idCongreso;
    }

    public String getNumPasaportePolitico() {
        return numPasaportePolitico;
    }

    public void setNumPasaportePolitico(String numPasaportePolitico) {
        this.numPasaportePolitico = numPasaportePolitico;
    }

    public Date getFechaProposicion() {
        return fechaProposicion;
    }

    public void setFechaProposicion(Date fechaProposicion) {
        this.fechaProposicion = fechaProposicion;
    }

    public Date getFechaAceptacion() {
        return fechaAceptacion;
    }

    public void setFechaAceptacion(Date fechaAceptacion) {
        this.fechaAceptacion = fechaAceptacion;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
}