package CLASES;

public class EnvioExpres extends Envio {
    private static final double COSTO_BASE = 90;
    private static final double TARIFA_KG = 20;

    public EnvioExpres(String numeroGuia, double peso) {
        super(numeroGuia, peso);
    }

    @Override
    public double calcularCosto() {
        return COSTO_BASE + (peso * TARIFA_KG);
    }

    @Override
    public String getTipo() {
        return "Expres";
    }
}
