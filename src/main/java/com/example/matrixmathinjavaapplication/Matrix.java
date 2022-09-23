
/**
 *   This class is used to implement the 3X3 Matrix, and it uses the 2-Dimensional matrix, so you can map your matrix accordingly
 *
 *                  |   A[1][1]     A[1][2]     A[1][3]    |                |   matrix[0][0]   matrix[0][1]   matrix[0][2]  |
 *                  |   A[2][1]     A[2][2]     A[2][3]    |    --->>       |   matrix[1][0]   matrix[1][1]   matrix[1][2]  |
 *                  |   A[3][1]     A[3][2]     A[3][3]    |                |   matrix[2][0]   matrix[2][1]   matrix[2][2]  |
 *
 *  The above depiction is a mapping to the elements of the 3X3 Matrix.
 *
 *  CONSTRUCTORS
 *  This class has the following constructors
 *      ->{constructor} Matrix(); || is used for unit matrix.
 *      ->{constructor} Matrix(true);  || boolean is just for the purpose of segregation, true\false doesn't matter.
 *                                     || this is used for user initialization of the matrix.
 *      ->{constructor} Matrix(double[][] ); || is used to copy the inserted matrix.
 *
 *  METHODS
 *  This class has the following methods
 *      -> void printMatrix(Matrix a , boolean b)  || this is used to print the matrix object.
 *      -> void printMatrix(double[][] a , boolean b)  || this is used to print the 3X3 matrix.
 *                      ***->         || If the boolean is true then it prints matrix.
 *                                    || If the boolean is false then it prints Inverse matrix.
 *
 *      -> void createMatrix();  || this method is used to give matrix values again.
 *
 *      -> double[][] getMatrix();  || this method is used to return the three-dimensional matrix
 *      -> void setMatrix();  || this method is used to set the matrix to the given 3X3 matrix.
 *
 *      -> boolean equalsTo(Matrix x); || this method is used to find if the input is equal to the current matrix.
 *      -> boolean equalsTo(double[][] x); || this method is used to find if the input is equal to the current matrix.
 *
 *
 *  MATRIX OPERATIONS
 *      -> double getDeterminantOfMatrix(double[][] r ); || this method is used to calculate and return determinant.
 *      -> void rowInterchange(double[] a,double[] b); || this method is row interchange operation.
 *      -> void rowAddition(double[] a, double[] b, double x); || this method is addition operation.
 *      -> void rowMultiplication(double[] a,double x); || this method is row multiplication operation.
 *      -> double[][] transpose();  || this method is used to find and return 3X3 transpose matrix.
 *
 */

package com.example.matrixmathinjavaapplication;

import java.util.Scanner;

public class Matrix {

    Matrix(double[][] matrix) {  // initializes the matrix using the given input.
        this.matrix = matrix;
    } // constructor Matrix( double[][] ) ends here

