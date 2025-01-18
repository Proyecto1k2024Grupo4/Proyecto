public class Pais {

    public int id;
    public String nombre;

    public Pais() {
    }

    public String toXml(){

        StringBuilder xmlBuilder = new StringBuilder();

        xmlBuilder.append("<Pais>\n")
                .append("\t<Pais:id>").append(this.id).append("</Pais:id>\n")
                .append("\t<Pais:nombre>").append(this.nombre).append("</Pais:nombre\n")
                .append("</Pais>");

        return String.valueOf(xmlBuilder);

    }


    public String toJson(){

        StringBuilder jsonBuilder = new StringBuilder();

        jsonBuilder.append("\"PAIS\": {\n")
                .append("\t\"id\": ").append(this.id).append(",\n")
                .append("\t\"nombre\": \"").append(this.nombre).append("\"\n")
                .append("}");

        return String.valueOf(jsonBuilder);
    }

}