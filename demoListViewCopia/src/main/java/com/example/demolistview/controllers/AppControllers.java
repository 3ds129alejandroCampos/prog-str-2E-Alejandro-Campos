package com.example.demolistview.controllers;
import javafx.beans.Observable;
import com.example.demolistview.services.PersonServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

import java.util.List;

public class AppControllers {
    @FXML
    private TextField txtName;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtEdad;

    @FXML
    private Label lblMsg;

    @FXML
    private ListView<String> listView;

    @FXML
    private ObservableList<String> data= FXCollections.observableArrayList();

    @FXML
    public void initialize(){
        loadFromFile();
        listView.getSelectionModel().selectedItemProperty().addListener(
                (obs,oldValue,newValue)->{
                    loadDataToForm(newValue);
                }
        );
        listView.setItems(data);
    }

    @FXML
    public void onReloaded(){
        loadFromFile();
    }

    @FXML
    public void onAdd(){
        try{
            String name = txtName.getText();
            String email=txtEmail.getText();
            String edad=txtEdad.getText();
            service.addPerson(name,email,edad);
            lblMsg.setText("Creado con EXITO");
            txtName.clear();
            txtEmail.clear();
            txtEdad.clear();
            loadFromFile();
        }catch (IOException e){
            lblMsg.setText("Eror en el archivo");
        }catch (IllegalArgumentException e){
            lblMsg.setText("Error con los datos : "+e.getMessage());
        }

    }
    @FXML
    public void onUpdate(){
        try{
            int index = listView.getSelectionModel().getSelectedIndex();
            String name = txtName.getText();
            String email=txtEmail.getText();
            String edad=txtEdad.getText();
            service.updatePerson(index,name,email,edad);
            lblMsg.setText("Creado con EXITO");
            txtName.clear();
            txtEmail.clear();
            txtEdad.clear();
            loadFromFile();
        }catch (IOException e){
            lblMsg.setText("Eror en el archivo");
        }catch (IllegalArgumentException e){
            lblMsg.setText("Error con los datos : "+e.getMessage());
        }

    }

    @FXML
    public void onRemove(){
        try {
            int index = listView.getSelectionModel().getSelectedIndex();
            service.removePerson(index);
            loadFromFile();

        }catch (IOException e) {
            lblMsg.setText("Eror en el archivo");
        }
        catch (IllegalArgumentException e){
            lblMsg.setText("Error con los datos : "+e.getMessage());
        }
    }

    private PersonServices service = new PersonServices();

    private void loadFromFile(){
        try {
            List<String> items=service.loadDataForListView();
            data.setAll(items);
            lblMsg.setText("Todo bien");
        }catch (IOException e){
            lblMsg.setText("Error");
        }

    }

    private void loadDataToForm(String data){
        String[] parts = data.split(" - ");
        txtName.setText(parts[0]);
        txtEmail.setText(parts[1]);
        txtEdad.setText(parts[2]);
    }
}
