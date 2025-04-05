package model;

public class Desarrollar {

    private int idPropuesta;
    private int idLey;


    public Desarrollar( int idPropuesta,  int idLey) {
        this.idPropuesta = idPropuesta;
        this.idLey = idLey;
    }


    public String toJson(){
        StringBuilder jsonBuilder = new StringBuilder();

        jsonBuilder.append("\"DESARROLLAR\": {")
                .append("\n")
                .append("\t")
                .append("\"idpropuesta\": ").append(this.idPropuesta)
                .append("\n")
                .append("\t")
                .append("\"idLey\": ").append(this.idLey)
                .append("\n")
                .append("}");

        return String.valueOf(jsonBuilder);
    }

    public String toXml(){
        StringBuilder xmlBuilder = new StringBuilder();

        xmlBuilder.append("<Desarrollo>")
                .append("\n")
                .append("\t")
                .append("<Desarrollo:idPropuesta>").append(this.idPropuesta).append("</Desarrollo:idPropuesta>\n")
                .append("\t")
                .append("<Desarrollo:idLey>").append(this.idLey).append("</Desarrollo:idLey>\n")
                .append("</Desarrollo>");

        return String.valueOf(xmlBuilder);
    }

    public int getIdPropuesta() {
        return idPropuesta;
    }

    public void setIdPropuesta(int idPropuesta) {
        this.idPropuesta = idPropuesta;
    }

    public int getIdLey() {
        return idLey;
    }

    public void setIdLey(int idLey) {
        this.idLey = idLey;
    }
}