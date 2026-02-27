module com.example.correo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.correo to javafx.fxml;
    exports com.example.correo;
}