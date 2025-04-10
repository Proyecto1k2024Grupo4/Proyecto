package model;

/**
 * Clase Votar que guarda la información de las votaciones de los ciudadanos a las propuestas
 * @author Diego Fernando Valencia Correa 1ºK
 * @version 7-4-2025
 */
public class Votar {

    // Propiedades
    private String numPasaporteCiudadano;
    private int idPropuesta;
    private boolean decision;

    /**
     * Constructor de Votar con todos los parámetros
     * @param numPasaporteCiudadano Número de pasaporte del ciudadano
     * @param idPropuesta Id de la propuesta
     * @param decision Boolean que indica el voto de la propuesta: true->a favor, false-> en contra
     */
    public Votar(String numPasaporteCiudadano, int idPropuesta, boolean decision) {
        this.numPasaporteCiudadano = numPasaporteCiudadano;
        this.idPropuesta = idPropuesta;
        this.decision = decision;
    }

    /**
     * Metodo que transforma la información del voto a XML
     * @return XML con la información del voto
     */
    public String toXml() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<model.Votar>\n")
                .append(" <numPasaporteCiudadano>").append(numPasaporteCiudadano).append("</numPasaporteCiudadano>\n")
                .append(" <idPropuesta>").append(idPropuesta).append("</idPropuesta>\n")
                .append(" <decision>").append(decision).append("</decision>\n")
                .append("</model.Votar>");
        return xmlBuilder.toString();
    }

    /**
     * Metodo que transforma la información del voto a JSON
     * @return JSON con la información del voto
     */
    public String toJson() {
    StringBuilder jsonBuilder = new StringBuilder();
    jsonBuilder.append("{\n")
            .append(" \"numPasaporteCiudadano\": ").append(numPasaporteCiudadano).append(",\n")
            .append(" \"idPropuesta\": ").append(idPropuesta).append(",\n")
            .append(" \"decision\": ").append(decision).append("\n")
            .append("}");
    return jsonBuilder.toString();
    }

    /**
     * Metodo que devuelve el número de pasaporte del ciudadano
     * @return String con el numero de pasaporte
     */
    public String getNumPasaporteCiudadano() {
        return numPasaporteCiudadano;
    }

    /**
     * Metodo que devuelve el id de la propuesta
     * @return int con el id de la propuesta
     */
    public int getIdPropuesta() {
        return idPropuesta;
    }

    /**
     * Metodo que devuelve la decision de voto del ciudadano
     * @return Booolean con la decision
     */
    public boolean getDecision() {
        return decision;
    }

}