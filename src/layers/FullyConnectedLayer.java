package layers;

import java.util.List;
import java.util.Random;

public class FullyConnectedLayer extends Layer {

    //set of weights
    private double[][] _weights;
    private int _inLength;
    private int _outLength;
    private double _learningRate;

    //vectors
    private double[] lastZ;
    private double[] lastX;

    private long SEED;
    private final double leak = 0.01;

    public FullyConnectedLayer(int _inLength, int _outLength, long SEED, double learningRate){
        this._inLength = _inLength;
        this._outLength = _outLength;
        this.SEED = SEED;
        this._learningRate = learningRate;
        setRandomWeights(); //place for testing to set a determined weight

        _weights = new double[_inLength][_outLength];
        //random variation;
    }

    //forward pass of a vector
    public double[] fullyConnectedForwardPass(double[] input){

        lastX = input;
        double[] z = new double[_outLength];
        double[] out = new double[_outLength];

        //move through all input notes
        for(int i=0; i < _inLength; i++){
            for(int j=0; j < _outLength; j++){
                //summation of weighted inputs
                z[j] += input[i]*_weights[i][j];
            }
        }
        lastZ = z;

        //move through all input notes
        for(int i=0; i < _inLength; i++){
            for(int j=0; j < _outLength; j++){
                //bounding by activation function
                out[j] += reLu(z[j]);
            }
        }
        return out;
    }

    @Override
    public double[] getOutput(List<double[][]> input) {
        double[] vector = matrixToVector(input);
        return getOutput(vector);
    }

    @Override
    public double[] getOutput(double[] input) {
        double[] forwardPass = fullyConnectedForwardPass(input);

        if (_nextLayer != null) {
            return _nextLayer.getOutput(forwardPass);
        } else {
            return forwardPass;
        }
    }

    @Override
    public void backPropogation(List<double[][]> dld0) {
        double[] vector = matrixToVector(dld0);
        backPropogation(vector);
    }

    @Override
    public void backPropogation(double[] dld0) {

        double[] dLdx = new double[_inLength];

        double d0dz;
        double dzdw;
        double dldw;
        double dzdx;

        for (int k=0; k<_inLength; k++){

            double dLdX_sum = 0;

            for(int j=0; j<_outLength; j++){
                d0dz = derivativeReLu(lastZ[j]);
                dzdw = lastX[k];
                dzdx = _weights[k][j];

                dldw = dld0[j]*d0dz*dzdw;
                //reducing by relative loss based on learning rate
                _weights[k][j] -= dldw*_learningRate;

                dLdX_sum += dld0[j]*d0dz*dzdx;
            }

            dLdx[k] = dLdX_sum;
        }
        if(_previousLayer != null) {
            _previousLayer.backPropogation(dLdx);
        }
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
        return _outLength;
    }

    public void setRandomWeights(){
        Random random = new Random(SEED);
        //gaussian distribution
        for(int i=0; i< _inLength; i++){
            for(int j=0; j< _outLength; j++){
                _weights[i][j]=random.nextGaussian();
            }
        }
    }

    public double reLu(double input){
        if (input <= 0){
            return 0;
        }
        return input;
    }

    public double derivativeReLu(double input){
        if (input <= 0){
            return leak; //reduces deserts in the network
        }
        return 1;
    }
}
