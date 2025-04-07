package model;

import java.util.ArrayList;

public class Congreso {


    public Congreso(int id) {
    }

  /**
     * Las Variables
     */
    private int id;
    private int idPais;
    private ArrayList<Politico> politicos;

    /**
     * Constructor principal que inicializa el congreso con un ID y el ID del país.
     *
     * @param id      Identificador del congreso.
     * @param idPais  Identificador del país al que pertenece el congreso.
     */
    public Congreso(int id, int idPais){
        this.id = id;
        this.idPais = idPais;
    }
       /**
     * Constructor con parámetros adicionales, aún no implementado.
     *
     * @param id             Identificador del congreso.
     * @param numPoliticos   Número de políticos.
     * @param propAprobadas  Cantidad de propuestas aprobadas.
     */
    public Congreso(int id, int numPoliticos, int propAprobadas) {
    }
  /**
     * Acepta una propuesta en el congreso dado su identificador.
     *
     * @param idPropuesta ID de la propuesta que será aceptada.
     */
    public void aceptarPropuesta(int idPropuesta) {

    }
      /**
     * Publica una propuesta en el congreso.
     */
    public void publicarPropuesta() {}

    /**
     * Convierte el objeto Congreso en una representación XML.
     *
     * @return Cadena en formato XML representando el objeto.
     */
    public String toXml(){
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<model.Congreso>\n")
                .append(" <id>").append(id).append("</id>\n")
                .append(" <idPais>").append(idPais).append("<idPais>\n")
                .append("<model.Congreso>");

        return xmlBuilder.toString();
    }
  /**
     * Convierte el objeto Congreso en una representación JSON.
     *
     * @return Cadena en formato JSON representando el objeto.
     */
    public String toJson(){
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{\n")
                .append(" \"id\": ").append(id).append(",\n")
                .append(" \"idPais\": \"").append(idPais).append("\",\n")
                .append("}");

        return jsonBuilder.toString();

    }
 /**
     * Obtiene el identificador del congreso.
     *
     * @return ID del congreso.
     */
    public int getId() {
        return id;
    }
 /**
     * Obtiene el identificador del país asociado al congreso.
     *
     * @return ID del país.
     */
    public int getIdPais() {
        return idPais;
    }
 /**
     * Obtiene la lista de políticos que conforman el congreso.
     *
     * @return Lista de objetos Politico.
     */
    public ArrayList<Politico> getPoliticos() {
        return politicos;
    }
}
