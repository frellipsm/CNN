package network;

import layers.ConvolutionLayer;
import layers.FullyConnectedLayer;
import layers.Layer;
import layers.MaxPoolLayer;

import java.util.ArrayList;
import java.util.List;

//a builder passion
public class NetworkBuilder {
    private NeuralNetwork network;
    private int _inputRows;
    private int _inputCols;
    private List<Layer> _layers;
    private double _scaleFactor;

    public NetworkBuilder(int _inputRows, int _inputCols, double _scaleFactor) {
        this._inputRows = _inputRows;
        this._inputCols = _inputCols;
        this._scaleFactor = _scaleFactor;
        _layers = new ArrayList<>();
    }

    public void addConvolutionLayer(int numFilters, int filterSize, int stepSize, double learningRate, long SEED){
        //first?
        if(_layers.isEmpty()){
            _layers.add(new ConvolutionLayer(filterSize, stepSize, 1, _inputRows, _inputCols, numFilters, learningRate, SEED));
        } else {
            Layer prev = _layers.get(_layers.size()-1);
            _layers.add(new ConvolutionLayer(filterSize, stepSize, prev.getOutputLength(), prev.getOutputRows(), prev.getOutputCols(), numFilters, learningRate, SEED));
        }
    }
    public void addMaxPoolLayer(int windowSize, int stepSize){
        //first?
        if(_layers.isEmpty()){
            _layers.add(new MaxPoolLayer(windowSize, stepSize, 1, _inputRows, _inputCols));
            //int _windowSize, int _stepSize, int _inLength, int _inRows, int _inCol
        } else {
            Layer prev = _layers.get(_layers.size()-1);
            _layers.add(new MaxPoolLayer(windowSize, stepSize, prev.getOutputLength(), prev.getOutputRows(), prev.getOutputCols()));
        }
    }
    public void addFullyConnectedLayer(int outLength, double learningRate, long SEED){
        //first?
        if(_layers.isEmpty()){
            _layers.add(new FullyConnectedLayer(_inputCols*_inputRows, outLength, learningRate, SEED));

        } else {
            Layer prev = _layers.get(_layers.size()-1);
            _layers.add(new FullyConnectedLayer(prev.getOutputElements(), outLength, learningRate, SEED));
        }
    }

    //lost of error/logic checks possible

    public NeuralNetwork build(){
        network = new NeuralNetwork(_layers, _scaleFactor);
        return network;
    }

}
