package CLASES;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MainEnvios {

    public static void main(String[] args) {
        // Lista con los envios de la solicitud del cliente
        ArrayList<Envio> envios = new ArrayList<>();

        envios.add(new EnvioNacional(pedirGuia("nacional"), pedirPeso("nacional")));
        envios.add(new EnvioInternacional(pedirGuia("internacional"), pedirPeso("internacional")));
        envios.add(new EnvioExpres(pedirGuia("expres"), pedirPeso("expres")));

        String resumen = "";
        double total = 0;

        // Polimorfismo: cada envio calcula su costo segun su tipo
        for (Envio e : envios) {
            double costo = e.calcularCosto();
            total += costo;
            resumen += e + " | Costo: $" + String.format("%.2f", costo) + "\n";
        }

        resumen += "\nCosto total: $" + String.format("%.2f", total);
        JOptionPane.showMessageDialog(null, resumen, "Resumen de envios",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private static String pedirGuia(String tipo) {
        return JOptionPane.showInputDialog("Numero de guia del envio " + tipo + ":");
    }

    private static double pedirPeso(String tipo) {
        return Double.parseDouble(JOptionPane.showInputDialog("Peso del envio " + tipo + " (kg):"));
    }
}
