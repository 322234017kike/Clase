package CLASES;

public class EnvioExpres extends Envio {

    public EnvioExpres(String numeroGuia, double peso) {
        super(numeroGuia, peso);
    }

    @Override
    public double calcularCosto() {
        return 90 + (peso * 20);
    }

    @Override
    public String toString() {
        return "Expres | " + super.toString();
    }
}
