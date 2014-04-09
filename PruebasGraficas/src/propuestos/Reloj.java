package propuestos;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Alejandro Peña Florentín
 * @version 1.0 08-abr-2014
 */
public class Reloj extends JFrame implements ActionListener {

    private JLabel label = new JLabel();
    private JButton boton = new JButton("Parar");
    private boolean encendido = true;

    public Reloj() {
        setLayout(null);
        setLocationRelativeTo(null);
        setSize(350, 200);
        setVisible(true);
        setDefaultCloseOperation(3);
        setTitle("Reloj");
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
        timer.scheduleAtFixedRate(tt, 0, 1000);

    }

    public void colocaElementos() {
        label.setBounds(95, 20, 150, 50);
        label.setText("1");
        label.setFont(new Font("Helvetica", 0, 38));

        boton.setBounds(125, 80, 100, 50);
        boton.addActionListener(this);
        add(boton);
        add(label);

    }

    public void cambiaHora() {
        Calendar calendario = new GregorianCalendar();
        String hora, minutos, segundos;
        hora = String.valueOf(calendario.get(Calendar.HOUR_OF_DAY));
        minutos = String.valueOf(calendario.get(Calendar.MINUTE));
        segundos = String.valueOf(calendario.get(Calendar.SECOND));
        if (hora.length() < 2) {
            hora = "0" + hora;
        }
        if (minutos.length() < 2) {
            minutos = "0" + minutos;
        }
        if (segundos.length() < 2) {
            segundos = "0" + segundos;
        }

        label.setText(hora + ":" + minutos + ":" + segundos);

    }

    public static void main(String[] args) {
        new Reloj();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nombre=e.getActionCommand();
        if(nombre.compareTo(boton.getText())==0){
            if (encendido) {
                encendido = false;
                boton.setText("Continuar");
            } else {
                encendido = true;
                boton.setText("Parar");
            }
        }
    }
}
