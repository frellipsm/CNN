package data;
//a matrix composing an 'image' of incoming data information
//other functions that may improve this library are: add(s), add(M), subtract(M, N)
//transpose(M), multiply(M, N), multiply(M), multiply(s), sigmoid(), dsigmoid()
//fromArray(double[] a), List<Double>toArray()
public class matrix {

    private double[][] data;
    private int label;

    public matrix(double[][] data, int label) {
        this.data = data;
        this.label = label;
    }

    public double[][] getData() {
        return data;
    }

    public int getLabel() {
        return label;
    }

    @Override
    public String toString() {
        String s = label + ", \n";
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                s += data[i][j] + ", ";
            }
            s += "\n";
        }
        return s;
    }
}

