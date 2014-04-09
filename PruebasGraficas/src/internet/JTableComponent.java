package internet;

/**
 *
 * @author Alejandro Peña Florentín
 * @version 1.0 02-abr-2014
 */
import javax.swing.*;
import java.awt.*;

public class JTableComponent {

    public static void main(String[] args) {
        new JTableComponent();
    }

    public JTableComponent() {
        JFrame // Establish the frame.
                frame = new JFrame("title");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(700, 700));

        // Establish button dimensions.
        Dimension buttonDimension = new Dimension(120, 120);

        // Establish Textfield dimensions.
        Dimension textDimension = new Dimension(110, 110);

        // Create an input text field.
        JTextField textInput = new JTextField(20);
        textInput.setPreferredSize(textDimension);
        textInput.setMinimumSize(textDimension);
        textInput.setMaximumSize(textDimension);
        textInput.setHorizontalAlignment(JTextField.CENTER);
        JPanel panel = new JPanel();
        panel.add(textInput);
        String string = textInput.getText();

        // Display the frame and text field.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(textInput);
    }
}
