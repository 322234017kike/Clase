package mx.unam.fes.acatlan.mac.poo.backend;

import java.util.Date;

public class Persona {
    protected Date fechaNac;
    protected Genero genero;
    protected String nombre;
    protected String apellidoP;
    protected String apellidoM;

    public Persona(String nombre, String apellidoP, String apellidoM, Genero genero, Date fechaNac) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.genero = genero;
        this.fechaNac = fechaNac;
    }

    /**
     * Imprime en consola los datos de la persona.
     */
    public void imprimirDatos() {
        System.out.println("Nombre: " + nombre + " " + apellidoP + " " + apellidoM);
        System.out.println("Fecha de Nacimiento: " + fechaNac);
        System.out.println("Sexo: " + genero);
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }
}
