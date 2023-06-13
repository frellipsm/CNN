package network;

import layers.ConvolutionLayer;
import layers.FullyConnectedLayer;
import layers.Layer;
import layers.MaxPoolLayer;

import java.util.List;

//a builder passion
public class NetworkBuilder {
    private NeuralNetwork network;
    private int _inputRows;
    private int _inputCols;
    private List<Layer> _layers;

    public NetworkBuilder(int _inputRows, int _inputCols) {
        this._inputRows = _inputRows;
        this._inputCols = _inputCols;
    }

    public void addConvolutionLayer(int numFilters, int filterSize, int stepSize, double learningRate, long SEED){
        //first?
        if(_layers.isEmpty()){
            _layers.add(new ConvolutionLayer(filterSize, stepSize, 1, _inputRows, _inputCols, numFilters, learningRate, SEED));
            //int _filterSize, int _stepSize, int _inLength, int _inRows, int _inCols, long SEED, int _numFilters, double learningRate
        } else {
            Layer prev = _layers.get(_layers.size()-1);
            _layers.add(new ConvolutionLayer(filterSize, stepSize, prev.getOutputLength(), prev.getOutputRows(), prev.getOutputCols(), numFilters, learningRate, SEED));
        }
    }
    public void addMaxPoolLayer(int windowSize, int stepSize){
        //first?
        if(_layers.isEmpty()){
            _layers.add(new MaxPoolLayer(windowSize, stepSize, 1, _inputRows, _inputCols));
            //int _windowSize, int _stepSize, int _inLength, int _inRows, int _inCols
        } else {
            Layer prev = _layers.get(_layers.size()-1);
            _layers.add(new MaxPoolLayer(stepSize, windowSize, prev.getOutputLength(), prev.getOutputRows(), prev.getOutputCols()));
        }
    }
    public void addFullyConnectedLayer(int outLength, double learningRate, long SEED){
        //first?
        if(_layers.isEmpty()){
            _layers.add(new FullyConnectedLayer(_inputCols*_inputRows, outLength, learningRate, SEED));
            //int _inLength, int _outLength, double learningRate, long SEED
        } else {
            Layer prev = _layers.get(_layers.size()-1);
            _layers.add(new FullyConnectedLayer(prev.getOutputElements(), prev.getOutputLength(), learningRate, SEED));
        }
    }

}
