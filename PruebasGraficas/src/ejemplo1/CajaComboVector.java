
package ejemplo1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro Peña Florentín
 * @version 1.0 02-abr-2014
 */
public class CajaComboVector extends JFrame implements ItemListener, ActionListener{
    private JComboBox[] combos;
    private static JButton boton1 = new JButton("Comprobar");
    public void ColocarElementos(){
        setLayout(null);
        combos = new JComboBox[3];
        // respuestas = new JTextField[10]
        for (int i = 0; i < combos.length; i++) {
            combos[i]= new JComboBox();
            combos[i].setBounds(20,(i+1)*30,80,20);
            add(combos[i]);
            combos[i].addItem("Rojo");
            combos[i].addItem("Verde");
            combos[i].addItem("Azul");
            //combos[i].addItemListener(this);
            combos[i].addActionListener(this);
        }
        boton1.setBounds(30,150,150,30);
        add(boton1);
        boton1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String mensaje = " selección: ";
                for (int i = 0; i < combos.length; i++) {
                    mensaje+=combos[i].getSelectedItem()+" - ";
                }
                JOptionPane.showMessageDialog(rootPane, mensaje);
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void itemStateChanged(ItemEvent e) {
        for (int i = 0; i < combos.length; i++) {
            if(e.getSource() == combos[i]){
                JOptionPane.showMessageDialog(rootPane, "seleccionado el combo "+i);
                //System.out.println(e.toString());
            }
            
        }
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < combos.length; i++) {
            if(e.getSource() == combos[i]){
                JOptionPane.showMessageDialog(rootPane, "seleccionado el combo "+i);
                //System.out.println(e.toString());
            }
            
        }
    }
    public static void main(String[] args) {
        CajaComboVector ventana = new CajaComboVector();
        ventana.setBounds(0,0,200,250);
        ventana.ColocarElementos();
        ventana.setVisible(true);
    }

}
