/**
 *      This is a simple class with only initializing the program.
 *      Also, this class adds the logo to the project.
 *
 *      Here the application has only one start point and if you want
 *       a new application then you have to change the FXMLLoader.
 *
 *       ## So here are some of my notes to the user of this program
 *       ## I have made the applications as separate pieces of codes, any one application has 3 parts
 *            1. GUI which you can find as .fxml file
 *            2. Controller, the fxml file only has GUI and no functionality or code, the Controller file carries the code and the functions of any application
 *            3. Finally, you need to execute it in order for it to run, this can be done in this class
 *       #W So whoever you are look into what you need to change nad focus on that particular file.
 */

/*   This is simple git commit with push
        another commit test
* */
package com.example.matrixmathinjavaapplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ApplicationLaunch extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InverseMatrixApplication.fxml"));

        Scene sceneX = new Scene(fxmlLoader.load());

        Image logo = new Image("D:\\CODES\\Java\\MatrixMathInJavaApplication\\src\\Images\\MainLogo.png");
        primaryStage.getIcons().add(logo);
        // this is used to add logo

//        String styleCSSfileAddress = getClass().getResource("style.css").toExternalForm();
//        sceneX.getStylesheets().add(styleCSSfileAddress);
//        // This is used to add CSS


        primaryStage.setTitle("ApplicationX");
        primaryStage.setScene(sceneX);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
