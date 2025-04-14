package model;
/**
 * @author ABDELMOGHIT SAMINI 1KDAM
 * Representa la relación entre una propuesta y una ley, con métodos para convertir el objeto a JSON y XML.
 */
public class Desarrollar {

    private int idPropuesta;
    private int idPais;
    private int idCodigoCivil;
    private int idLey;

    /**
     * Constructor que inicializa los campos con los valores proporcionados.
     *
     * @param idPropuesta Identificador de la propuesta.
     * @param idLey       Identificador de la ley.
     */
    public Desarrollar(int idPropuesta, int idLey ) {
        this.idPropuesta = idPropuesta;
        this.idLey = idLey;
    }

    /**
     * Convierte el objeto en una representación JSON.
     *
     * @return Cadena con el formato JSON del objeto.
     */
    public String toJson() {
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

    /**
     * Convierte el objeto en una representación XML.
     *
     * @return Cadena con el formato XML del objeto.
     */
    public String toXml() {
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

    /**
     * Obtiene el identificador de la propuesta.
     *
     * @return ID de la propuesta.
     */
    public int getIdPropuesta() {
        return idPropuesta;
    }

    /**
     * Establece el identificador de la propuesta.
     *
     * @param idPropuesta Nuevo ID de la propuesta.
     */
    public void setIdPropuesta(int idPropuesta) {
        this.idPropuesta = idPropuesta;
    }

    /**
     * Obtiene el identificador de la ley.
     *
     * @return ID de la ley.
     */
    public int getIdLey() {
        return idLey;
    }

    /**
     * Establece el identificador de la ley.
     *
     * @param idLey Nuevo ID de la ley.
     */
    public void setIdLey(int idLey) {
        this.idLey = idLey;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public int getIdCodigoCivil() {
        return idCodigoCivil;
    }

    public void setIdCodigoCivil(int idCodigoCivil) {
        this.idCodigoCivil = idCodigoCivil;
    }

    @Override
    public String toString() {
        return "Desarrollar{" +
                "idPropuesta=" + idPropuesta +
                ", idPais=" + idPais +
                ", idCodigoCivil=" + idCodigoCivil +
                ", idLey=" + idLey +
                '}';
    }
}
