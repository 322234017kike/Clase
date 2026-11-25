package EVENTOS;

public class Instructor implements Clave {
    private String clave;
    private String nombre;

    public Instructor(String clave, String nombre) {
        this.clave = clave;
        this.nombre = nombre;
    }

    @Override
    public String getClave() { return clave; }
    public String getNombre() { return nombre; }

    public void mostrarInformacion() {
        System.out.println("Clave: " + clave);
        System.out.println("Nombre: " + nombre);
    }
}
