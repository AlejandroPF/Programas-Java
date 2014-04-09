package ejemplo1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Alejandro Peña Florentín
 * @version 1.0 01-abr-2014
 */
public class Ventana extends JFrame implements ActionListener {

    JPanel panelContenedor;
    JLabel etiqueta;
    JButton boton;
    public Ventana() {
        this.setVisible(true);
        this.setSize(400, 400);
        this.setLocation(300, 300);
        this.setTitle("MI VENTANA");
        panelContenedor = (JPanel) this.getContentPane();
        etiqueta = new JLabel("Hola Mundo");
        panelContenedor.setLayout(null);
        boton= new JButton("ACEPTAR");
        boton.setBounds(25,75,100,50);
        etiqueta.setBounds(25,15,75,80);
        panelContenedor.add(boton);
        panelContenedor.add(etiqueta);
        this.setDefaultCloseOperation(3);
        boton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Se ha pulsado el botón");
        System.exit(0);
    }
    
}
