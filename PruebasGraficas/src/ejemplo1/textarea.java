package ejemplo1;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Alejandro Peña Florentín
 * @version 1.0 02-abr-2014
 */
public class textarea extends JFrame {

    public textarea() {
        setSize(450, 350);
        setLocation(100, 100);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(3);
        //--------------------

        JTextArea area = new JTextArea();
        add(area);
        area.setBounds(10, 10, 220, 200);

        /**
         * Hacemos un JScrollPane para poner el textarea en el y asi si el texto
         * es muy grande podemos mover el area visible y leer todo el texto
         */
        JScrollPane ajustar = new JScrollPane(area);
        add(ajustar);
        ajustar.setBounds(10,10,220,200);
    }   
   

    public static void main(String[] args) {
        textarea lb = new textarea();

    }

}
