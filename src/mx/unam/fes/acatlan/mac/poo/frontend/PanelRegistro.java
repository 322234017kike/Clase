package mx.unam.fes.acatlan.mac.poo.frontend;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import mx.unam.fes.acatlan.mac.poo.backend.Alumno;
import mx.unam.fes.acatlan.mac.poo.backend.Curso;
import mx.unam.fes.acatlan.mac.poo.backend.Profesor;

public class PanelRegistro extends JPanel implements ActionListener{
    /**
     * constantes para los botones
     *
     */
    //Constante para el evento del boton btnRegistrarCurso
    private final static String REGISTRAR_CURSO="REGISTRAR CURSO";
    //Constante para el evento del boton btnEliminarCurso
    private final static String ELIMINAR_CURSO="ELIMINAR CURSO";
    //Constante para el evento del boton btnRegistrarTutor
    private final static String REGISTRAR_TUTOR="REGISTRAR TUTOR";
    //Constante para el evento del boton btnEliminarTutor
    private final static String ELIMINAR_TUTOR="ELIMINAR TUTOR";

    /**
     * atibutos
     */
    //etiqueta y lista desplegable para el curso
    private JLabel lbCurso;
    private JComboBox<Curso> cbCurso;

    //etiqueta y lista desplegable para el tutor
    private JLabel lbTutor;
    private JComboBox<Profesor> cbTutor;

    //botones
    private JButton btnRegistrarCurso;
    private JButton btnEliminarCurso;
    private JButton btnRegistrarTutor;
    private JButton btnEliminarTutor;

    //etiquetas con el curso y el tutor del alumno actual (reto)
    private JLabel lbCursoAlumno;
    private JLabel lbTutorAlumno;

    //Instancia de la ventana principal
    private InterfazAplicacionCurso ventanaPrincipal;

    /**
     * Constructor del Panel
     */
    public PanelRegistro(InterfazAplicacionCurso ventanaPrincipal){
        this.ventanaPrincipal=ventanaPrincipal;

        setLayout(null);
        TitledBorder border=BorderFactory.createTitledBorder("Registro a Cursos");
        border.setTitleColor(Color.BLUE);
        setBorder(border);

        //Creacion de todas las etiquetas
        lbCurso = new JLabel("Curso: ");
        lbTutor = new JLabel("Tutor: ");

        //etiquetas con el curso y el tutor del alumno, en blanco si no tiene (reto)
        lbCursoAlumno = new JLabel("");
        lbTutorAlumno = new JLabel("");

        //Creación listas desplegables
        cbCurso=new JComboBox();
        cbCurso.setModel(new DefaultComboBoxModel(ventanaPrincipal.getCursos().toArray()));
        /*cbCurso.addItem("CURSO 1");
        cbCurso.addItem("CURSO 2");
        cbCurso.addItem("CURSO 3");
        cbCurso.addItem("CURSO 4");*/

        cbTutor=new JComboBox();
        cbTutor.setModel(new DefaultComboBoxModel(ventanaPrincipal.getTutores().toArray()));
       /*  cbTutor.addItem("TUTOR 1");
        cbTutor.addItem("TUTOR 2");
        cbTutor.addItem("TUTOR 3");*/

        //creación de botones
        btnRegistrarCurso = new JButton("Registrar Curso");
        btnRegistrarCurso.setActionCommand(REGISTRAR_CURSO);
        btnRegistrarCurso.addActionListener(this);//se indica que este panel sera el encargado de atender el evento

        btnEliminarCurso = new JButton("Eliminar Curso");
        btnEliminarCurso.setActionCommand(ELIMINAR_CURSO);
        btnEliminarCurso.addActionListener(this);//se indica que este panel sera el encargado de atender el evento

        btnRegistrarTutor = new JButton("Registrar Tutor");
        btnRegistrarTutor.setActionCommand(REGISTRAR_TUTOR);
        btnRegistrarTutor.addActionListener(this);//se indica que este panel sera el encargado de atender el evento

        btnEliminarTutor = new JButton("Eliminar Tutor");
        btnEliminarTutor.setActionCommand(ELIMINAR_TUTOR);
        btnEliminarTutor.addActionListener(this);//se indica que este panel sera el encargado de atender el evento

        //posiciones para cada objeto etiqueta, lista despelgable y botones
        lbCurso.setBounds(5,50,50,20);
        cbCurso.setBounds(60,50,200,20);
        lbTutor.setBounds(5,100,50,20);
        cbTutor.setBounds(60,100,200,20);

        //posiciones de las etiquetas con el curso y el tutor del alumno (reto)
        lbCursoAlumno.setBounds(280,50,380,20);
        lbTutorAlumno.setBounds(280,100,380,20);

        btnRegistrarCurso.setBounds(10,150,140,20);
        btnEliminarCurso.setBounds(160,150,140,20);
        btnRegistrarTutor.setBounds(310,150,140,20);
        btnEliminarTutor.setBounds(460,150,140,20);

        //se agregan las etiquetas y las listas desplegables al panel
        add(lbCurso);
        add(cbCurso);
        add(lbTutor);
        add(cbTutor);
        add(lbCursoAlumno);
        add(lbTutorAlumno);
        add(btnRegistrarCurso);
        add(btnEliminarCurso);
        add(btnRegistrarTutor);
        add(btnEliminarTutor);
    }

    /**
     * Muestra el curso y el tutor del alumno en las etiquetas, en blanco si no tiene (reto)
     */
    public void actualizarEtiquetas(Alumno alumno) {
        if(alumno.getCurso()!=null) {
            lbCursoAlumno.setText(alumno.getCurso().toString());
        }else {
            lbCursoAlumno.setText("");
        }

        if(alumno.getProfesor()!=null) {
            lbTutorAlumno.setText(alumno.getProfesor().toString());
        }else {
            lbTutorAlumno.setText("");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nombreEvento=e.getActionCommand();//se recupera el nombre del evento que se asigno al boton

        if(nombreEvento.equals(REGISTRAR_CURSO)) {
            //se recupera el objeto curso seleccionado
            Curso c=(Curso) cbCurso.getSelectedItem();
            ventanaPrincipal.agregaCurso(c);
        }else if(nombreEvento.equals(ELIMINAR_CURSO)) {
            ventanaPrincipal.borrarCurso();
        }else if(nombreEvento.equals(REGISTRAR_TUTOR)) {
            //se recupera el objeto tutor seleccionado
            Profesor p=(Profesor)cbTutor.getSelectedItem();
            ventanaPrincipal.registrarTutor(p);
        }else if(nombreEvento.equals(ELIMINAR_TUTOR)) {
            ventanaPrincipal.borrarTutor();
        }
    }
}
