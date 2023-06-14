module com.example.denvertour {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.denvertour to javafx.fxml;
    exports com.example.denvertour;
}