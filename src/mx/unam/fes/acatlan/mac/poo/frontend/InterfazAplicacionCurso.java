package mx.unam.fes.acatlan.mac.poo.frontend;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import mx.unam.fes.acatlan.mac.poo.backend.Alumno;
import mx.unam.fes.acatlan.mac.poo.backend.AplicacionCursos;
import mx.unam.fes.acatlan.mac.poo.backend.Curso;
import mx.unam.fes.acatlan.mac.poo.backend.Profesor;

public class InterfazAplicacionCurso extends JFrame {
    private AplicacionCursos aplicacionCursos;

    /**
     * Panel con los datos del alumno
     */
    private PanelDatos panelDatos;

    /**
     * Panel con los datos del registro
     */
    private PanelRegistro panelRegistro;

    /**
     * Panel con los botones de navegación
     */
    private PanelNavegacion panelNavegacion;

    public InterfazAplicacionCurso( )
    {
        // Construye la forma
        setTitle("Aplicación Cursos");
        setSize(700,450);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout( new BorderLayout( ) );

        // Crea la instancia de clase contenedora de profesores, cursos y alumnos
        //al invocar al constructor se cargan los cursos, profesores y alumnos en los ArrayList
        aplicacionCursos = new AplicacionCursos();

        //Crear los paneles
        panelDatos= new PanelDatos();
        panelRegistro= new PanelRegistro(this);
        panelNavegacion= new PanelNavegacion(this);

        //Organizar el Panel Principal
        add(panelDatos,BorderLayout.NORTH);
        add(panelRegistro,BorderLayout.CENTER);
        add(panelNavegacion,BorderLayout.SOUTH);

        //invoca el metodo encargado de actualizar el panel de datos y se le
        //pasa como parametro el alumno actual, es decir el de la posicion cero
        mostrarInformacionAlumno(aplicacionCursos.getAlumnoActual());
    }

    /**
     * Método encargado de llenar los campos de los paneles con la informacion actual del alumno
     * @return alumno
     */
    public void mostrarInformacionAlumno(Alumno alu) {
        panelDatos.actualizarPanel(alu);
        panelRegistro.actualizarEtiquetas(alu);//reto: actualiza las etiquetas del curso y el tutor
    }

    /**
     * Método encargado de invocar el metodo que regresa al alumno siguiente
     * @return alumno
     */
    public void siguiente() {
        Alumno alumno=aplicacionCursos.getAlumnoSiguiente();
        mostrarInformacionAlumno(alumno);
    }

    /**
     * Método encargado de invocar el metodo que regresa al alumno anterior
     * @return alumno
     */
    public void anterior() {
        Alumno alumno=aplicacionCursos.getAlumnoAnterior();
        mostrarInformacionAlumno(alumno);
    }

    /**
     * Método encargado de registrar un curso
     */
    public void agregaCurso(Curso curso) {
        JOptionPane.showMessageDialog(this, "Se registrará el curso: "+curso.toString());
        aplicacionCursos.getAlumnoActual().registrarCurso(curso);
        mostrarInformacionAlumno(aplicacionCursos.getAlumnoActual());//reto: actualiza las etiquetas
    }

    /**
     * Método encargado de registrar un tutor
     */
    public void registrarTutor(Profesor prof) {
        JOptionPane.showMessageDialog(this, "Se registrará el tutor: "+prof.toString());
        aplicacionCursos.getAlumnoActual().agregarTutor(prof);
        mostrarInformacionAlumno(aplicacionCursos.getAlumnoActual());//reto: actualiza las etiquetas
    }

    /**
     * Método encargado de borrar un curso
     */
    public void borrarCurso() {
        aplicacionCursos.getAlumnoActual().eliminarCurso();
        mostrarInformacionAlumno(aplicacionCursos.getAlumnoActual());//reto: actualiza las etiquetas
    }

    /**
     * Método encargado de borrar un tutor
     */
    public void borrarTutor() {
        aplicacionCursos.getAlumnoActual().eliminarTutor();
        mostrarInformacionAlumno(aplicacionCursos.getAlumnoActual());//reto: actualiza las etiquetas
    }

    /**
     * Método encargado de recuperar el arraylist de cursos
     */
    public ArrayList<Curso> getCursos() {
        return aplicacionCursos.getCursos();
    }

    /**
     * Método encargado de recuperar el arraylist de tutores
     */
    public ArrayList<Profesor> getTutores() {
        return aplicacionCursos.getProfesores();
    }

    public static void main(String[] args) {
        InterfazAplicacionCurso interfaz=new InterfazAplicacionCurso();
        interfaz.setVisible(true);

    }

}
