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
        xmlBuilder.append("<Persona>\n")
                .append("\t<Persona:numPasaporte>").append(this.numPasaporte).append("</Persona:numPasaporte>\n")
                .append("\t<Persona:fechaIniciacion>").append(this.fechaIniciacion).append("</Persona:fechaIniciacion>\n")
                .append("\t<Persona:fechaRetirada>").append(this.fechaRetirada).append("</Persona:fechaRetirada>\n")
                .append("\t<Persona:nombre>").append(this.nombre).append("</Persona:nombre>\n")
                .append("\t<Persona:primerApellido>").append(this.primerApellido).append("</Persona:primerApellido>\n")
                .append("\t<Persona:segundoApellido>").append(this.segundoApellido).append("</Persona:segundoApellido>\n")
                .append("\t<Persona:fnac>").append(this.fnac).append("</Persona:fnac>\n")
                .append("\t<Persona:sexo>").append(this.sexo).append("</Persona:sexo>\n")
                .append("\t<Persona:paisNacimiento>").append(this.paisNacimiento).append("</Persona:paisNacimiento>\n")
                .append("</Persona>");

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