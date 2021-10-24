package matrix;

import java.util.Vector;

/**
 * Experiment the implementation of 2D array
 */
public class MatrixImpl {

    static class Matrix {
        private Vector<Vector<Double>> matrix = new Vector<>();

        void addRandomDataToMatrix() {
            for (int i = 0; i < 3; i++) {
                Vector<Double> vector = new Vector<>();
                for (int j = 0; j < 3; j++) {
                    vector.add(Math.random());
                }
                matrix.add(vector);
            }
        }

        void printMatrixData() {
            if (!matrix.isEmpty()) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        System.out.println(" Result is : " + matrix.get(i).get(j));
                    }
                }
            }
        }

    }

    private static void print2D(int mat[][]) {
        // Loop through all rows
        for (int i = 0; i < mat.length; i++)

            // Loop through all elements of current row
            for (int j = 0; j < mat[i].length; j++)
                System.out.print(mat[i][j] + " ");
    }

    public static void main(String[] args) {

        //Using vector in java
        Matrix matrix = new Matrix();
        matrix.addRandomDataToMatrix();
        matrix.printMatrixData();

        //Using normal Java initialization
        int mat[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        print2D(mat);
    }
}
