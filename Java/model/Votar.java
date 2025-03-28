package model;

public class Votar {

    private int numPasaporteCiudadano;

    private int idPropuesta;

    private boolean decision;


    public Votar(int numPasaporteCiudadano, int idPropuesta, boolean decision) {
        this.numPasaporteCiudadano = numPasaporteCiudadano;
        this.idPropuesta = idPropuesta;
        this.decision = decision;
    }
    public String toXml() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<model.Votar>\n")
                .append(" <numPasaporteCiudadano>").append(numPasaporteCiudadano).append("</numPasaporteCiudadano>\n")
                .append(" <idPropuesta>").append(idPropuesta).append("</idPropuesta>\n")
                .append(" <decision>").append(decision).append("</decision>\n")
                .append("</model.Votar>");
        return xmlBuilder.toString();
    }
      public String toJson() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{\n")
                .append(" \"numPasaporteCiudadano\": ").append(numPasaporteCiudadano).append(",\n")
                .append(" \"idPropuesta\": ").append(idPropuesta).append(",\n")
                .append(" \"decision\": ").append(decision).append("\n")
                .append("}");
        return jsonBuilder.toString();
    }

}