package ejemplo1;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Alejandro Peña Florentín
 * @version 1.0 03-abr-2014
 */
public class RadioB extends JFrame implements ChangeListener {
    
    private JRadioButton radio1, radio2, radio3;
    private ButtonGroup grupobotones;
    
    public RadioB() {
        setLayout(null);
        grupobotones = new ButtonGroup();
        radio1 = new JRadioButton("640x480");
        radio1.setBounds(10, 20, 100, 30);
        radio1.addChangeListener(this);
        add(radio1);
        grupobotones.add(radio1);
        radio2 = new JRadioButton("800x600");
        radio2.setBounds(10, 70, 100, 30);
        radio2.addChangeListener(this);
        add(radio2);
        grupobotones.add(radio2);
        radio3 = new JRadioButton("1024x768");
        radio3.setBounds(10, 120, 100, 30);
        radio3.addChangeListener(this);
        add(radio3);
        grupobotones.add(radio3);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if(radio1.isSelected()){
            setSize(640,480);
        }
         if(radio2.isSelected()){
            setSize(800,600);
        }
          if(radio3.isSelected()){
            setSize(1024,768);
        }
          
    }
    public static void main(String[] args) {
        RadioB ventana = new RadioB();
        ventana.setBounds(0,0,350,230);
        ventana.setVisible(true);
    }
    
}
