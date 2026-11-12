package CLASES;

public class EnvioNacional extends Envio {
    private static final double COSTO_BASE = 50;
    private static final double TARIFA_KG = 12;

    public EnvioNacional(String numeroGuia, double peso) {
        super(numeroGuia, peso);
    }

    @Override
    public double calcularCosto() {
        return COSTO_BASE + (peso * TARIFA_KG);
    }

    @Override
    public String getTipo() {
        return "Nacional";
    }
}
