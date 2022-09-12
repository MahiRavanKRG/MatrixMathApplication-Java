/**
 *      This class has all the required input fxml rom the fxml file.
 *      Now need to make the methods and add.
 *
 *
 *      I think of implementing this in steps,
 *          step 1: add extra requirements to the fxml file of InverseMatrixApplication. DONE
 *          step 2: test for one operation of multiplication, the chosen operation is row multiplication. DONE
 *
 *              > The Determinant button doesn't work as expected.
 *
 *          step 3: add the rest of the elements to the fxml file and add proper methods and finish. working
 */

package com.example.matrixmathinjavaapplication;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControllerUDOApplication {

    @FXML
    private Label heading , DeterminantPrompt ;

    @FXML
    private TextField a11 , a12 , a13 , a21 , a22 , a23 , a31 , a32 , a33;
    @FXML
    private TextField inputRow1 , inputRow2 , inputVar;

    @FXML
    private Button Calculate , Determinant;

    public void OnCalculateButtonPress(){
        try {

            if(inputRow1.getText()!=inputRow2.getText()) inputRow2.setText(inputRow1.getText()); ;


            double[][] controllerUDOMatrixC = new double[][]{
                    {Double.parseDouble(a11.getText()), Double.parseDouble(a12.getText()), Double.parseDouble(a13.getText())},
                    {Double.parseDouble(a21.getText()), Double.parseDouble(a22.getText()), Double.parseDouble(a23.getText())},
                    {Double.parseDouble(a31.getText()), Double.parseDouble(a32.getText()), Double.parseDouble(a33.getText())}
            };

            var inputMulVar = Double.parseDouble(inputVar.getText());
            var inputRowVar = Integer.parseInt(inputRow1.getText());

            Matrix controllerUDOMatrixObject = new Matrix(controllerUDOMatrixC);

            Exception exception = new Exception();

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
               else if (targetRow==2) {
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
            double[][] controllerUDOMatrixD = new double[][]{
                    {Double.parseDouble(a11.getText()), Double.parseDouble(a12.getText()), Double.parseDouble(a13.getText())},
                    {Double.parseDouble(a21.getText()), Double.parseDouble(a22.getText()), Double.parseDouble(a23.getText())},
                    {Double.parseDouble(a31.getText()), Double.parseDouble(a32.getText()), Double.parseDouble(a33.getText())}
            };

            Matrix controllerUDOMatrixDObject = new Matrix(controllerUDOMatrixD);

            DeterminantPrompt.setText( "The determinant of the given matrix is " + controllerUDOMatrixDObject.determinantOfMatrix);

        }catch (Exception exception){
            exception.printStackTrace();
        }

    }

    public void OninputRow1Leave(){
        inputRow2.setText(inputRow1.getText());
    }
}
