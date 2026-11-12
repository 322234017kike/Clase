package mx.unam.fes.acatlan.mac.poo.frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import mx.unam.fes.acatlan.mac.poo.backend.Alumno;

public class PanelDatos extends JPanel {
    /**
     * atibutos
     */
    //etiqueta y zona de texto para el nombre
    private JLabel lbNombre;
    private JTextField txtNombre;

    //etiqueta y zona de texto para el apellido Paterno
    private JLabel lbPaterno;
    private JTextField txtPaterno;

    //etiqueta y zona de texto para el apellido Materno
    private JLabel lbMaterno;
    private JTextField txtMaterno;

    //etiqueta y zona de texto para fecha de nacimiento
    private JLabel lbFechaNac;
    private JTextField txtFechaNac;

    //etiqueta y zona de texto para el genero
    private JLabel lbGenero;
    private JTextField txtGenero;

    //etiqueta para mostrar la imagen
    private JLabel lbImagen;

    /**
     * Constructor del Panel
     */
    public PanelDatos(){
        setLayout( new BorderLayout());
        TitledBorder border=BorderFactory.createTitledBorder("Datos Alumno");
        border.setTitleColor(Color.BLUE);
        setBorder(border);

        //definición y creación de paneles para información del alumno y foto
        JPanel panelDatosAlumno=new JPanel();
        JPanel panelFotoAlumno=new JPanel();

        //agregar los paneles al panel de Datos
        add(panelDatosAlumno,BorderLayout.CENTER);
        add(panelFotoAlumno,BorderLayout.EAST);

        //Creacion de todas las etiquetas
        lbNombre = new JLabel("Nombre: ");
        lbPaterno = new JLabel("Apellido Paterno: ");
        lbMaterno = new JLabel("Apellido Materno: ");
        lbGenero = new JLabel("Sexo: " );
        lbFechaNac = new JLabel("Fecha de Nacimiento: ");

        //Creacion y configuracion de la zona de texto para el nombre
        txtNombre = new JTextField();
        txtNombre.setEditable(false);
        txtNombre.setBackground(Color.LIGHT_GRAY);
        txtNombre.setForeground(Color.BLUE);

        //Creacion y configuracion de la zona de texto para el apellido paterno
        txtPaterno = new JTextField();
        txtPaterno.setEditable(false);
        txtPaterno.setBackground(Color.LIGHT_GRAY);
        txtPaterno.setForeground(Color.BLUE);

        //Creacion y configuracion de la zona de texto para el apellido materno
        txtMaterno = new JTextField();
        txtMaterno.setEditable(false);
        txtMaterno.setBackground(Color.LIGHT_GRAY);
        txtMaterno.setForeground(Color.BLUE);

        //Creacion y configuracion de la zona de texto para el genero
        txtGenero = new JTextField();
        txtGenero.setEditable(false);
        txtGenero.setBackground(Color.LIGHT_GRAY);
        txtGenero.setForeground(Color.BLUE);

        //Creacion y configuracion de la zona de texto para la fecha de nacimiento
        txtFechaNac= new JTextField(10);
        txtFechaNac.setEditable(false);
        txtFechaNac.setBackground(Color.LIGHT_GRAY);
        txtFechaNac.setForeground(Color.BLUE);

        //distribuidor gráfico
        panelDatosAlumno.setLayout(new GridLayout(7,2));

        //se agregan las etiquetas y las cajas de texto al panelDatosAlumno
        panelDatosAlumno.add(lbNombre);
        panelDatosAlumno.add(txtNombre);
        panelDatosAlumno.add(lbPaterno);
        panelDatosAlumno.add(txtPaterno);
        panelDatosAlumno.add(lbMaterno);
        panelDatosAlumno.add(txtMaterno);
        panelDatosAlumno.add(lbGenero);
        panelDatosAlumno.add(txtGenero);
        panelDatosAlumno.add(lbFechaNac);
        panelDatosAlumno.add(txtFechaNac);

        //crea la etiqueta para mostrar la foto
        lbImagen = new JLabel("FOTO ALUMNO");
        //agrega al panel de foto la etiqueta
        panelFotoAlumno.add(lbImagen);
    }

    public void actualizarPanel(Alumno a) {
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");

        txtNombre.setText(a.getNombre());
        txtPaterno.setText(a.getApellidoP());
        txtMaterno.setText(a.getApellidoM());
        txtGenero.setText(a.getGenero().toString());
        txtFechaNac.setText(sdf.format(a.getFechaNac()));

        //se ajusta el tamano de la imagen para que siempre tenga el mismo tamaño en el panel
        ImageIcon imagenOriginal = new ImageIcon("fotos/"+a.getFoto());
        Image imagenAjustada = imagenOriginal.getImage().getScaledInstance(90,
                100, Image.SCALE_SMOOTH);
        lbImagen.setText("");
        lbImagen.setIcon(new ImageIcon(imagenAjustada));
    }
}
