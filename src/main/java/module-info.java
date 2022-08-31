module com.example.matrixmathinjavaapplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.matrixmathinjavaapplication to javafx.fxml;
    exports com.example.matrixmathinjavaapplication;
}