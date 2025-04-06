package model;

import java.util.ArrayList;

public class Congreso {


    public Congreso(int id) {
    }

    private int id;
    private int idPais;
    private ArrayList<Politico> politicos;


    public Congreso(int id, int idPais){
        this.id = id;
        this.idPais = idPais;
    }

    public Congreso(int id, int numPoliticos, int propAprobadas) {
    }

    public void aceptarPropuesta(int idPropuesta) {

    }
    public void publicarPropuesta() {}

    public String toXml(){
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<model.Congreso>\n")
                .append(" <id>").append(id).append("</id>\n")
                .append(" <idPais>").append(idPais).append("<idPais>\n")
                .append("<model.Congreso>");

        return xmlBuilder.toString();
    }

    public String toJson(){
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{\n")
                .append(" \"id\": ").append(id).append(",\n")
                .append(" \"idPais\": \"").append(idPais).append("\",\n")
                .append("}");

        return jsonBuilder.toString();

    }

    public int getId() {
        return id;
    }

    public int getIdPais() {
        return idPais;
    }

    public ArrayList<Politico> getPoliticos() {
        return politicos;
    }
}