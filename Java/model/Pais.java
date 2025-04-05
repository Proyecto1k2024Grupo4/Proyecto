package model;

public class Pais {

    public int id;
    public String nombre;

    public Pais(String nombre){
        this.nombre = nombre;
    }

    public Pais(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}