    Matrix(){  // used for initialization of unit matrix
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = ( i==j ? 1 : 0 );
            }
        }
    } // constructor Matrix() ends here


    double[][] matrix = new double[3][3] ;  // the matrix.
    double determinantOfMatrix , x = 0 ;  // stores the determinant.

    Scanner scan = new  Scanner(System.in);  // the only scanner of this class.



    Matrix(boolean fakeVariable){  // used for initialization of user dictated matrix.

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print("A[" + i + "][" + j + "] = " );
                    matrix[i][j] = scan.nextDouble();
                }
            }
    } // constructor Matrix(boolean p) ends here

    void createMatrix(){  // used for initialization of user dictated matrix / this is a method and can be used whenever needed.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("A[" + i + "][" + j + "] = " );
                matrix[i][j] = scan.nextDouble();
            }
        }
    } // method createMatrix() ends here


    public void printMatrix(Matrix a , boolean b) {  // used to print the input matrix, this is FIRST overloaded form / it has two overloaded forms
        // this method has two parameters Matrix object and a boolean
        // Matrix object is what is to be printed and boolean is say whether the input is matrix(true) or inverse matrix(false)
        // boolean was used do that sout is not required to write for message before printing the matrix.
        if (b) System.out.println("The matrix is ");
        else System.out.println("The Inverse matrix is");

        for ( double[] x : a.matrix ) { // for each is implemented to print the matrix.
            System.out.println();
            for ( double y : x ) {
                System.out.print("\t\t\t"  + y );
            }

        }
        System.out.println();
    } // method printMatrix(Matrix a , boolean b) ends here / FIRST overload

    public void printMatrix(double[][] a , boolean b) { // used to print the input matrix, this is SECOND overloaded form
        // this method has two parameters 2D matrix array and a boolean
        // 2D matrix array is what is to be printed, this gives flexibility to this method and printMatrix() can also be used to print 2D arrays
        // boolean is say whether the input is matrix(true) or inverse matrix(false)
        // boolean was used do that sout is not required to write for message before printing the matrix.
        if (b) System.out.println("The matrix is ");
        else System.out.println("The Inverse matrix is");

        for ( double[] x : a ) { // for each is implemented to print the matrix.
            System.out.println();
            for ( double y : x ) {
                System.out.print("\t\t\t"  + y );
            }

        }
        System.out.println();
    } // method printMatrix(double[][] a , boolean b) ends here / SECOND overload


    double[][] transpose(){ // this method is used to create a transpose of the given matrix and return it as a 2D array matrix.
        double[][] matrixTranspose = new double[3][3];
        for (int i=0 ; i<3 ; i++){
            for (int j = 0; j < 3; j++) {
                matrixTranspose[i][j] =  matrix[j][i] ;
            }
        }
//        System.out.print("Transpose ");  // this can be used to print this matrix on the console. --> commented code
//        printMatrix( matrixTranspose , true );                                                    --> commented code

        return matrixTranspose;
    } // method transpose() ends here



    void initializeExOneToNine(){  // this is used to test the code it gives some values and initializes the matrix for use
        double k = 0 ;   // this is supposed to be temporary
        for (int i=0 ; i<3 ; i++){
            for (int j = 0; j < 3; j++) {
                ++k;
                matrix[i][j] = k;

            }
        }
    } // method initialize() ends here




    boolean equalsTo(Matrix x){  // used to check for the equality of matrix. / it has two overloaded forms
        return (matrix == x.matrix);
    } // method equalsTo() ends here / FIRST overload

    boolean equalsTo(double[][] x){  // used to check for the equality of matrix. / it has two overloaded forms
        return (matrix == x);
    } // method equalsTo() ends here / SECOND overload



    double getDeterminantOfMatrix(double[][] r ){   // This object uses Saraus theorem to get the determinant of the matrix.
        double b,c;
        b=(( r[0][0] * r[1][1] * r[2][2] ) + ( r[0][1] * r[1][2] * r[2][0] ) + ( r[0][2] * r[1][0] * r[2][1] ));
        c=(( r[0][2] * r[1][1] * r[2][0] ) + ( r[0][1] * r[1][0] * r[2][2] ) + ( r[0][0] * r[1][2] * r[2][1] ));

        return (b-c);
    } // method getDeterminantOfMatrix(double[][]) ends here


    public void rowInterchange(double[] a,double[] b){     // This method performs row interchange.
        double g;

        //swap first element
        g=a[0];
        a[0]=b[0];
        b[0]=g;

        //swap second element
        g=a[1];
        a[1]=b[1];
        b[1]=g;

        //swap third element
        g=a[2];
        a[2]=b[2];
        b[2]=g;
    } // method rowInterchange(double[],double[]) ends here


    public void rowAddition(double[] a, double[] b, double x){ // this method performs matrix row addition.
        //  HERE A IS TARGET AND B IS ADDITION ROW.+
        a[0]+=(x*b[0]);
        a[1]+=(x*b[1]);
        a[2]+=(x*b[2]);
    } // method rowAddition(double[], double[], double) ends here


    public void rowMultiplication(double[] a,double x){  // This method performs matrix row multiplication.
        a[0]*=x;
        a[1]*=x;
        a[2]*=x;
    } // method rowMultiplication(double[],double) ends here


    public double[][] getMatrix() {
        return matrix;
    }

//    public Matrix getMatrix() { return Matrix; }     --> commented code



    public void setMatrix(double[][] matrix) { this.matrix = matrix; }

//    public void setMatrix(Matrix x) { this.matrix = x.matrix; }     --> commented code

}
