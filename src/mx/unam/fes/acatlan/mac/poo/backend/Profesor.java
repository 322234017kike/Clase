package mx.unam.fes.acatlan.mac.poo.backend;

import java.util.Date;

public class Profesor extends Persona{
    private String cedula;
    private Integer noTrabajador;

    public Profesor(String cedula,Integer noTrabajador,String nombre, String apellidoP, String apellidoM, Genero genero, Date fechaNac) {
        super(nombre, apellidoP, apellidoM, genero, fechaNac);
        this.cedula=cedula;
        this.noTrabajador=noTrabajador;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Integer getNoTrabajador() {
        return noTrabajador;
    }

    public void setNoTrabajador(Integer noTrabajador) {
        this.noTrabajador = noTrabajador;
    }

    @Override
    public String toString() {
        return nombre+" "+apellidoP+" "+apellidoM;
    }
}
