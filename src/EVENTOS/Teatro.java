package EVENTOS;

import java.time.LocalDate;
import java.util.List;

public class Teatro extends Evento {

    /** Zona del asiento y la cantidad que se suma al costo base. */
    public enum Zona {
        GENERAL(0),
        PREFERENTE(50),
        VIP(100);

        private final double cargo;

        Zona(double cargo) {
            this.cargo = cargo;
        }
    }

    private int totalActores;
    private String tipoObra;
    private List<LocalDate> fechas;
    private String horario;
    private Zona zona;

    public Teatro(String clave, String nombre, String lugar, int capacidadMaxima,
                  double costoBase, int duracionHoras, int totalActores, String tipoObra,
                  List<LocalDate> fechas, String horario, Zona zona) {
        super(clave, nombre, lugar, capacidadMaxima, costoBase, duracionHoras);
        if (totalActores <= 0 || tipoObra == null || tipoObra.trim().isEmpty() ||
            fechas == null || fechas.isEmpty() ||
            horario == null || horario.trim().isEmpty() || zona == null)
            throw new IllegalArgumentException("La obra requiere actores, tipo de obra, fechas, horario y zona.");
        this.totalActores = totalActores;
        this.tipoObra = tipoObra;
        this.fechas = fechas;
        this.horario = horario;
        this.zona = zona;
    }

    @Override
    public double calcularCosto() {
        return costoBase + zona.cargo;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Total de actores: " + totalActores);
        System.out.println("Tipo de obra: " + tipoObra);
        System.out.println("Fechas: " + fechas);
        System.out.println("Horario: " + horario);
        System.out.println("Zona: " + zona + " (+$" + String.format("%.2f", zona.cargo) + ")");
    }
}
