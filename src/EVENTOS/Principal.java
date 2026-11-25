package EVENTOS;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Principal {
    static Registro<Evento> eventos = new Registro<>();
    static Registro<Participante> participantes = new Registro<>();
    static Registro<Espacio> espacios = new Registro<>();
    static Registro<Instructor> instructores = new Registro<>();
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        cargarDatosIniciales();
        int opcion;
        do {
            System.out.println("\n===== EVENTOS CULTURALES =====");
            System.out.println("1. Mostrar eventos");
            System.out.println("2. Buscar eventos");
            System.out.println("3. Reporte por categoría");
            System.out.println("4. Eliminar evento");
            System.out.println("5. Mostrar participantes");
            System.out.println("6. Mostrar espacios");
            System.out.println("7. Mostrar instructores");
            System.out.println("8. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine();
            switch (opcion) {
                case 1:
                    mostrarEventos();
                    break;
                case 2:
                    buscarVariosEventos();
                    break;
                case 3:
                    reporteCategorias();
                    break;
                case 4:
                    eliminarEvento();
                    break;
                case 5:
                    mostrarParticipantes();
                    break;
                case 6:
                    mostrarEspacios();
                    break;
                case 7:
                    mostrarInstructores();
                    break;
                case 8:
                    System.out.println("Fin del programa.");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        } while (opcion != 8);
    }

    public static void cargarDatosIniciales() {
        Instructor i1 = new Instructor("I01", "Laura Mendoza");
        Instructor i2 = new Instructor("I02", "Carlos Ríos");
        instructores.agregar(i1);
        instructores.agregar(i2);

        espacios.agregar(new Espacio("E01", "Auditorio Principal"));
        espacios.agregar(new Espacio("E02", "Sala de Talleres 1"));
        espacios.agregar(new Espacio("E03", "Teatro Universitario"));

        participantes.agregar(new Participante("P01", "Ana López"));
        participantes.agregar(new Participante("P02", "Luis Hernández"));
        participantes.agregar(new Participante("P03", "María Torres"));

        eventos.agregar(new Conferencia("C01", "Inteligencia artificial y sociedad", "Auditorio Principal",
                200, 50, 2, "Dr. Jorge Salas", "UNAM", "Computación",
                LocalDate.of(2026, 12, 3), LocalTime.of(11, 0)));

        eventos.agregar(new Conferencia("C02", "Literatura mexicana contemporánea", "Auditorio Principal",
                150, 0, 1, "Dra. Elena Ruiz", "El Colegio de México", "Literatura",
                LocalDate.of(2026, 12, 10), LocalTime.of(17, 0)));

        eventos.agregar(new Taller("T01", "Taller de acuarela", "Sala de Talleres 1",
                25, 300, 3, 3, 20, i1,Arrays.asList("Acuarelas", "Pinceles", "Papel"), 200,
                Arrays.asList(LocalDate.of(2026, 12, 1), LocalDate.of(2026, 12, 8), LocalDate.of(2026, 12, 15)),
                "16:00 - 19:00"));

        eventos.agregar(new Taller("T02", "Taller de fotografía", "Sala de Talleres 1",
                20, 400, 4, 2, 15, i2,Arrays.asList("Cámara", "Trípode"), 150,
                Arrays.asList(LocalDate.of(2026, 12, 5), LocalDate.of(2026, 12, 12)),
                "10:00 - 14:00"));

        eventos.agregar(new Teatro("O01", "Romeo y Julieta", "Teatro Universitario",
                250, 120, 2, 12, "Tragedia",
                Arrays.asList(LocalDate.of(2026, 12, 18), LocalDate.of(2026, 12, 19)),
                "19:00", Teatro.Zona.PREFERENTE));
    }

    public static void mostrarEventos() {
        System.out.println("\n--- MOSTRAR EVENTOS ---");
        for (Evento evento : eventos.obtenerTodos()) {
            evento.mostrarInformacion();
        }
        System.out.println("\nTotal de eventos: "
                + eventos.obtenerCantidad());
    }

    public static void buscarEvento() {
        System.out.print("Clave del evento: ");
        String id = entrada.nextLine();
        Evento encontrado = eventos.buscar(id);
        if (encontrado != null) {
            encontrado.mostrarInformacion();
        } else {
            System.out.println("No se encontró el evento.");
        }
    }

    public static void buscarVariosEventos() {
        System.out.println("Escribe las clave de los eventos separados por comas:");
        String linea = entrada.nextLine();
        String[] ids = linea.split(",");
        // Se eliminan espacios al inicio y al final de cada ID
        for (int i = 0; i < ids.length; i++) {
            ids[i] = ids[i].trim();
        }
        List<Evento> encontrados = eventos.buscarVarios(ids);
        System.out.println("\n--- RESULTADOS DE LA BÚSQUEDA ---");
        if (encontrados.isEmpty()) {
            System.out.println("No se encontraron eventos.");
        } else {
            for (Evento evento : encontrados) {
                evento.mostrarInformacion();
            }
        }
        System.out.println("Coincidencias: " + encontrados.size());
    }

    public static void reporteCategorias() {
        int conferencias = 0;
        int talleres = 0;
        int obras = 0;
        for (Evento evento : eventos.obtenerTodos()) {
            if (evento instanceof Conferencia) {
                conferencias++;
            } else if (evento instanceof Taller) {
                talleres++;
            } else if (evento instanceof Teatro) {
                obras++;
            }
        }
        System.out.println("\n--- REPORTE POR CATEGORÍA ---");
        System.out.println("Conferencias: " + conferencias);
        System.out.println("Talleres: " + talleres);
        System.out.println("Obras de teatro: " + obras);
        System.out.println("Total: " + eventos.obtenerCantidad());
    }

    public static void eliminarEvento() {
        System.out.print("Clave del evento que desea eliminar: ");
        String id = entrada.nextLine();
        if (eventos.eliminar(id)) {
            System.out.println("Evento eliminado correctamente.");
        } else {
            System.out.println("No existe un evento con esa Clave.");
        }
    }

    public static void mostrarParticipantes() {
        System.out.println("\n--- PARTICIPANTES ---");
        for (Participante p : participantes.obtenerTodos()) {
            p.mostrarInformacion();
            System.out.println("----------------");
        }
    }

    public static void mostrarEspacios() {
        System.out.println("\n--- ESPACIOS ---");
        for (Espacio e : espacios.obtenerTodos()) {
            e.mostrarInformacion();
            System.out.println("----------------");
        }
    }

    public static void mostrarInstructores() {
        System.out.println("\n--- INSTRUCTORES ---");
        for (Instructor i : instructores.obtenerTodos()) {
            i.mostrarInformacion();
            System.out.println("----------------");
        }
    }
}
