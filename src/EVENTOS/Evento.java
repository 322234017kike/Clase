package EVENTOS;

public abstract class Evento implements Clave {
    protected String clave;
    protected String nombre;
    protected String lugar;
    protected int capacidadMaxima;
    protected double costoBase;
    protected int duracionHoras;

    public Evento(String clave, String nombre, String lugar,
                  int capacidadMaxima, double costoBase, int duracionHoras) {
        if (costoBase < 0)
            throw new IllegalArgumentException("El costo base no puede ser negativo.");
        if (capacidadMaxima <= 0)
            throw new IllegalArgumentException("La capacidad máxima debe ser mayor a cero.");
        this.clave = clave;
        this.nombre = nombre;
        this.lugar = lugar;
        this.capacidadMaxima = capacidadMaxima;
        this.costoBase = costoBase;
        this.duracionHoras = duracionHoras;
    }

    @Override
    public String getClave() { return clave; }

    /** Cada tipo de evento calcula su costo de forma distinta. */
    public abstract double calcularCosto();

    public void mostrarInformacion() {
        System.out.println("----------------------------------------");
        System.out.println("Categoría: " + getClass().getSimpleName());
        System.out.println("Clave: " + clave);
        System.out.println("Nombre: " + nombre);
        System.out.println("Lugar: " + lugar);
        System.out.println("Capacidad máxima: " + capacidadMaxima);
        System.out.println("Duración: " + duracionHoras + " h");
        System.out.println("Costo base: $" + String.format("%.2f", costoBase));
        System.out.println("Costo: $" + String.format("%.2f", calcularCosto()));
    }
}
