package ejemplo1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author Alejandro Peña Florentín
 * @version 1.0 02-abr-2014
 */
public class filechooser extends JFrame {

    public filechooser() {
        setSize(450, 350);
        setLocation(100, 100);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(3);
        //--------------------
        JButton abrir = new JButton("Abrir");
        JButton guardar = new JButton("Guardar");
        // hacemos el filechooser
        final JFileChooser file1 = new JFileChooser();
        abrir.setBounds(10,10,100,25);
        guardar.setBounds(10,50,100,25);
        add(abrir);
        add(guardar);
        //le agregamos los filtros que deseamos
        Filtro filtro = new Filtro();
        file1.addChoosableFileFilter(filtro);
        
        //filechooser para abrir
        abrir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int a = file1.showOpenDialog(null);
                if(a==0){ //0 = aceptar
                    String path = file1.getSelectedFile().toString();
                    System.out.println(path + a);
                } else {
                    System.out.println("No seleccionado archivo.");
                }
            }
        });
        //filechooser para guardar
        guardar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                file1.showSaveDialog(null);
                int a = file1.showSaveDialog(null);
                if(a==0){ //0 = aceptar
                    String path = file1.getSelectedFile().toString();
                    System.out.println(path + a);
                } else {
                    System.out.println("No seleccionado archivo.");
                }
            }
        });
        setVisible(true);
        
    }   
    public static void main(String[] args) {
        new filechooser();

    }

}
