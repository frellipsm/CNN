package data;

public class MatrixUtility {

    public static double[][] add(double[][] a, double[][] b){
        double[][] temp = new double[a.length][a[0].length];
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a[0].length;j++){
                temp[i][j] = a[i][j] + b[i][j];
            }
        }
        return temp;
    }

    public static double[] add(double[] a, double[] b){
        double[] temp = new double[a.length];

        for(int i=0; i<a.length;i++){
            temp[i]=a[i] + b[i];
        }
        return temp;
    }

    public static double[][] subtract(double[][] a, double[][] b){
        double[][] temp = new double[a.length][a[0].length];
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a[0].length;j++){
                temp[i][j] = a[i][j] - b[i][j];
            }
        }
        return temp;
    }

    public static double[] subtract(double[] a, double[] b){
        double [] temp = new double[a.length];

        for (int i=0; i<a.length;i++){
            temp[i]=a[i]-b[i];
        }
        return temp;
    }

    public static double[][] transpose(double[][] a){
        double[][] temp = new double[a.length][a[0].length];
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a[0].length;j++){
                temp[j][i]=temp[i][j];
            }
        }
        return temp;
    }

    public static double[][] flipHorizontal(double[][] a){
        int rows = a.length;
        int cols = a[0].length;
        double[][] temp = new double[rows][cols];
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                temp[rows-i-1][j] = a[i][j];
            }
        }
        return temp;
    }
    public static double[][] flipVertical(double[][] a){
        int rows = a.length;
        int cols = a[0].length;
        double[][] temp = new double[rows][cols];
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                temp[i][cols-j-1] = a[i][j];
            }
        }
        return temp;
    }

    //dot product of two matrices
    public static double[][] multiply (double[][] a, double[][] b){
        double[][] temp = new double[a.length][a[0].length];
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a[0].length;j++){
                double sum=0;
                for (int k=0;k<a[0].length;k++){
                    sum+=a[i][k]*b[k][j];
                }
                temp[i][j]=sum;
            }
        }
        return temp;
    }

    //dot product of a flattened vector requires compatible dimensions

    public static double[][] multiply (double[][] a, double scalar){
        double[][] temp = new double[a.length][a[0].length];
        for (int i=0;i<a.length;i++){
            for (int j=0;j<a[0].length;j++){
                temp[i][j] = a[i][j]*scalar;
            }
        }
        return temp;
    }

    public static double[] multiply (double[] a, double scalar){
        double[] temp = new double[a.length];
        for (int i=0;i<a.length;i++){
            temp[i] = a[i]*scalar;
        }
        return temp;
    }

}
