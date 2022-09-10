/**
 *      This class has all the required input fxml rom the fxml file.
 *      Now need to make the methods and add.
 *
 *
 *      I think of implementing this in steps,
 *          step 1: add extra requirements to the fxml file of InverseMatrixApplication. DONE
 *          step 2: test for one operation of multiplication, the chosen operation is row multiplication. working
 *          step 3: add the rest of the elements to the fxml file and add proper methods and finish.
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
    private TextField inputRow , inputVar;

    @FXML
    private Button Calculate , Determinant;

    public void OnCalculateButtonPress(){
        try {
            double[][] controllerUDOMatrix = new double[][]{
                    {Double.parseDouble(a11.getText()), Double.parseDouble(a12.getText()), Double.parseDouble(a13.getText())},
                    {Double.parseDouble(a21.getText()), Double.parseDouble(a22.getText()), Double.parseDouble(a23.getText())},
                    {Double.parseDouble(a31.getText()), Double.parseDouble(a32.getText()), Double.parseDouble(a33.getText())}
            };

            var inputMulVar = Double.parseDouble(inputVar.getText());
            var inputRowVar = Integer.parseInt(inputRow.getText());

            Matrix controllerUDOMatrixObject = new Matrix(controllerUDOMatrix);

            controllerUDOMatrixObject.rowMultiplication( controllerUDOMatrixObject.matrix[0] , inputMulVar );

            a11.setText(String.valueOf(controllerUDOMatrixObject.matrix[0][0]));
            a12.setText(String.valueOf(controllerUDOMatrixObject.matrix[0][1]));
            a13.setText(String.valueOf(controllerUDOMatrixObject.matrix[0][2]));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void OnDeterminantButtonPress(){

    }
}
