package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    private final int rows = 28;
    private final int cols = 28;

    public List<Matrix> readData(String path){
        List<Matrix> matrices = new ArrayList<>();

        //read a csv line
        try (BufferedReader dataReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = dataReader.readLine()) != null) {
                String[] lineItems = line.split(",");

                double[][] data = new double[rows][cols];
                //first element is the label
                int label = Integer.parseInt(lineItems[0]);
                int i = 1;
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        data[row][col] = (double) Integer.parseInt(lineItems[i]);
                        i++;
                    }
                }

                //add image to image table
                matrices.add(new Matrix(data, label));

            }
        } catch (Exception e)
        {}

        return matrices;
    }
}
