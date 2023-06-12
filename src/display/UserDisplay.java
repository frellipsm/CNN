package display;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class UserDisplay extends JFrame {

    JLabel inputTextLabel;
    JTextField inputTextField;
    JButton clearButton, enterButton;
    ImageGrid grid;

    public UserDisplay() {initComponents();}

    public void initComponents(){
        inputTextLabel = new JLabel("Datum Display");
        inputTextField = new JTextField("Element#?");
        clearButton = new JButton("Clear");
        enterButton = new JButton("Enter");

        clearButton.addActionListener(this::clearButtonActionPerformed);
        enterButton.addActionListener(this::enterButtonActionPerformed);

        //layouthere

    }

    private void clearButtonActionPerformed(ActionEvent actionEvent) {
        inputTextField.setText("");
    }

    private void enterButtonActionPerformed(ActionEvent actionEvent) {
        //read # from inputTextField
            //validate mb
        //retrieve data for grid to draw
        //  double[][] data from curr_matrix
        // or double[] data from curr_layer
    }

}
