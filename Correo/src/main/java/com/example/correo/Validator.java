package com.example.correo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Validator {
    @FXML
    private TextField txtContrasena;
    @FXML
    private TextField txtCorreo;
    @FXML
    private Label lblErrores;

    @FXML
    protected void onValidator(){
        String contrasena = txtContrasena.getText();
        String correo = txtCorreo.getText();
        String errores="";

        if (correo.length()<4){
            errores+="correo tiene que contener al menos 4 caracteres\n";
        }
        if (!correo.contains("@")&&!correo.contains(".")){
           errores+="El correo debe contener un (@) y un (.)\n";
        }
        if (contrasena.length()<6){
            errores+="contraseña invalida debe contener minimo 6 caracteres\n";
        }
        if (!errores.isEmpty()){
            lblErrores.setTextFill(Color.RED);
            lblErrores.setText(errores);
        }
        else {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(Start.class.getResource("welcome-view.fxml"));
                Parent root = fxmlLoader.load();
                javafx.stage.Stage stage = (javafx.stage.Stage) txtCorreo.getScene().getWindow();
                Scene scene = new Scene(root, 600, 600);
                stage.setTitle("Bienvenido");
                stage.setScene(scene);
                stage.show();
            }catch (Exception e){
                lblErrores.setText("Error al cargar ventana");
            }
        }


    }
}
