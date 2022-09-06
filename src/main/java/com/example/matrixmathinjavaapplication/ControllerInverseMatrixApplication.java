/**
 *      This class is the controller that contains the methods of our application.
 *
 * METHODS
 *   This class has the following methods
 *       -> void OnClearButtonPress(ActionEvent event); || This is the method of Clear button.
 *              || This method is used to remove inputs from the application.
 *       -> void OnCalculateButtonPress(ActionEvent event); || This is the method of Calculate button.
 *              || This method is used to calculate and put the answer on the screen.
 */

package com.example.matrixmathinjavaapplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControllerInverseMatrixApplication {

    @FXML
    private TextField a11 , a12 , a13 , a21 , a22 , a23 , a31 , a32 , a33;

    @FXML
    private Label heading , ZeroMessagePrompt;


    public void OnClearButtonPress(ActionEvent event){
    // COMPLETE
        heading.setText("Enter your Matrix below");


        a11.clear();
        a12.clear();
        a13.clear();
        a21.clear();
        a22.clear();
        a23.clear();
        a31.clear();
        a32.clear();
        a33.clear();


    } // method OnClearButtonPress() ends here.

    public void OnCalculateButtonPress(ActionEvent event){

       try {
            double[][] controllerXMatrix = new double[][]{
                    {Double.parseDouble(a11.getText()), Double.parseDouble(a12.getText()), Double.parseDouble(a13.getText())},
                    {Double.parseDouble(a21.getText()), Double.parseDouble(a22.getText()), Double.parseDouble(a23.getText())},
                    {Double.parseDouble(a31.getText()), Double.parseDouble(a32.getText()), Double.parseDouble(a33.getText())}
            };


        double[][] controllerXResult;

        InverseMatrix controllerInverseMatrixObject = new InverseMatrix(controllerXMatrix);

        controllerXResult = controllerInverseMatrixObject.main();

        if (controllerInverseMatrixObject.determinantOfMatrix==0) {
            heading.setText("Determinant is " + controllerInverseMatrixObject.determinantOfMatrix);
            ZeroMessagePrompt.setText("as the determinant is zero inverse of this matrix is not possible");
        }
        else {
            heading.setText("Determinant is " + controllerInverseMatrixObject.determinantOfMatrix);
            ZeroMessagePrompt.setText(".");
        }


            a11.setText(String.valueOf(controllerXResult[0][0]));
            a12.setText(String.valueOf(controllerXResult[0][1]));
            a13.setText(String.valueOf(controllerXResult[0][2]));
            a21.setText(String.valueOf(controllerXResult[1][0]));
            a22.setText(String.valueOf(controllerXResult[1][1]));
            a23.setText(String.valueOf(controllerXResult[1][2]));
            a31.setText(String.valueOf(controllerXResult[2][0]));
            a32.setText(String.valueOf(controllerXResult[2][1]));
            a33.setText(String.valueOf(controllerXResult[2][2]));
       } catch (Exception e){

           heading.setText("Please Enter Some Value");

       }

    } // method OnCalculateButtonPress() ends here.
}
