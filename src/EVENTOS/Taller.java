package EVENTOS;

import java.time.LocalDate;
import java.util.List;

public class Taller extends Evento {
    private int numeroSesiones;
    private int numeroParticipantes;
    private Instructor instructor;
    private List<String> materiales;
    private double costoMateriales;
    private List<LocalDate> fechas;
    private String horario;

    public Taller(String clave, String nombre, String lugar, int capacidadMaxima,
                  double costoBase, int duracionHoras, int numeroSesiones,
                  int numeroParticipantes, Instructor instructor, List<String> materiales,
                  double costoMateriales, List<LocalDate> fechas, String horario) {
        super(clave, nombre, lugar, capacidadMaxima, costoBase, duracionHoras);
        if (numeroSesiones <= 0 || numeroParticipantes <= 0 || instructor == null ||
            materiales == null || materiales.isEmpty() ||
            fechas == null || fechas.isEmpty() ||
            horario == null || horario.trim().isEmpty())
            throw new IllegalArgumentException("El taller requiere sesiones, participantes, instructor, materiales, fechas y horario.");
        this.numeroSesiones = numeroSesiones;
        this.numeroParticipantes = numeroParticipantes;
        this.instructor = instructor;
        this.materiales = materiales;
        this.costoMateriales = costoMateriales;
        this.fechas = fechas;
        this.horario = horario;
    }

    @Override
    public double calcularCosto() {
        return costoBase + costoMateriales;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Número de sesiones: " + numeroSesiones);
        System.out.println("Número de participantes: " + numeroParticipantes);
        System.out.println("Instructor: " + instructor.getNombre());
        System.out.println("Materiales: " + String.join(", ", materiales));
        System.out.println("Costo de materiales: $" + String.format("%.2f", costoMateriales));
        System.out.println("Fechas: " + fechas);
        System.out.println("Horario: " + horario);
    }
}
