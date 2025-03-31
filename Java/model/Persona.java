package model;

public class Persona {

    protected String numPasaporte;
    protected String nombre;
    protected String primerApellido;
    protected String segundoApellido;
    protected String fnac;
    protected Sexo sexo;
    protected int paisNacimiento;

    public Persona() {

    }

    public String toXml(){
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<model.Persona>\n")
                .append("\t<model.Persona:numPasaporte>").append(this.numPasaporte).append("</model.Persona:numPasaporte>\n")
                .append("\t<model.Persona:nombre>").append(this.nombre).append("</model.Persona:nombre>\n")
                .append("\t<model.Persona:primerApellido>").append(this.primerApellido).append("</model.Persona:primerApellido>\n")
                .append("\t<model.Persona:segundoApellido>").append(this.segundoApellido).append("</model.Persona:segundoApellido>\n")
                .append("\t<model.Persona:fnac>").append(this.fnac).append("</model.Persona:fnac>\n")
                .append("\t<model.Persona:sexo>").append(this.sexo).append("</model.Persona:sexo>\n")
                .append("\t<model.Persona:paisNacimiento>").append(this.paisNacimiento).append("</model.Persona:paisNacimiento>\n")
                .append("</model.Persona>");

            return String.valueOf(xmlBuilder);
    }

    public String toJson(){
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("\"PERSONA\": {\n")
                .append("\t\"numPasaporte\": \"").append(this.numPasaporte).append("\",\n")
                .append("\t\"nombre\": \"").append(this.nombre).append("\",\n")
                .append("\t\"primerApellido\": \"").append(this.primerApellido).append("\",\n")
                .append("\t\"segundoApellido\": \"").append(this.segundoApellido).append("\",\n")
                .append("\t\"fnac\": \"").append(this.fnac).append("\",\n")
                .append("\t\"sexo\": \"").append(this.sexo).append("\",\n")
                .append("\t\"paisNacimiento\": ").append(this.paisNacimiento).append("\n")
                .append("}");

        return String.valueOf(jsonBuilder);
    }

    public String getNumPasaporte() {
        return numPasaporte;
    }

    public void setNumPasaporte(String numPasaporte) {
        this.numPasaporte = numPasaporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getFnac() {
        return fnac;
    }

    public void setFnac(String fnac) {
        this.fnac = fnac;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public int getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(int paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }
}