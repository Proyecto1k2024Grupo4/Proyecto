
import java.io.*;
import java.util.*;

public class CodigoCivil {

    /**
     * Default constructor
     */
    public CodigoCivil() {
    }

    private int id;
    private int idPais;

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

    public String toXml(){
        StringBuilder xmlBuilder = new StringBuilder();

        xmlBuilder.append("<CodigoCivil>")
                .append("\n")
                .append("<CodigoCivil:id>").append(this.id).append("</CodigoCivil:id>\n")
                .append("\t")
                .append("<CodigoCivil:idPais>").append(this.idPais).append("</CodigoCivil:idPais>\n")
                .append("</CodigoCivil");

        return String.valueOf(xmlBuilder);
    }

}