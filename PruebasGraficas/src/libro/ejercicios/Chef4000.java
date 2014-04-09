package libro.ejercicios;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Alejandro Peña Florentín
 * @version 1.0 03-abr-2014
 */
public class Chef4000 extends JFrame implements ActionListener {

    private JRadioButton[] radios = new JRadioButton[3];
    private JCheckBox[] checks = new JCheckBox[12];
    private ButtonGroup grupobotones;
    private JPanel panel = new JPanel();
    private JPanel panel2 = new JPanel();
    private JButton boton = new JButton("Comprobar");
    private JLabel label = new JLabel("Pulsa comprobar");

    public Chef4000() {
        setLayout(null);
        setDefaultCloseOperation(3);
        setVisible(true);
        setTitle("Chef 4000");
        setSize(500, 500);
        setLocationRelativeTo(null);

        panel.setLayout(new GridLayout(1, 3));
        panel2.setLayout(new GridLayout(3, 4));
        colocarElementos();

    }

    public void colocarElementos() {
        radios[0] = new JRadioButton("Cocido");
        radios[1] = new JRadioButton("Lentejas");
        radios[2] = new JRadioButton("Judias");
        grupobotones = new ButtonGroup();
        grupobotones.add(radios[0]);
        grupobotones.add(radios[1]);
        grupobotones.add(radios[2]);

        checks[0] = new JCheckBox("Lentejas");
        checks[1] = new JCheckBox("Chorizo");
        checks[2] = new JCheckBox("Cebolla");
        checks[3] = new JCheckBox("Garbanzos");
        checks[4] = new JCheckBox("Morcilla");
        checks[5] = new JCheckBox("Zanahoria");
        checks[6] = new JCheckBox("Judias");
        checks[7] = new JCheckBox("Colorante");
        checks[8] = new JCheckBox("Pescado");
        checks[9] = new JCheckBox("Nuez Moscada");
        checks[10] = new JCheckBox("Laurel");
        checks[11] = new JCheckBox("Pimentón");
        int posX = 40, posY = 20, wid = 100, hei = 25, sp = 50;
        for (int i = 0; i < radios.length; i++) {
            JRadioButton jRadioButton = radios[i];
            jRadioButton.setBounds(posX, posY, wid, hei);
            add(jRadioButton);
            posX += wid + sp;

        }
        posX = 40;
        posY = 55;
        sp = 0;
        for (int i = 0; i < checks.length; i++) {
            if (i % 4 == 0 && i != 0) {
                posX = 40;
                posY += hei;
            }
            JCheckBox j = checks[i];
            j.setBounds(posX, posY, wid, hei);
            add(j);
            posX += wid + sp;
        }
        boton.setBounds(150, posY + (hei * 2), 150, 50);
        // boton.add
        label.setBounds(150, posY + (hei * 2) + 50, 150, 50);
        boton.addActionListener(this);
        add(boton);
        add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (radios[0].isSelected()) {
            if (checks[1].isSelected() && checks[3].isSelected() && checks[4].isSelected() && checks[5].isSelected()) {
                label.setText("Correcto");
            } else {
                label.setText("NO");
            }
        }
        if (radios[1].isSelected()) {
            if (checks[0].isSelected() && checks[1].isSelected() && checks[2].isSelected() && checks[5].isSelected() && checks[11].isSelected()) {
                label.setText("Correcto");
            } else {
                label.setText("NO");
            }
        }
        if (radios[2].isSelected()) {
            if (checks[6].isSelected() && checks[9].isSelected() && checks[10].isSelected() && checks[7].isSelected() && checks[1].isSelected() && checks[2].isSelected()) {
                label.setText("Correcto");
            } else {
                label.setText("NO");
            }
        }
    }

    public static void main(String[] args) {
        new Chef4000();
    }

}
