import data.matrix;
import data.reader;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<matrix> matrices = new reader().readData("data/mnist_test.csv");
        System.out.println(matrices.get(3).toString());
    }
}