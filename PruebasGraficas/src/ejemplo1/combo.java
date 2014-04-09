package ejemplo1;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 *
 * @author Alejandro Peña Florentín
 * @version 1.0 02-abr-2014
 */
public class combo extends JFrame {

    public combo() {
        setSize(450, 350);
        setLocation(100, 100);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(3);
        //--------------------
        JComboBox combo1 = new JComboBox();
        add(combo1);
        combo1.setBounds(10,10,100,25);
        combo1.addItem("Item 1");
        combo1.addItem("Item 2");
        combo1.addItem("Item 3");
        combo1.addItem("Item 4");
        combo1.addItem("Item 5");
        
        combo1.addItemListener(new ItemListener(){
           public void itemStateChanged(ItemEvent f) {
               System.out.println(f.getItem().toString());
           }
        });
        
    }   
    public static void main(String[] args) {
        new combo();

    }

}
