import data.Matrix;
import data.Reader;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Matrix> matrices = new Reader().readData("data/mnist_test.csv");
        System.out.println(matrices.get(3).toString());
    }
}