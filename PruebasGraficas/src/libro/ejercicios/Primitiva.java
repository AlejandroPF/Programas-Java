package libro.ejercicios;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * EJERCICIO 04
 * 
 * @author Alejandro Peña Florentín
 * @version 1.0 02-abr-2014
 */
public class Primitiva extends JFrame implements ActionListener {

    private JTextField[] textos = new JTextField[6];
    private static JButton boton = new JButton("Generar");
    private static JLabel label = new JLabel("Complementario");
    private static JPanel panel = new JPanel();
    private static JPanel panel2 = new JPanel();

    public Primitiva() {
        setLayout(null);
        setDefaultCloseOperation(3);
        setVisible(true);
        colocaElementos();
        setSize(300, 300);
        setLocationRelativeTo(null);
        //setPreferredSize(new Dimension(500,500));
    }

    public void colocaElementos() {
        getContentPane().add(panel);
        int posX = 40, posY = 80, wid = 30, hei = 25;
        for (int i = 0; i < textos.length; i++) {
            textos[i] = new JTextField();
            textos[i].setBounds(posX, posY, wid, hei);
            add(textos[i], i);
            if (i == textos.length - 2) {
                posX += wid + 5;
            }else{
                posX += wid +1;
            }
        }
        label.setBounds(posX-(wid*2), (posY-hei-2),150, hei);
        add(label);
        boton.setBounds(65, 115, 150, 30);
        add(boton);

        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String mensaje = " selección: ";
                int[] numeros = new int[6];
                numeros = sacarValores();
                for (int i = 0; i < numeros.length; i++) {
                    textos[i].setText(String.valueOf(numeros[i]));
                }
            }
        });

    }

    public boolean inArray(int num, int[] array) {
        boolean loop = true;
        boolean output = false;
        int cont = 0;
        while (loop) {
            if (cont < array.length) {
                if (array[cont] == num) {
                    output = true;
                    loop = false;
                }
            } else {
                loop = false;
                output = false;
            }
            cont++;
        }
        return output;
    }

    public int[] sacarValores() {
        boolean loop = true;
        int[] numeros = new int[6];
        for (int i = 0; i < 6; i++) {
            int num;
            while (loop) {
                loop = true;
                num = (int) (Math.random() * 48 + 1);
                if (!inArray(num, numeros)) {
                    loop = false;
                    numeros[i] = num;
                }
            }
            loop = true;
        }

        return numeros;
    }

    public static void main(String[] args) {
        Primitiva p = new Primitiva();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
