package ejemplo1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Alejandro Peña Florentín
 * @version 1.0 09-abr-2014
 */
public class Prueba extends JFrame {

    private static JLabel label = new JLabel();
    private static JButton botonReiniciar = new JButton("Reiniciar");
    private static JButton botonCien = new JButton("100");
    private static JButton botonDoscientos = new JButton("200");
    private static int vida = 300;
    private static int val;
    private static int vidaMax = 300;
    private static JPanel panel = new JPanel();

    public Prueba() throws InterruptedException {
        setLayout(null);
        setDefaultCloseOperation(3);
        setVisible(true);
        setResizable(false);
        setTitle("Vida");
        setSize(500, 500);
        setLocationRelativeTo(null);
        colocaElementos();
    }

    public void colocaElementos() {
        panel.setBounds(100, 100, 300, 50);
        panel.setBackground(Color.green);
        label.setBounds(100, 50, 300, 50);
        label.setText(String.valueOf(vida));
        botonReiniciar.setBounds(195, 180, 100, 50);
        botonCien.setBounds(160, 235, 80, 30);
        botonCien.addActionListener(new BajarCien());
        botonDoscientos.setBounds(245, 235, 80, 30);
        botonDoscientos.addActionListener(new BajarDoscientos());
        botonReiniciar.addActionListener(new Reiniciar());
        add(botonReiniciar);
        add(botonCien);
        add(botonDoscientos);
        add(label);
        add(panel);
    }

    public static class Reiniciar implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            System.out.println("Reiniciando");
            val = 0;
            vida = vidaMax;
            label.setText(""+vidaMax);
            panel.setBounds(100, 100, vidaMax, 50);
            
        }
    }
    public static class BajarCien implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            System.out.println("Bajando 100");
            val = vida-100;
            new Thread(new Hilo()).start();
        }
    }
    public static class BajarDoscientos implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            System.out.println("Bajando 200");
            val = vida-200;
            new Thread(new Hilo()).start();
        }
    }

    public static class Hilo implements Runnable {

        public void run() {
            for (int i = vida; i >= val; i--) {
                
                double porcentaje = ((double)i / (double)vidaMax) * 100;
                panel.setBounds(100, 100, i, 50);
                label.setText("" + i);
                if (porcentaje > 50) {
                    panel.setBackground(Color.green);
                } else if (porcentaje > 25) {
                    panel.setBackground(Color.yellow);
                } else {
                    panel.setBackground(Color.red);
                }
                try {
                    Thread.sleep(20);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            vida=val;
            System.out.println(""+vida);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Prueba();
    }

}
