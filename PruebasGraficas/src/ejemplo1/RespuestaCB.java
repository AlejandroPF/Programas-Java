
package ejemplo1;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Alejandro Peña Florentín
 * @version 1.0 03-abr-2014
 */
public class RespuestaCB extends JFrame implements ChangeListener{
    private JCheckBox check1,check2,check3;
    public RespuestaCB(){
        setLayout(null);
        check1 = new JCheckBox("Valencia");
        check1.setBounds(10,10,150,30);
        check1.addChangeListener(this);
        check2 = new JCheckBox("Barcelona");
        check2.setBounds(10,50,150,30);
        check2.addChangeListener(this);
        check3 = new JCheckBox("Madrid");
        check3.setBounds(10,90,150,30);
        check3.addChangeListener(this);
        add(check1);
        add(check2);
        add(check3);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(300,200);
        setLocationRelativeTo(null);
        
    }
    @Override
    public void stateChanged(ChangeEvent e) {
        String titulo="";
        if(check1.isSelected()){
            titulo= titulo+"Valencia";
        }
        if(check2.isSelected()){
            titulo= titulo+"Barcelona";
        }
        if(check3.isSelected()){
            titulo= titulo+"Madrid";
        }
        setTitle(titulo);
    }
    public static void main(String[] args) {
        new RespuestaCB();
    }

}
