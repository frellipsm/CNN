package layers;

import java.util.List;

public class ConvolutionLayer extends Layer{


    @Override
    public double[] getOutput(List<double[][]> input) {
        return new double[0];
    }

    @Override
    public double[] getOutput(double[] input) {
        return new double[0];
    }

    @Override
    public void backPropagation(List<double[][]> dLoss) {

    }

    @Override
    public void backPropagation(double[] dLoss) {

    }

    @Override
    public int getOutputLength() {
        return 0;
    }

    @Override
    public int getOutputRows() {
        return 0;
    }

    @Override
    public int getOutputCols() {
        return 0;
    }

    @Override
    public int getOutputElements() {
        return 0;
    }
}
