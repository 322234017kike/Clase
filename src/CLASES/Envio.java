package CLASES;

/**
 * Clase abstracta que representa un envio generico.
 * Contiene lo comun a todos los envios (numero de guia y peso);
 * el calculo del costo lo define cada modalidad.
 */
public abstract class Envio {
    protected String numeroGuia;
    protected double peso; // en kg

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

    /** Costo = CostoBase + (Peso x TarifaKg) segun la modalidad. */
    public abstract double calcularCosto();

    /** Nombre de la modalidad de envio. */
    public abstract String getTipo();

    @Override
    public String toString() {
        return "Tipo: " + getTipo()
                + " | Guia: " + numeroGuia
                + " | Peso: " + peso + " kg"
                + " | Costo: $" + String.format("%.2f", calcularCosto());
    }
}
