
import java.io.*;
import java.util.*;


public class Ley {

    /**
     * Default constructor
     */
    public Ley() {
    }


    private int id;
    private String descripcion;
    private String fechaAplicacion;
    private String fechaModificacion;
    private String fechaImplementacion;
    private int idCodigoCivil;

    public String toJson(){
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("\"LEY\": {\n")
                .append("\t")
                .append("\"id\": ").append(this.id)
                .append("\n")
                .append("\t")
                .append("\"descripcion\": \"").append(this.descripcion).append("\"")
                .append("\n")
                .append("\t")
                .append("\"fechaAplicacion\": \"").append(this.fechaAplicacion).append("\"")
                .append("\n")
                .append("\t")
                .append("\"fechaModificacion\": \"").append(this.fechaModificacion).append("\"")
                .append("\n")
                .append("\t")
                .append("\"fechaImplementacion\": \"").append(this.fechaImplementacion).append("\"")
                .append("\n")
                .append("\t")
                .append("\"idCodigoCivil: ").append(this.idCodigoCivil)
                .append("\n")
                .append("}");
        return String.valueOf(jsonBuilder);
    }

    public String toXml(){
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<Ley>\n")
                .append("\t")
                .append("<Ley:id>").append(this.id).append("</Ley:id>\n")
                .append("\t")
                .append("<Ley:descripcion>").append(this.descripcion).append("</Ley:descripcion>\n")
                .append("\t")
                .append("<Ley:fechaAplicacion>").append(this.fechaAplicacion).append("<Ley:fechaAplicacion\n")
                .append("\t")
                .append("<Ley:fechaModificacion").append(this.fechaModificacion).append("</Ley:fechaModificacion>\n")
                .append("\t")
                .append("<Ley:fechaImplementacion").append(this.fechaImplementacion).append("</Ley:fechaImplementacion\n")
                .append("\t")
                .append("Ley:idCodigoCivil").append(this.idCodigoCivil).append("</Ley:idCodigoCivil")
                .append("</Ley");

        return String.valueOf(xmlBuilder);
    }

}