package EVENTOS;

import java.time.LocalDate;
import java.time.LocalTime;

public class Conferencia extends Evento {
    private String ponente;
    private String institucion;
    private String disciplina;
    private LocalDate fecha;
    private LocalTime hora;

    public Conferencia(String clave, String nombre, String lugar, int capacidadMaxima,
                       double costoBase, int duracionHoras, String ponente,
                       String institucion, String disciplina, LocalDate fecha, LocalTime hora) {
        super(clave, nombre, lugar, capacidadMaxima, costoBase, duracionHoras);
        if (ponente == null || ponente.trim().isEmpty() ||
            institucion == null || institucion.trim().isEmpty() ||
            disciplina == null || disciplina.trim().isEmpty() ||
            fecha == null || hora == null)
            throw new IllegalArgumentException("La conferencia requiere ponente, institución, disciplina, fecha y hora.");
        this.ponente = ponente;
        this.institucion = institucion;
        this.disciplina = disciplina;
        this.fecha = fecha;
        this.hora = hora;
    }

    @Override
    public double calcularCosto() {
        return costoBase;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Ponente: " + ponente);
        System.out.println("Institución: " + institucion);
        System.out.println("Disciplina: " + disciplina);
        System.out.println("Fecha: " + fecha + " | Hora: " + hora);
    }
}
