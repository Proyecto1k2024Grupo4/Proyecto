package model;

public class Propuesta {

    public int id;
    public String titulo;
    public String descripcion;
    public String fechaExpiracion;
    public EstadoPropuesta estado;
    public String idCongreso;
    public String numPasaportePolitico;
    public String fechaProposicion;
    public String fechaAceptacion;
    public String fechaPublicacion;

    public Propuesta() {
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

}