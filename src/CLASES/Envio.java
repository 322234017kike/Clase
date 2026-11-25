package CLASES;

/** Clase abstracta: lo comun de todos los envios. */
public abstract class Envio {
    protected String numeroGuia;
    protected double peso;

    public Envio(String numeroGuia, double peso) {
        this.numeroGuia = numeroGuia;
        this.peso = peso;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }

    public double getPeso() {
        return peso;
    }

    // Cada tipo de envio calcula su costo de forma distinta
    public abstract double calcularCosto();

    @Override
    public String toString() {
        return "Guia: " + numeroGuia + " | Peso: " + peso + " kg";
    }
}
