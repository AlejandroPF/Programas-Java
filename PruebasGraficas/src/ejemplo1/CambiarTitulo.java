package ejemplo1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Alejandro Peña Florentín
 * @version 1.0 03-abr-2014
 */
public class CambiarTitulo extends JFrame implements ActionListener {

    private static JLabel label = new JLabel("Pon el titulo a la ventana: ");
    private static JTextField texto = new JTextField("Nuevo Titulo");
    private static JButton boton = new JButton("Cambiar");

    public CambiarTitulo() {
        setLayout(null);
        setDefaultCloseOperation(3);
        setVisible(true);
        setSize(300, 300);
        setLocationRelativeTo(null);
        colocarElementos();
    }

    public void colocarElementos() {
        label.setBounds(40, 30, 180, 25);
        texto.setBounds(40, 60, 180, 25);
        boton.setBounds(80, 90, 100, 25);
        boton.addActionListener(this);
        add(label);
        add(texto);
        add(boton);

    }

    public static void main(String[] args) {
        new CambiarTitulo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setTitle(texto.getText());
    }
}
