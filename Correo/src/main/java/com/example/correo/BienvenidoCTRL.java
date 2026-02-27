package com.example.correo;
import javafx.scene.control.Label;
import javafx.fxml.FXML;



public class BienvenidoCTRL {

    @FXML
    private Label mensaje;

    public void establecerMSG(String correo){
        mensaje.setText("Bienvenido\n"+correo);
    }
}
