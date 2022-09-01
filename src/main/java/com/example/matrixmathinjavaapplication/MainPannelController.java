/**
 *      created double . dont just do random bull hit on git.
 */

package com.example.matrixmathinjavaapplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainPannelController {

    @FXML
    private TextField a11 , a12 , a13 , a21 , a22 , a23 , a31 , a32 , a33;

    @FXML
    private Label heading;


private double[][] controllerXMatrix = new double[3][3];


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



        heading.setText("Determinant is " + " ");








    }
}
