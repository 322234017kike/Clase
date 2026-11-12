package CLASES;

public class EnvioInternacional extends Envio {
    private static final double COSTO_BASE = 180;
    private static final double TARIFA_KG = 45;

    public EnvioInternacional(String numeroGuia, double peso) {
        super(numeroGuia, peso);
    }

    @Override
    public double calcularCosto() {
        return COSTO_BASE + (peso * TARIFA_KG);
    }

    @Override
    public String getTipo() {
        return "Internacional";
    }
}
