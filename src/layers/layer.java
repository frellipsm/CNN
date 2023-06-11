package layers;

import java.util.ArrayList;
import java.util.List;

public abstract class layer {
    protected layer _nextLayer;
    protected layer _previousLayer;

    public abstract double[] getOutput(List<double[][]> input);
    public abstract double[] getOutput(double[] input);

    //cascade up the chain, derivatives of loss
    public abstract void backPropogation(List<double[][]> dLoss);
    public abstract void backPropogation(double[] dLoss);

    public abstract int getOutputLength(); //
    public abstract int getOutputRows(); //2d rows
    public abstract int getOutputCols(); //2d cols
    public abstract int getOutputElements(); //1d

    public layer get_nextLayer() {
        return _nextLayer;
    }

    public void set_nextLayer(layer _nextLayer) {
        this._nextLayer = _nextLayer;
    }

    public layer get_previousLayer() {
        return _previousLayer;
    }

    public void set_previousLayer(layer _previousLayer) {
        this._previousLayer = _previousLayer;
    }

    //flatten a 2d matrix into a 1d vector
    public double[] matrixToVector(List<double[][]> input){
        int length = input.size();
        int rows = input.get(0).length;
        int cols = input.get(0)[0].length;

        double[] vector = new double[length*rows*cols];

        int i = 0;
        //traverse the matrix, covert it into a 1d vector input for another layer
        for(int l=0; l<length; l++ ){
            for(int r=0; r<rows; r++){
                for(int c=0; c<cols; c++){
                    vector[i] = input.get(l)[r][c];
                    i++;
                }
            }
        }
        return vector;
    }

    //convert a 1d vector into a 2d matrix
    public List<double[][]> vectorToMatrix(double[] input, int length, int rows, int cols){
        List<double[][]> matrixOutput = new ArrayList<>();
        int i = 0;
        for(int l=0; l<length; l++){
            double [][] matrix = new double[rows][cols];
            for(int r=0; r<rows; r++){
                for(int c=0; c<cols; c++){
                    matrix[r][c] = input[i];
                    i++;
                }
            }
            matrixOutput.add(matrix);
        }
        return matrixOutput;
    }

}
