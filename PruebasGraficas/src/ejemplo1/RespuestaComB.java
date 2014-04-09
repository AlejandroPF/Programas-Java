package ejemplo1;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 *
 * @author Alejandro Peña Florentín
 * @version 1.0 03-abr-2014
 */
public class RespuestaComB extends JFrame implements ItemListener {
    private JComboBox combo = new JComboBox();
    public RespuestaComB() {
        setLayout(null);
        setSize(300, 300);
        setLocationRelativeTo(null);
        colocarElementos();
        setVisible(true);
    }

    public void colocarElementos() {
        combo.addItem("Rojo");
        combo.addItem("Azul");
        combo.addItem("Blanco");
        combo.setBounds(10,10,80,30);
        combo.addItemListener(this);
        add(combo);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
            setTitle(combo.getSelectedItem().toString());
    }
    public static void main(String[] args) {
        new RespuestaComB();
    }
}
