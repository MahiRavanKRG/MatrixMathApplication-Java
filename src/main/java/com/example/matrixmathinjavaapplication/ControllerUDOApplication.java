/**
 *      This class has all the required input fxml rom the fxml file.
 *      Now need to make the methods and add.
 *
 *
 *      I think of implementing this in steps,
 *          step 1: add extra requirements to the fxml file of InverseMatrixApplication. DONE
 *          step 2: test for one operation of multiplication, the chosen operation is row multiplication. DONE
 *
 *              > The work of row-addition function is going on
 *              ## I made the application GUI
 *              ## Next step is to test the newly added class.
 *
 *          step 3: add the rest of the elements to the fxml file and add proper methods and finish. working
 */

package com.example.matrixmathinjavaapplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Objects;

public class ControllerUDOApplication {

    @FXML
    private Label heading , DeterminantPrompt ;

    @FXML
    private TextField a11 , a12 , a13 , a21 , a22 , a23 , a31 , a32 , a33;
    @FXML
    private TextField inputRowM1 , inputRowM2 , inputVarM , inputRowA1 , inputRowA2 , inputRowA3 , inputVarA;

    @FXML
    private Button RowMultiplicationButton , RowAdditionButton , Determinant;

    public void OnRowMultiplicationButtonPress(){
        // now this will serve as the working logic of row multiplication
        try {

            if(inputRowM1.getText().equals(inputRowM2.getText())) inputRowM2.setText(inputRowM1.getText());
            RowAdditionButton.setDisable(true);


            double[][] controllerUDOMatrixC = new double[][]{
                    {Double.parseDouble(a11.getText()), Double.parseDouble(a12.getText()), Double.parseDouble(a13.getText())},
                    {Double.parseDouble(a21.getText()), Double.parseDouble(a22.getText()), Double.parseDouble(a23.getText())},
                    {Double.parseDouble(a31.getText()), Double.parseDouble(a32.getText()), Double.parseDouble(a33.getText())}
            };

            var inputMulVar = Double.parseDouble(inputVarM.getText());
            var inputRowVar = Integer.parseInt(inputRowM1.getText());

            Matrix controllerUDOMatrixObject = new Matrix(controllerUDOMatrixC);

            DeterminantPrompt.setText(".");

            if (-1<inputRowVar && inputRowVar<4){
                int targetRow = inputRowVar - 1;
                controllerUDOMatrixObject.rowMultiplication(controllerUDOMatrixObject.matrix[targetRow], inputMulVar);

               if (targetRow==0){
                    a11.setText(String.valueOf(controllerUDOMatrixObject.matrix[targetRow][0]));
                    a12.setText(String.valueOf(controllerUDOMatrixObject.matrix[targetRow][1]));
                    a13.setText(String.valueOf(controllerUDOMatrixObject.matrix[targetRow][2]));
                }
               else if (targetRow==1) {
                   a21.setText(String.valueOf(controllerUDOMatrixObject.matrix[targetRow][0]));
                   a22.setText(String.valueOf(controllerUDOMatrixObject.matrix[targetRow][1]));
                   a23.setText(String.valueOf(controllerUDOMatrixObject.matrix[targetRow][2]));
               }
               else if (targetRow==2) { // Ignore this
                   a31.setText(String.valueOf(controllerUDOMatrixObject.matrix[targetRow][0]));
                   a32.setText(String.valueOf(controllerUDOMatrixObject.matrix[targetRow][1]));
                   a33.setText(String.valueOf(controllerUDOMatrixObject.matrix[targetRow][2]));
               }
            }
           else
               DeterminantPrompt.setText("Enter Valid Row Value");

        } catch (Exception e) {
            // e.printStackTrace();
            DeterminantPrompt.setText("Enter all the values properly in all the text box");
        }

    }

