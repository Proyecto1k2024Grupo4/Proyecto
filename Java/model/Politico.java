package model;

public class Politico extends Persona{

    // Propiedades
    public String numPasaporte;
    public String fechaIniciacion;
    public String fechaRetirada;
    public int idCongreso;

    public Politico() {
    }

    public void proponer(String titulo, String descripcion) {

    }
    @Override
    public String toXml(){
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<model.Persona>\n")
                .append("\t<model.Persona:numPasaporte>").append(this.numPasaporte).append("</model.Persona:numPasaporte>\n")
                .append("\t<model.Persona:fechaIniciacion>").append(this.fechaIniciacion).append("</model.Persona:fechaIniciacion>\n")
                .append("\t<model.Persona:fechaRetirada>").append(this.fechaRetirada).append("</model.Persona:fechaRetirada>\n")
                .append("\t<model.Persona:nombre>").append(this.nombre).append("</model.Persona:nombre>\n")
                .append("\t<model.Persona:primerApellido>").append(this.primerApellido).append("</model.Persona:primerApellido>\n")
                .append("\t<model.Persona:segundoApellido>").append(this.segundoApellido).append("</model.Persona:segundoApellido>\n")
                .append("\t<model.Persona:fnac>").append(this.fnac).append("</model.Persona:fnac>\n")
                .append("\t<model.Persona:sexo>").append(this.sexo).append("</model.Persona:sexo>\n")
                .append("\t<model.Persona:paisNacimiento>").append(this.paisNacimiento).append("</model.Persona:paisNacimiento>\n")
                .append("</model.Persona>");

        return String.valueOf(xmlBuilder);
    }

    @Override
    public String toJson(){
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("\"PERSONA\": {\n")
                .append("\t\"numPasaporte\": \"").append(this.numPasaporte).append("\",\n")
                .append("\t\"fechaIniciacion\": \"").append(this.fechaIniciacion).append("\",\n")
                .append("\t\"fechaRetirada\": \"").append(this.fechaRetirada).append("\",\n")
                .append("\t\"nombre\": \"").append(this.nombre).append("\",\n")
                .append("\t\"primerApellido\": \"").append(this.primerApellido).append("\",\n")
                .append("\t\"segundoApellido\": \"").append(this.segundoApellido).append("\",\n")
                .append("\t\"fnac\": \"").append(this.fnac).append("\",\n")
                .append("\t\"sexo\": \"").append(this.sexo).append("\",\n")
                .append("\t\"paisNacimiento\": ").append(this.paisNacimiento).append("\n")
                .append("}");

        return String.valueOf(jsonBuilder);
    }
}