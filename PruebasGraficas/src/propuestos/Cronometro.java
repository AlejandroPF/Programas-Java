package propuestos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 *
 * @author Alejandro Peña Florentín
 * @version 1.0 08-abr-2014
 */
public class Cronometro extends JFrame implements ActionListener {

    private Runtime runtime = Runtime.getRuntime();
    private long memory;
    private long memoriaMax = runtime.maxMemory();
    private JLabel label = new JLabel();
    private JLabel lblmem = new JLabel();
    private JButton boton = new JButton("Parar");
    private String[] etapas = new String[10];
    private JLabel[] labelEtapas = new JLabel[11];
    private int lastEtapa = 0;
    private JButton etapa = new JButton("Etapa");
    private boolean encendido = true;
    int h = 0, m = 0, s = 0, ms = 0;
    Border blackline = BorderFactory.createLineBorder(Color.black, 1, true);

    public Cronometro() {
        Image icon = new ImageIcon(getClass().getResource("icon.png")).getImage();
        setIconImage(icon);
        setLayout(null);
        setLocation(400,10);
        setSize(350, 600);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(3);
        setTitle("Cronometro");
        colocaElementos();
        temporizador(encendido);
    }

    public void temporizador(boolean val) {
        TimerTask tt = new TimerTask() {
            public void run() {
                if (encendido) {
                    cambiaHora();
                }
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(tt, 0, 1);

    }

    public void colocaElementos() {
        label.setBounds(65, 20, 250, 50);
        label.setText("1");
        label.setFont(new Font("Helvetica", 0, 38));
        lblmem.setBounds(0, 0, 200, 10);
        lblmem.setFont(new Font("Helvetica", 0, 10));
        boton.setBounds(80, 80, 80, 50);
        boton.addActionListener(this);
        etapa.setBounds(200, 80, 80, 50);
        etapa.addActionListener(this);

        labelEtapas[0] = new JLabel("ETAPAS");
        labelEtapas[0].setBounds(140, 130, 100, 50);
        add(labelEtapas[0]);
        for (int i = 1; i < labelEtapas.length; i++) {
            labelEtapas[i] = new JLabel("");
            labelEtapas[i].setBounds(120, 130 + (30 * (i + 1)), 90, 15);
            labelEtapas[i].setBorder(blackline);
            add(labelEtapas[i]);
        }
        add(boton);
        add(etapa);
        add(label);
        add(lblmem);
    }

    public void cambiaHora() {
        String horas = "", minutos = "", segundos = "", milisegundos = "", txt;
        ms++;
        if (ms > 999) {
            ms = 0;
            s++;
        }
        if (s > 59) {
            m++;
            s=0;
        }
        if (m > 59) {
            m = 0;
            h++;
        }
        if (ms < 10) {
            milisegundos = "00" + ms;
        } else {
            if (s < 100) {
                milisegundos = "" + ms;
            } else {
                milisegundos = "" + ms;
            }
        }
        if (s < 10) {
            segundos = "0" + s;
        } else {
            segundos = "" + s;
        }
        if (m < 10) {
            minutos = "0" + m;
        } else {
            minutos = "" + m;
        }
        if (h < 10) {
            horas = "0" + h;
        } else {
            horas = "" + h;
        }
        memory = runtime.totalMemory() - runtime.freeMemory();
        txt = horas + ":" + minutos + ":" + segundos+":"+milisegundos;
        label.setText(txt);
        lblmem.setText(String.valueOf(memory) + "/" + String.valueOf(memoriaMax));
        System.out.println(txt);

    }

    public static void main(String[] args) {
        new Cronometro();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nombre = e.getActionCommand();
        if (nombre.compareTo(boton.getText()) == 0) {
            if (encendido) {
                encendido = false;
                boton.setText("Continuar");
            } else {
                encendido = true;
                boton.setText("Parar");
            }
        }
        if (nombre.compareTo(etapa.getText()) == 0) {
            if (lastEtapa == labelEtapas.length-1) {
                lastEtapa = 0;
            }
            lastEtapa++;
            labelEtapas[lastEtapa].setText(label.getText());
        }
    }
}
