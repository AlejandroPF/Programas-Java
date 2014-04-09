package ejemplo1;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Alejandro Peña Florentín
 * @version 1.0 02-abr-2014
 */
public class labels extends JFrame {

    public void label() {
        setSize(450, 350);
        setLocation(100, 100);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(3);
        //--------------------

        JLabel label1 = new JLabel("Hola!!"); //hacemos el label
        add(label1); // lo agregamos al frame
        label1.setBounds(10, 10, 100, 25); //colocamos coordenadas
        //pos x, pos y, ancho, largo

        JLabel label2 = new JLabel(); //label con imagen
        label2.setIcon(new ImageIcon(getClass().getResource("calabaza.jpg")));
        add(label2);
        label2.setBounds(10, 35, 200, 200);

        //si queremos la imagen ajustada a un tamaño especial
        ImageIcon icono = new ImageIcon(getClass().getResource("manzana.jpg"));
        Image imagen = icono.getImage();
        ImageIcon aescala = new ImageIcon(
                imagen.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        JLabel label3 = new JLabel(aescala);
        add(label3);
        label3.setBounds(250, 25, 100, 100);
    }

    public static void main(String[] args) {
        labels lb = new labels();
        lb.label();
    }

}
