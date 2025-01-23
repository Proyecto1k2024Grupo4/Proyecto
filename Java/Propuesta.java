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

        xmlBuilder.append("<Propuesta>\n")
                .append("\t<Propuesta:id>").append(this.id).append("</Propuesta:id>\n")
                .append("\t<Propuesta:titulo>").append(this.titulo).append("</Propuesta:titulo>\n")
                .append("\t<Propuesta:descripcion>").append(this.descripcion).append("</Propuesta:descripcion>\n")
                .append("\t<Propuesta:fechaExpiracion>").append(this.fechaExpiracion).append("</Propuesta:fechaExpiracion>\n")
                .append("\t<Propuesta:estado>").append(this.estado).append("</Propuesta:estado>\n")
                .append("\t<Propuesta:idCongreso>").append(this.idCongreso).append("</Propuesta:idCongreso>\n")
                .append("\t<Propuesta:numPasaportePolitico>").append(this.numPasaportePolitico).append("</Propuesta:numPasaportePolitico>\n")
                .append("\t<Propuesta:fechaProposicion>").append(this.fechaProposicion).append("</Propuesta:fechaProposicion>\n")
                .append("\t<Propuesta:fechaAceptacion>").append(this.fechaAceptacion).append("</Propuesta:fechaAceptacion>\n")
                .append("\t<Propuesta:fechaPublicacion>").append(this.fechaPublicacion).append("</Propuesta:fechaPublicacion>\n")
                .append("</Propuesta>");

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