package model;

public class Pais {

    public int id;
    public String nombre;

    public Pais() {
    }

    public String toXml(){

        StringBuilder xmlBuilder = new StringBuilder();

        xmlBuilder.append("<model.Pais>\n")
                .append("\t<model.Pais:id>").append(this.id).append("</model.Pais:id>\n")
                .append("\t<model.Pais:nombre>").append(this.nombre).append("</model.Pais:nombre\n")
                .append("</model.Pais>");

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