package model;

/**
 * Clase que representa la relación entre una propuesta y una ley.
 * Se utiliza para modelar la asociación entre ambas entidades mediante sus identificadores.
 * Incluye métodos para convertir el objeto a formatos JSON y XML.
 * @author ABDELMOGHIT SAMINI
 */
public class Desarrollar {
    private int idPropuesta;
    private int idLey;

    // Constructor vacío
    public Desarrollar() {}

     /**
     * Constructor con parámetros.
     * @param idPropuesta ID de la propuesta asociada
     * @param idLey ID de la ley asociada
     */
    public Desarrollar(int idPropuesta, int idLey) {
        this.idPropuesta = idPropuesta;
        this.idLey = idLey;
    }
     /**
         * Obtiene el ID de la propuesta.
         * @return ID de la propuesta
         */
    public int getIdPropuesta() {
        return idPropuesta;
    }
      /**
         * Establece el ID de la propuesta.
         * @param idPropuesta nuevo ID de la propuesta
         */
    public void setIdPropuesta(int idPropuesta) {
        this.idPropuesta = idPropuesta;
    }
     /**
         * Obtiene el ID de la ley.
         * @return ID de la ley
         */
    public int getIdLey() {
        return idLey;
    }

      /**
     * Establece el ID de la ley.
     * @param idLey nuevo ID de la ley
     */
    public void setIdLey(int idLey) {
        this.idLey = idLey;
    }
     /**
         * Convierte el objeto a formato JSON.
         * @return representación JSON del objeto
         */
    public String toJson() {
        return String.format("{ \"idPropuesta\": %d, \"idLey\": %d }", idPropuesta, idLey);
    }

        /**
         * Convierte el objeto a formato XML.
         * @return representación XML del objeto
         */
    public String toXml() {
        return String.format(
                "<Desarrollar>" +
                        "<idPropuesta>%d</idPropuesta>" +
                        "<idLey>%d</idLey>" +
                        "</Desarrollar>",
                idPropuesta, idLey
        );
    }
         /**
         * Devuelve una representación en cadena del objeto.
         * @return representación en texto del objeto Desarrollar
         */

    @Override
    public String toString() {
        return "Desarrollar{idPropuesta=" + idPropuesta + ", idLey=" + idLey + '}';
    }
}
