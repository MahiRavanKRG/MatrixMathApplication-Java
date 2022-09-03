/**
 *      created double . don't just do random bull shit on git.
 */

package com.example.matrixmathinjavaapplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControllerMainPanel {

    @FXML
    private TextField a11 , a12 , a13 , a21 , a22 , a23 , a31 , a32 , a33;

    @FXML
    private Label heading;


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


    } // method OnClearButtonPress() ends here

    public void OnCalculateButtonPress(ActionEvent event){
        double[][] controllerXMatrix = new double[][]{
                {Integer.parseInt(a11.getText()), Integer.parseInt(a12.getText()), Integer.parseInt(a12.getText())},
                {Integer.parseInt(a21.getText()), Integer.parseInt(a21.getText()), Integer.parseInt(a21.getText())},
                {Integer.parseInt(a31.getText()), Integer.parseInt(a31.getText()), Integer.parseInt(a31.getText())}
        };

        double[][] controllerXResult;

        InverseMatrix controllerInverseMatrixObject = new InverseMatrix(controllerXMatrix);

        controllerXResult = controllerInverseMatrixObject.main();

        heading.setText("Determinant is " + controllerInverseMatrixObject.determinantOfMatrix);

        if (controllerInverseMatrixObject.determinantOfMatrix==0)
        {
            a11.setText("9");
            a12.setText("9");
            a13.setText("9");
            a21.setText("9");
            a22.setText("9");
            a23.setText("9");
            a31.setText("9");
            a32.setText("9");
            a33.setText("9");
        }
        else
        {
            a11.setText(String.valueOf(controllerXResult[0][0]));
            a12.setText(String.valueOf(controllerXResult[0][1]));
            a13.setText(String.valueOf(controllerXResult[0][2]));
            a21.setText(String.valueOf(controllerXResult[1][0]));
            a22.setText(String.valueOf(controllerXResult[1][1]));
            a23.setText(String.valueOf(controllerXResult[1][2]));
            a31.setText(String.valueOf(controllerXResult[2][0]));
            a32.setText(String.valueOf(controllerXResult[2][1]));
            a33.setText(String.valueOf(controllerXResult[2][2]));
        }






    }
}
