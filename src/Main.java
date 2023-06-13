import data.Matrix;
import data.Reader;
import display.ImageGrid;
import network.NetworkBuilder;
import network.NeuralNetwork;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static java.util.Collections.shuffle;

public class Main {
    static final int IMAGE_SIZE = 28;
    static final int SCALE_FACTOR = 256*100;
    static final long SEED = 123;
    public static void main(String[] args) {
        System.out.println("Starting data load..");
        List<Matrix> imageTrain = new Reader().readData("data/mnist_train.csv");
        System.out.println("Training Image Size: " + imageTrain.size());
        List<Matrix> imageTest = new Reader().readData("data/mnist_test.csv");
        System.out.println("Test Image Size: " + imageTest.size());

        NetworkBuilder builder = new NetworkBuilder(IMAGE_SIZE, IMAGE_SIZE, SCALE_FACTOR);
        builder.addConvolutionLayer(8, 5, 1, 0.1, SEED);
        builder.addMaxPoolLayer(3, 2);
        builder.addFullyConnectedLayer(10,0.1,SEED);
        NeuralNetwork network = builder.build();

        float rate = network.test(imageTest);
        System.out.println("Pre training success rate: " + rate);

        int epochs = 3;

        for (int i=0;i<epochs; i++){
            shuffle(imageTrain);
            network.train(imageTrain);
            rate = network.test(imageTest);
            System.out.println("Success rate after round " + i + ": " + rate);
        }

        //System.out.println(imageTest.get(3).toString());

        ImageGrid grid = new ImageGrid();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                grid.createAndShowGUI();
            }
        });

    }
}