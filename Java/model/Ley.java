package model;

import java.sql.Date;

/**
 * Clase Ley que sirve para almacenar la información de las leyes
 * @author Abdel Moghit Samini 1ºK
 * @version 7-4-2025
 */
public class Ley {

    // Propiedades
    private int id;
    private String descripcion;
    private Date fechaAplicacion;
    private Date fechaModificacion;
    private Date fechaImplementacion;
    private int idCodigoCivil;

    /**
     * Constructor sin ID
     * @param descripcion
     * @param fechaAplicacion
     * @param fechaModificacion
     * @param fechaImplementacion
     * @param idCodigoCivil
     */
    public Ley(String descripcion,
               Date fechaAplicacion,
               Date fechaModificacion,
               Date fechaImplementacion,
               int idCodigoCivil) {
        setDescripcion(descripcion);
        // primero impl, luego app y mod para las validaciones
        setFechaImplementacion(fechaImplementacion);
        setFechaAplicacion(fechaAplicacion);
        setFechaModificacion(fechaModificacion);
        setIdCodigoCivil(idCodigoCivil);
    }

    public Ley(int id,
               String descripcion,
               Date fechaAplicacion,
               Date fechaModificacion,
               Date fechaImplementacion,
               int idCodigoCivil) {
        this.id = id;
        setDescripcion(descripcion);
        setFechaImplementacion(fechaImplementacion);
        setFechaAplicacion(fechaAplicacion);
        setFechaModificacion(fechaModificacion);
        setIdCodigoCivil(idCodigoCivil);
    }

    public String toJson(){
        return String.format(
                "{\"LEY\": {\n" +
                        "  \"id\": %d,\n" +
                        "  \"descripcion\": \"%s\",\n" +
                        "  \"fechaAplicacion\": \"%s\",\n" +
                        "  \"fechaModificacion\": \"%s\",\n" +
                        "  \"fechaImplementacion\": \"%s\",\n" +
                        "  \"idCodigoCivil\": %d\n" +
                        "}}",
                id,
                descripcion,
                fechaAplicacion,
                fechaModificacion,
                fechaImplementacion,
                idCodigoCivil
        );
    }

    public String toXml() {
        return String.format(
                "<Ley>\n" +
                        "  <id>%d</id>\n" +
                        "  <descripcion>%s</descripcion>\n" +
                        "  <fechaAplicacion>%s</fechaAplicacion>\n" +
                        "  <fechaModificacion>%s</fechaModificacion>\n" +
                        "  <fechaImplementacion>%s</fechaImplementacion>\n" +
                        "  <idCodigoCivil>%d</idCodigoCivil>\n" +
                        "</Ley>",
                id,
                descripcion,
                fechaAplicacion,
                fechaModificacion,
                fechaImplementacion,
                idCodigoCivil
        );
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFechaAplicacion() {
        return fechaAplicacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public Date getFechaImplementacion() {
        return fechaImplementacion;
    }

    public int getIdCodigoCivil() {
        return idCodigoCivil;
    }

    // Setters
    public void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.length() > 2000) {
            throw new IllegalArgumentException(
                    "Error, la descripción de la ley no puede tener más de 2000 caracteres"
            );
        }
        this.descripcion = descripcion;
    }

    public void setFechaImplementacion(Date fechaImplementacion) {
        this.fechaImplementacion = fechaImplementacion;
    }

    public void setFechaAplicacion(Date fechaAplicacion) {
        if (fechaAplicacion != null
                && this.fechaImplementacion != null
                && fechaAplicacion.before(this.fechaImplementacion)) {
            throw new IllegalArgumentException(
                    "La fecha de aplicación no puede ser anterior a la fecha de implementación."
            );
        }
        this.fechaAplicacion = fechaAplicacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        if (fechaModificacion != null
                && this.fechaImplementacion != null
                && fechaModificacion.before(this.fechaImplementacion)) {
            throw new IllegalArgumentException(
                    "La fecha de modificación no puede ser anterior a la fecha de implementación."
            );
        }
        this.fechaModificacion = fechaModificacion;
    }

    public void setIdCodigoCivil(int idCodigoCivil) {
        this.idCodigoCivil = idCodigoCivil;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Ley{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", fechaAplicacion=" + fechaAplicacion +
                ", fechaModificacion=" + fechaModificacion +
                ", fechaImplementacion=" + fechaImplementacion +
                ", idCodigoCivil=" + idCodigoCivil +
                '}';
    }
}
