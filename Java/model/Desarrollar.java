package model;

/**
 * Representa la tabla Desarrollar y almacena el ID de la Ley y el ID de la propuesta
 * que la desarrolla.
 * @author ABDELMOGHIT SAMINI 1KDAM
 */
public class Desarrollar {
    private int idPropuesta;
    private int idLey;

    // Constructor vacío
    public Desarrollar() {}

    public Desarrollar(int idPropuesta, int idLey) {
        this.idPropuesta = idPropuesta;
        this.idLey = idLey;
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

    public String toJson() {
        return String.format("{ \"idPropuesta\": %d, \"idLey\": %d }", idPropuesta, idLey);
    }

    public String toXml() {
        return String.format(
                "<Desarrollar>" +
                        "<idPropuesta>%d</idPropuesta>" +
                        "<idLey>%d</idLey>" +
                        "</Desarrollar>",
                idPropuesta, idLey
        );
    }

    @Override
    public String toString() {
        return "Desarrollar{idPropuesta=" + idPropuesta + ", idLey=" + idLey + '}';
    }
}
