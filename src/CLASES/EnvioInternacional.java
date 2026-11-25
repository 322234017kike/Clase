package CLASES;

public class EnvioInternacional extends Envio {

    public EnvioInternacional(String numeroGuia, double peso) {
        super(numeroGuia, peso);
    }

    @Override
    public double calcularCosto() {
        return 180 + (peso * 45);
    }

    @Override
    public String toString() {
        return "Internacional | " + super.toString();
    }
}
