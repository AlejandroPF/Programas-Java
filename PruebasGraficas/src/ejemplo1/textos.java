package ejemplo1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Alejandro Peña Florentín
 * @version 1.0 02-abr-2014
 */
public class textos extends JFrame {

    public textos() {
        setSize(450, 350);
        setLocation(100, 100);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(3);
        //--------------------
        // Lo declaramos final para poder acceder a el desde el evento del boton
        final JTextField texto = new JTextField();
        add(texto);
        texto.setBounds(10,10,100,25);
        
        //ahora agreguamos un boton para usar el JtextField
        JButton boton = new JButton("Salida");
        add(boton);
        boton.setBounds(10,50,100,25);
        
        boton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String a =texto.getText();
                texto.setText("Hola "+a);
            }
        });
    }

    public static void main(String[] args) {
        new textos();
    }

}
