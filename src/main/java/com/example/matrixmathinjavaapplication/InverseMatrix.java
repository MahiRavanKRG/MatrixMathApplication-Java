package com.example.matrixmathinjavaapplication;

import java.text.DecimalFormat;

/**
 *  This class implements the Matrix class to become an application that can get a matrix from the user and make its inverse and then
 *  print again its result inverse matrix
 *
 */


public class InverseMatrix extends Matrix {
    DecimalFormat numberFormat = new DecimalFormat("#.00");

    double[][] inverseMatrix = new double[3][3] ;

        public void main() {
            for (int i = 0 ; i < 3 ; i++) {
                for (int j = 0; j < 3; j++) {
                    inverseMatrix[i][j] = ( i==j ? 1 : 0 );
                }
            }

        createMatrix();
        printMatrix(matrix , true);
        determinantOfMatrix = getDeterminantOfMatrix(matrix);
        System.out.println("The determinant of the given matrix is" + determinantOfMatrix);
        if(determinantOfMatrix==0){
            System.out.println("\nAs the determinant is zero, the inverse of this matrix is not possible.\nThis program will now terminate.");
            System.exit(0);
        }
        // This is the logic that calculates the inverse
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

            if(unitMatrixChecker(matrix)) printMatrix(inverseMatrix, false);
            else {
                System.out.println("Error occurred");
              //  printMatrix(inverseMatrix , false);
              //  printMatrix(matrix , true);
            }
    }

    public void decisionRowStart(double[] row, double rowValue, double[] rowI){ // Logical part of the algorithm.
        if(rowValue!=1)
        {x=1/rowValue; rowMultiplication(row,x); rowMultiplication(rowI,x);     }
    }

    public void decisionNextRow(double[] row, double rowValue, double[] baseRow, double[] rowI, double[] baseRowI) {
        if(rowValue!=0)
        {  rowAddition(row,baseRow,-rowValue); rowAddition(rowI,baseRowI,-rowValue);} // Second logical part of the algorithm.
    }

    boolean unitMatrixChecker(double[][] checkMatrix){ // at the end there s a need to check if the required changes are achieved in the
                                                       // matrix, this method is used for that.
        for (int i = 0 ; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                boolean b = (checkMatrix[i][j] == (i == j ? 1 : 0));
                if(!b) return false;
            }
        }
        return true;
    }

}
