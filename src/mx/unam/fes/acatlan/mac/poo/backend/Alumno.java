package mx.unam.fes.acatlan.mac.poo.backend;

import java.util.Date;

public class Alumno extends Persona {
    private String foto;
    private String cuenta;
    private String promedio;
    private Curso curso;
    private Profesor profesor;

    public Alumno(String foto,  String cuenta, String promedio,String nombre, String apellidoP, String apellidoM, Genero genero, Date fechaNac) {
        super(nombre, apellidoP, apellidoM, genero, fechaNac);
        this.promedio=promedio;
        this.cuenta=cuenta;
        this.foto=foto;
    }

    public void registrarCurso(Curso curso) {
        this.curso=curso;
    }

    public void eliminarCurso() {
        curso=null;
    }

    public void agregarTutor(Profesor profesor) {
        this.profesor=profesor;
    }

    public void eliminarTutor() {
        profesor=null;
    }

    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }
    public String getCuenta() {
        return cuenta;
    }
    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }
    public String getPromedio() {
        return promedio;
    }
    public void setPromedio(String promedio) {
        this.promedio = promedio;
    }
    public Curso getCurso() {
        return curso;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    public Profesor getProfesor() {
        return profesor;
    }
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}
