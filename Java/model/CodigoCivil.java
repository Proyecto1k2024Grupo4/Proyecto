package model;

import java.util.*;

public class CodigoCivil {

    /**
     * Default constructor
     */
    public CodigoCivil(int i, int id, String fecha) {
    }

    private int id;
    private int idPais;
    private ArrayList<Ley> leyes;

    public String toJson(){
        StringBuilder jsonBuilder = new StringBuilder();

        jsonBuilder.append("\"CODIGO_CIVIL\": {")
                .append("\n")
                .append("\t")
                .append("\"id\": ").append(this.id)
                .append("\n")
                .append("\t")
                .append("\"idPais\": ").append(this.idPais)
                .append("\n")
                .append("}");
        return String.valueOf(jsonBuilder);
    }

    public String toXml(){
        StringBuilder xmlBuilder = new StringBuilder();

        xmlBuilder.append("<model.CodigoCivil>")
                .append("\n")
                .append("<model.CodigoCivil:id>").append(this.id).append("</model.CodigoCivil:id>\n")
                .append("\t")
                .append("<model.CodigoCivil:idPais>").append(this.idPais).append("</model.CodigoCivil:idPais>\n")
                .append("</model.CodigoCivil");

        return String.valueOf(xmlBuilder);
    }

    public int getId() {
        return id;
    }

    public int getIdPais() {
        return idPais;
    }

    public ArrayList<Ley> getLeyes() {
        return leyes;
    }
}