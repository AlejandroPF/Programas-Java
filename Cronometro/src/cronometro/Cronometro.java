package cronometro;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Alejandro Peña Florentín
 * @version 1.0 08-abr-2014
 */
public class Cronometro extends JFrame implements ActionListener {

    private JLabel label = new JLabel();
    private JButton boton = new JButton("Parar");
    private boolean encendido = true;
    int h=0,m=0,s=0;
    public Cronometro() {
        Image icon = new ImageIcon(getClass().getResource("icon.png")).getImage();
        setIconImage(icon);
        setLayout(null);
        setLocationRelativeTo(null);
        setSize(350, 200);
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
        String horas="", minutos="", segundos="",txt;
        s++;
        if(s>59){
            s=0;
            m++;
        }
        if(m>59){
            m=0;
            h++;
        }
        if(s<10){
            segundos="0"+s;
        }else {
            segundos=""+s;
        }
        if(m<10){
            minutos="0"+m;
        }else{
            minutos=""+m;
        }
        if(h<10){
            horas="0"+h;
        }else{
            horas=""+h;
        }
        txt=horas + ":" + minutos + ":" + segundos;
        label.setText(txt);
        System.out.println(txt);
        

    }

    public static void main(String[] args) {
        new Cronometro();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (encendido) {
            encendido = false;
            boton.setText("Continuar");
        } else {
            encendido = true;
            boton.setText("Parar");
        }
    }
}
