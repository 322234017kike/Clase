package CLASES;

public class EnvioNacional extends Envio {

    public EnvioNacional(String numeroGuia, double peso) {
        super(numeroGuia, peso);
    }

    @Override
    public double calcularCosto() {
        return 50 + (peso * 12);
    }

    @Override
    public String toString() {
        return "Nacional | " + super.toString();
    }
}
