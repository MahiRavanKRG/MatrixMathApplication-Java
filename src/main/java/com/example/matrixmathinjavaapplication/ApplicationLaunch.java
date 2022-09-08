/**
 *      This is a simple class with only initializing the program.
 *      Also, this class adds the logo to the project.
 */


package com.example.matrixmathinjavaapplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ApplicationLaunch extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
    //    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InverseMatrixApplication.fxml"));
        // THIS IS THE LOADER FOR INVERSEMATRIXAPPLICATION.

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UDOstart.fxml"));

        Scene sceneX = new Scene(fxmlLoader.load());



        Image logo = new Image("D:\\CODES\\Java\\MatrixMathInJavaApplication\\src\\Images\\MainLogo.png");
        primaryStage.getIcons().add(logo);

        primaryStage.setTitle("ApplicationX");
        primaryStage.setScene(sceneX);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
