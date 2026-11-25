package EVENTOS;

public class Espacio implements Clave {
    private String clave;
    private String nombre;

    public Espacio(String clave, String nombre) {
        this.clave = clave;
        this.nombre = nombre;
    }

    @Override
    public String getClave() { return clave; }

    public void mostrarInformacion() {
        System.out.println("Clave: " + clave);
        System.out.println("Nombre: " + nombre);
    }
}
