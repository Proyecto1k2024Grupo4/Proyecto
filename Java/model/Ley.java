package model;


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

    public Ley(int id, String descripcion, String fImpl, String fAplica, String fMod) {
    }

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
        xmlBuilder.append("<model.Ley>\n")
                .append("\t")
                .append("<model.Ley:id>").append(this.id).append("</model.Ley:id>\n")
                .append("\t")
                .append("<model.Ley:descripcion>").append(this.descripcion).append("</model.Ley:descripcion>\n")
                .append("\t")
                .append("<model.Ley:fechaAplicacion>").append(this.fechaAplicacion).append("<model.Ley:fechaAplicacion\n")
                .append("\t")
                .append("<model.Ley:fechaModificacion").append(this.fechaModificacion).append("</model.Ley:fechaModificacion>\n")
                .append("\t")
                .append("<model.Ley:fechaImplementacion").append(this.fechaImplementacion).append("</model.Ley:fechaImplementacion\n")
                .append("\t")
                .append("model.Ley:idCodigoCivil").append(this.idCodigoCivil).append("</model.Ley:idCodigoCivil")
                .append("</model.Ley");

        return String.valueOf(xmlBuilder);
    }

}