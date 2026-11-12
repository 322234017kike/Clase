package mx.unam.fes.acatlan.mac.poo.frontend;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelNavegacion extends JPanel implements ActionListener{
    /**
     * constantes para los botones
     *
     */
    //Constante para el evento del boton btnAnterior
    private final static String ANTERIOR="ANTERIOR";
    //Constante para el evento del boton btnSiguiente
    private final static String SIGUIENTE="SIGUIENTE";

    /**
     * atibutos
     */
    //botones
    private JButton btnSiguiente;
    private JButton btnAnterior;

    //Instancia de la ventana principal
    private InterfazAplicacionCurso ventanaPrincipal;

    /**
     * Constructor del Panel
     */
    public PanelNavegacion(InterfazAplicacionCurso ventanaPrincipal){
        this.ventanaPrincipal=ventanaPrincipal;

        setLayout(new FlowLayout( ));
        TitledBorder border=BorderFactory.createTitledBorder("Navegación");
        border.setTitleColor(Color.BLUE);
        setBorder(border);

        //creación de botones
        btnSiguiente = new JButton(">");
        btnSiguiente.setActionCommand(SIGUIENTE);
        btnSiguiente.addActionListener(this);//se indica que este panel sera el encargado de atender el evento

        btnAnterior = new JButton("<");
        btnAnterior.setActionCommand(ANTERIOR);
        btnAnterior.addActionListener(this);//se indica que este panel sera el encargado de atender el evento


        //se agregan los botones
        add(btnAnterior);
        add(btnSiguiente);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nombreEvento=e.getActionCommand();//se recupera el nombre del evento que se asigno al boton

        if(nombreEvento.equals(SIGUIENTE)) {
            ventanaPrincipal.siguiente();
        }else if(nombreEvento.equals(ANTERIOR)) {
            ventanaPrincipal.anterior();
        }
    }
}
