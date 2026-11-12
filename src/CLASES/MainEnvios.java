package CLASES;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MainEnvios {

    public static void main(String[] args) {
        // Lista con los envios de una solicitud de un cliente
        List<Envio> envios = new ArrayList<>();

        String cliente = JOptionPane.showInputDialog(null, "Nombre del cliente:",
                "Envios", JOptionPane.QUESTION_MESSAGE);
        if (cliente == null || cliente.trim().isEmpty()) {
            cliente = "Cliente";
        }

        String[] opciones = {"Nacional", "Internacional", "Expres"};
        boolean otro = true;

        while (otro) {
            int tipo = JOptionPane.showOptionDialog(null, "Tipo de envio:", "Nuevo envio",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, opciones, opciones[0]);
            if (tipo == JOptionPane.CLOSED_OPTION) {
                break;
            }

            String guia = JOptionPane.showInputDialog(null, "Numero de guia:",
                    "Nuevo envio", JOptionPane.QUESTION_MESSAGE);
            if (guia == null || guia.trim().isEmpty()) {
                break;
            }

            double peso = leerPeso();
            if (peso < 0) {
                break;
            }

            switch (tipo) {
                case 0:
                    envios.add(new EnvioNacional(guia, peso));
                    break;
                case 1:
                    envios.add(new EnvioInternacional(guia, peso));
                    break;
                default:
                    envios.add(new EnvioExpres(guia, peso));
                    break;
            }

            int resp = JOptionPane.showConfirmDialog(null, "Envio registrado. Agregar otro?",
                    "Envios", JOptionPane.YES_NO_OPTION);
            otro = (resp == JOptionPane.YES_OPTION);
        }

        if (envios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se registraron envios.");
            return;
        }

        StringBuilder sb = new StringBuilder("Cliente: " + cliente + "\n\n");
        double total = 0;
        for (Envio e : envios) {
            sb.append(e).append("\n"); // polimorfismo: cada envio calcula su costo
            total += e.calcularCosto();
        }
        sb.append("\nCosto total: $").append(String.format("%.2f", total));

        JOptionPane.showMessageDialog(null, sb.toString(), "Resumen de envios",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /** Pide el peso hasta que sea valido (> 0). Devuelve -1 si el usuario cancela. */
    private static double leerPeso() {
        while (true) {
            String s = JOptionPane.showInputDialog(null, "Peso del paquete (kg):",
                    "Nuevo envio", JOptionPane.QUESTION_MESSAGE);
            if (s == null) {
                return -1;
            }
            try {
                double peso = Double.parseDouble(s.trim());
                if (peso > 0) {
                    return peso;
                }
            } catch (NumberFormatException ex) {
                // se vuelve a pedir
            }
            JOptionPane.showMessageDialog(null, "Ingresa un peso valido mayor a 0.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