    public  void OnRowAdditionButtonPress(ActionEvent actionEvent){
                // This is a work in progress.
        try {

            if(!inputRowA1.getText().equals(inputRowA2.getText())) inputRowA2.setText(inputRowA1.getText()); ;
            RowMultiplicationButton.setDisable(true);


            double[][] controllerUDOMatrixC = new double[][]{
                    {Double.parseDouble(a11.getText()), Double.parseDouble(a12.getText()), Double.parseDouble(a13.getText())},
                    {Double.parseDouble(a21.getText()), Double.parseDouble(a22.getText()), Double.parseDouble(a23.getText())},
                    {Double.parseDouble(a31.getText()), Double.parseDouble(a32.getText()), Double.parseDouble(a33.getText())}
            };

            var inputAddVar = Double.parseDouble(inputVarA.getText());
            var inputRowOneVar = Integer.parseInt(inputRowA1.getText());
            var inputRowTwoVar = Integer.parseInt(inputRowA3.getText());

            Matrix controllerUDOMatrixObject = new Matrix(controllerUDOMatrixC);

            DeterminantPrompt.setText(".");

            if (-1<inputRowOneVar && inputRowOneVar<4){
                int targetRow = inputRowOneVar - 1;
                int adderRow = inputRowTwoVar - 1;
                controllerUDOMatrixObject.rowAddition(controllerUDOMatrixObject.matrix[targetRow], controllerUDOMatrixObject.matrix[adderRow] , inputAddVar );

                if (targetRow==0){
                    a11.setText(String.valueOf(controllerUDOMatrixObject.matrix[targetRow][0]));
                    a12.setText(String.valueOf(controllerUDOMatrixObject.matrix[targetRow][1]));
                    a13.setText(String.valueOf(controllerUDOMatrixObject.matrix[targetRow][2]));
                }
                else if (targetRow==1) {
                    a21.setText(String.valueOf(controllerUDOMatrixObject.matrix[targetRow][0]));
                    a22.setText(String.valueOf(controllerUDOMatrixObject.matrix[targetRow][1]));
                    a23.setText(String.valueOf(controllerUDOMatrixObject.matrix[targetRow][2]));
                }
                else if (targetRow==2) { // Ignore this
                    a31.setText(String.valueOf(controllerUDOMatrixObject.matrix[targetRow][0]));
                    a32.setText(String.valueOf(controllerUDOMatrixObject.matrix[targetRow][1]));
                    a33.setText(String.valueOf(controllerUDOMatrixObject.matrix[targetRow][2]));
                }
            }
            else
                DeterminantPrompt.setText("Enter Valid Row Value");

        } catch (Exception e) {
            // e.printStackTrace();
            DeterminantPrompt.setText("Enter all the values properly in all the text box");
        }


    }



    public void OnDeterminantButtonPress(){
        try {
            double[][] controllerUDOMatrixD = new double[][]{ // This is matrix initialization
                    {Double.parseDouble(a11.getText()), Double.parseDouble(a12.getText()), Double.parseDouble(a13.getText())},
                    {Double.parseDouble(a21.getText()), Double.parseDouble(a22.getText()), Double.parseDouble(a23.getText())},
                    {Double.parseDouble(a31.getText()), Double.parseDouble(a32.getText()), Double.parseDouble(a33.getText())}
            };

            Matrix controllerUDOMatrixDObject = new Matrix(controllerUDOMatrixD); // Then put the matrix in object and simply call the class methods

            DeterminantPrompt.setText( "The determinant of the given matrix is " + controllerUDOMatrixDObject.getDeterminantOfMatrix(controllerUDOMatrixDObject.matrix));

        }catch (Exception exception){
            exception.printStackTrace();
            DeterminantPrompt.setText("Please contact help something went wrong");
        }

    }

    public void OninputRowMLeave(){
        inputRowM2.setText(inputRowM1.getText());
    }
    public void OninputRowALeave(){
        inputRowA2.setText(inputRowA1.getText());
    }

    public void OnMultiplicationRadioSelect(){ RowAdditionButton.setDisable(true); RowMultiplicationButton.setDisable(false); }
    public void OnAdditionRadioSelect(){ RowMultiplicationButton.setDisable(true); RowAdditionButton.setDisable(false);}
}
