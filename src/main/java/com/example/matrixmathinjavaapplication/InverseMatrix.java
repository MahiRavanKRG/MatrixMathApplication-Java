
/**
 *   This class implements the Matrix class to calculate and return the inverse matrix.
 *
 *                  |   A[1][1]     A[1][2]     A[1][3]    |                |   matrix[0][0]   matrix[0][1]   matrix[0][2]  |
 *                  |   A[2][1]     A[2][2]     A[2][3]    |    --->>       |   matrix[1][0]   matrix[1][1]   matrix[1][2]  |
 *                  |   A[3][1]     A[3][2]     A[3][3]    |                |   matrix[2][0]   matrix[2][1]   matrix[2][2]  |
 *
 *  The above depiction is a mapping to the elements of the 3X3 Matrix.
 *
 *  CONSTRUCTORS
 *  This class has the following constructors
 *      ->{constructor} InverseMatrix(double[][] x); || is used to initialize matrix.
 *
 *  METHODS
 *  This class has the following methods
 *      -> double[][] main(); || this is the core method of this class and contains all the logic to perform the inverse.
 *      -> void decisionRowStart(double[], double, double[]); || this is a part of logic and used when the decision of a new column starts.
 *      -> void decisionNextRow(double[], double, double[], double[], double[]); || this is a part of logic and used after the above method "decisionRowStart" has been used.
 *      -> boolean unitMatrixChecker(double[][] checkMatrix); || this is used ot check for the unit matrix.
 *
 *      ##  "-> commented code" means that it is useful code but as not presently required it is commented.
 *
 */

package com.example.matrixmathinjavaapplication;

import java.text.DecimalFormat;

public class InverseMatrix extends Matrix {

    InverseMatrix(double[][] x){
        super.matrix = x ;
    } // constructor InverseMatrix(double[][]) ends here
    DecimalFormat numberFormat = new DecimalFormat("#.00"); // used to format the matrix after the operations.

    double[][] inverseMatrix = new double[3][3] ; // used to store the inverse matrix.

    static double[][] UNITMATRIX = { // this is the static Unit matrix
                                      { 1 , 0 , 0 } ,
                                      { 0 , 1 , 0 } ,
                                      { 0 , 0 , 1 } } ;

    static double[][] ERRORMATRIX = { // this is the double ERRORMATRIX and this is used to represent the errors.
                                      { 1 , 0 , 1 } ,
                                      { 1 , 0 , 1 } ,
                                      { 1 , 0 , 1 } } ;

        public double[][] main() {

            inverseMatrix = UNITMATRIX; // used to initialize the inverse matrix so that I can perform the algorithm.


        // createMatrix();   // This was used in command line to get the matrix. -> commented code
        // printMatrix(matrix , true); // This was used in command line to print the input matrix. -> commented code
        determinantOfMatrix = getDeterminantOfMatrix(matrix);
        // System.out.println("The determinant of the given matrix is" + determinantOfMatrix); // This was used to print  the determinant. -> commented code
        if(determinantOfMatrix==0){
           // System.out.println("\nAs the determinant is zero, the inverse of this matrix is not possible.\nThis program will now terminate."); -> commented code
           // System.exit(0); -> commented code
            return UNITMATRIX;
        }
        // This is the logic that calculates the inverse
        // it uses column method where we make consecutive columns into unit matrix.
        if(matrix[0][0]==0 && matrix[1][0]!=0) {
            rowInterchange(matrix[0], matrix[1]);
            rowInterchange(inverseMatrix[0], inverseMatrix[1]);
        }
        else if(matrix[0][0] == 0) {
            rowInterchange(matrix[0], matrix[2]);
            rowInterchange(inverseMatrix[0], inverseMatrix[2]);
        }

        decisionRowStart(matrix[0],matrix[0][0],inverseMatrix[0]);

        decisionNextRow(matrix[1],matrix[1][0],matrix[0],inverseMatrix[1],inverseMatrix[0]);
        decisionNextRow(matrix[2],matrix[2][0],matrix[0],inverseMatrix[2],inverseMatrix[0]);


        decisionRowStart(matrix[1],matrix[1][1],inverseMatrix[1]);

        decisionNextRow(matrix[0],matrix[0][1],matrix[1],inverseMatrix[0],inverseMatrix[1]);
        decisionNextRow(matrix[2],matrix[2][1],matrix[1],inverseMatrix[2],inverseMatrix[1]);


        decisionRowStart(matrix[2],matrix[2][2],inverseMatrix[2]);

        decisionNextRow(matrix[0],matrix[0][2],matrix[2],inverseMatrix[0],inverseMatrix[2]);
        decisionNextRow(matrix[1],matrix[1][2],matrix[2],inverseMatrix[1],inverseMatrix[2]);

// here the unit matrix has too much accuracy, so it produces error occurred. To remove this I manually limit the accuracy.
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    matrix[i][j] = Double.parseDouble(numberFormat.format(matrix[i][j]));
                }
            }
// this is used to remove the long decimal precision and makes the answer smoother
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    inverseMatrix[i][j] = Double.parseDouble(numberFormat.format(inverseMatrix[i][j]));
                }
            }

// I am getting negative zeroes so to remove them
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    matrix[i][j] = Math.abs(matrix[i][j]);
                }
            }

            if(unitMatrixChecker(matrix))// (super.equalsTo(UNITMATRIX)) <-- this son of a bitch somehow gives error, THe FUck if I know why. //printMatrix(inverseMatrix, false); -> commented code
                return inverseMatrix;
            else {
                return ERRORMATRIX ;
              //  printMatrix(inverseMatrix , false); -> commented code
              //  printMatrix(matrix , true); -> commented code
            }
    } // method main() ends here

    public void decisionRowStart(double[] row, double rowValue, double[] rowI){ // Logical part of the algorithm.
        if(rowValue!=1)
        {x=1/rowValue; rowMultiplication(row,x); rowMultiplication(rowI,x);     }
    } // method decisionRowStart() ends here

    public void decisionNextRow(double[] row, double rowValue, double[] baseRow, double[] rowI, double[] baseRowI) {
        if(rowValue!=0)
        {  rowAddition(row,baseRow,-rowValue); rowAddition(rowI,baseRowI,-rowValue);} // Second logical part of the algorithm.
    } // method decisionNextRow() ends here

    boolean unitMatrixChecker(double[][] checkMatrix) { // at the end there s a need to check if the required changes are achieved in the
                                                       // matrix, this method is used for that.
        for (int i = 0 ; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                boolean b = (checkMatrix[i][j] == (i == j ? 1 : 0));
                if(!b) return false;
            }
        }
        return true;
    } // method unitMatrixChecker() ends here

}
