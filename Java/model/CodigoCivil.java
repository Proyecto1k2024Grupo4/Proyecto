package model;

import java.util.*;

/**
 * Representa un Código Civil con su identificador, el del país al que pertenece y las leyes asociadas.
 * Permite convertir a formatos JSON y XML.
 */
public class CodigoCivil {

    /**
     * Constructor de la clase CodigoCivil.
     *
     * @param id  Identificador del código civil.
     * @param fecha Fecha de creación.
     */
    public CodigoCivil(int id, String fecha) {
    }

    private int id;
    String fecha;
    private int idPais;
    private ArrayList<Ley> leyes;

    public CodigoCivil(int id, int idPais, String fecha) {
    }

    /**
     * Convierte el objeto CodigoCivil en una representación JSON.
     *
     * @return Cadena en formato JSON que representa el objeto.
     */
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
 /**
     * Convierte el objeto CodigoCivil en una representación XML.
     *
     * @return Cadena en formato XML que representa el objeto.
     */
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
  /**
     * Obtiene el identificador del código civil.
     *
     * @return El ID del código civil.
     */
    public int getId() {
        return id;
    }
    /**
     * Obtiene el identificador del país.
     *
     * @return El ID del país.
     */
    public int getIdPais() {
        return idPais;
    }
      /**
     * Obtiene lista de Leyes.
     *
     * @return La lista de leyes.
     */

    public ArrayList<Ley> getLeyes() {
        return leyes;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
