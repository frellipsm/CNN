import data.Matrix;
import data.Reader;
import display.ImageGrid;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Matrix> matrices = new Reader().readData("data/mnist_test.csv");
        System.out.println(matrices.get(3).toString());

        ImageGrid grid = new ImageGrid();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                grid.createAndShowGUI();
            }
        });

    }
}