package com.example.demo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class FormController {
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtEdad;
    @FXML
    private Label lblValidation;

    public void onValidation(ActionEvent event){
        String correo=txtCorreo.getText() == null ? "" : txtCorreo.getText();
        String edad=txtEdad.getText() == null ? "" : txtEdad.getText();

        List<String> errores = new ArrayList<>();

        if(correo.trim().isEmpty()|| !correo.contains("@")|| !correo.contains(".")){
            errores.add("correo incorrecto");
        }
        int age=0;
        try {
           age=Integer.parseInt(edad);
           if(age<0|| age>=120){
               errores.add("Edad invalida");
           }
        }catch (Exception e){
            errores.add("Dato invalido");
        }
        if(errores.isEmpty()){
            lblValidation.setText("Datos correctos");
            lblValidation.setStyle("-fx-text-fill: green");
        }
        else {
            String erroresUsuario="";
            for(String e:errores){
                erroresUsuario+=e;
            }
            lblValidation.setText(erroresUsuario);
            lblValidation.setStyle("-fx-text-fill: red");
        }

    }
}
