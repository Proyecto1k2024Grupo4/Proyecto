package model;

/**
 * Representa un país con su ID y nombre, y permite convertirlo a formatos JSON y XML.
 */
public class Pais {

    public int id;
    public String nombre;

    /**
     * Constructor que inicializa el país solo con el nombre.
     *
     * @param nombre Nombre del país.
     */
    public Pais(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Constructor que inicializa el país con un ID y un nombre.
     *
     * @param id     Identificador del país.
     * @param nombre Nombre del país.
     */
    public Pais(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Constructor con parámetros adicionales, actualmente no implementado.
     *
     * @param nombre         Nombre del país.
     * @param numCiudadanos  Número de ciudadanos.
     * @param numPoliticos   Número de políticos.
     */
    public Pais(String nombre, int numCiudadanos, int numPoliticos) {
    }

    /**
     * Convierte el objeto País a una representación XML.
     *
     * @return Cadena con el contenido en formato XML.
     */
    public String toXml() {

        StringBuilder xmlBuilder = new StringBuilder();

        xmlBuilder.append("<model.Pais>\n")
                .append("\t<model.Pais:id>").append(this.id).append("</model.Pais:id>\n")
                .append("\t<model.Pais:nombre>").append(this.nombre).append("</model.Pais:nombre\n")
                .append("</model.Pais>");

        return String.valueOf(xmlBuilder);
    }

    /**
     * Convierte el objeto País a una representación JSON.
     *
     * @return Cadena con el contenido en formato JSON.
     */
    public String toJson() {

        StringBuilder jsonBuilder = new StringBuilder();

        jsonBuilder.append("\"PAIS\": {\n")
                .append("\t\"id\": ").append(this.id).append(",\n")
                .append("\t\"nombre\": \"").append(this.nombre).append("\"\n")
                .append("}");

        return String.valueOf(jsonBuilder);
    }

    /**
     * Obtiene el identificador del país.
     *
     * @return ID del país.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del país.
     *
     * @param id Nuevo ID del país.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del país.
     *
     * @return Nombre del país.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del país.
     *
     * @param nombre Nuevo nombre del país.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
