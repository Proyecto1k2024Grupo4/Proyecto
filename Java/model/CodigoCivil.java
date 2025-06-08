package model;

import java.sql.Date;
import java.util.*;

/**
 * Representa un Código Civil con su identificador, el del país al que pertenece y las leyes asociadas.
 * Permite convertir a formatos JSON y XML.
 * @author ABDELMOGHIT SAMINI 1KDAM
 */
public class CodigoCivil {

    private int id;
    private Date fecha;
    private int idPais;
    private ArrayList<Ley> leyes;

    /**
     * Constructor de la clase CodigoCivil.
     *
     * @param idPais  Identificador del Pais.
     * @param fecha Fecha de creación.
     */
    public CodigoCivil(int idPais, Date fecha) {
        this.idPais = idPais;
        this.fecha = fecha;
    }

    public CodigoCivil(int id, int idPais) {
        this.id = id;
        this.idPais = idPais;
    }

    /**
     * Constructor de la clase CodigoCivil.
     * @param id Identificador del código civil.
     * @param idPais  Identificador del Pais.
     * @param fecha Fecha de creación.
     */
    public CodigoCivil(int id, int idPais, Date fecha) {
        this.id = id;
        this.idPais = idPais;
        this.fecha = fecha;
        this.leyes = new ArrayList<>();
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
 public String toXml() {
     StringBuilder xmlBuilder = new StringBuilder();
     xmlBuilder.append("<model.CodigoCivil>")
             .append("\n")
             .append("<id>").append(this.id).append("</id>\n")
             .append("<idPais>").append(this.idPais).append("</idPais>\n")
             .append("<fecha>").append(this.fecha).append("</fecha>\n")
             .append("</model.CodigoCivil>");
     return xmlBuilder.toString();
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "CodigoCivil{" +
                "id=" + id +
                ", fecha='" + fecha + '\'' +
                ", idPais=" + idPais +
                ", leyes=" + leyes +
                '}';
    }
}
