
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Desarrollar {

    /**
     * Default constructor
     */
    public Desarrollar() {
    }

    private int idPropuesta;
    private int idLey;


    public void desarrollar( int idPropuesta,  int idLey) {

    }

    public String toJson(){
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

    public String toXml(){
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
}