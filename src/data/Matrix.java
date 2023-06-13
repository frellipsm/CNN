package data;
//a matrix composing an 'image' of incoming data information
//other functions that may improve this class include other matrix operations
// : add(s), add(M), subtract(M, N)
//  transpose(M), multiply(M, N), multiply(M), multiply(s)
// rather than creating sigmoid or derivative sigmoid, we may wish to use relu
// of course the derivative of relu is 1
//fromArray(double[] a), List<Double>toArray()
public class Matrix {

    private double[][] data;
    private int label;
    private int rows, cols;

    public Matrix(double[][] data, int label) {
        this.data = data;
        this.label = label;
        this.rows = data.length;
        this.cols = data[0].length;
    }

    public double[][] getData() {
        return data;
    }

    public int getLabel() {
        return label;
    }

    public void add (double scaler){
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                this.data[i][j]+=scaler;
            }
        }
    }

    public void add(Matrix m){
        if (cols != m.cols || rows != m.rows) {
            System.out.println("Shape Mismatch");
            return;
        }
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                this.data[i][j]+=m.data[i][j];
            }
        }
    }

    public static Matrix subtract(Matrix a, Matrix b){
        Matrix temp = new Matrix(new double[a.rows][a.cols],a.label);
        for (int i=0;i<a.rows;i++) {
            for (int j = 0; j < a.cols; j++) {
                temp.data[i][j] = a.data[i][j] - b.data[i][j];
            }
        }
        return temp;
    }
    public static Matrix transpose(Matrix a){
        Matrix temp = new Matrix(new double[a.rows][a.cols],a.label);
        for (int i=0;i<a.rows;i++){
            for (int j=0;j<a.cols;j++){
                temp.data[j][i]=a.data[i][j];
            }
        }
        return temp;
    }

    public static Matrix multiply (Matrix a, Matrix b){
        Matrix temp = new Matrix(new double[a.rows][b.cols],a.label);
        for (int i=0; i<temp.rows;i++){
            for (int j=0;j<temp.cols;j++){
                double sum=0;
                for (int k=0;k<a.cols;k++){
                    sum+=a.data[i][k]*b.data[k][j];
                }
                temp.data[i][j]=sum;
            }
        }
        return temp;
    }
    public void multiply(Matrix a){
        for(int i=0;i<a.rows;i++){
            for (int j=0;j<a.cols;j++){
                this.data[i][j]*=a.data[i][j];
            }
        }
    }
    public void multiply(double a){
        for(int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                this.data[i][j]*=a;
            }
        }
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

