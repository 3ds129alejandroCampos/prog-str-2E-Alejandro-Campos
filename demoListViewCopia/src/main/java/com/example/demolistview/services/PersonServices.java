package com.example.demolistview.services;

import com.example.demolistview.repositories.PersonsFileRepositories;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonServices {
    PersonsFileRepositories repo = new PersonsFileRepositories();

    public List<String> loadDataForListView()throws IOException {
        List<String> lineas = repo.readAllLines();
        List<String> result=new ArrayList<>();


        for (String line: lineas){
            if(line==null||line.isBlank()) continue;
            String[] parts = line.split(",");
            String name = parts[0];
            String email = parts[1];
            String edad = parts[2];
            result.add("nombre: " + name + " - " + email + "-"+"Edad: "+edad);
        }
        return result;
    }

    public void addPerson(String name,String email,String edad) throws IOException{
        validate(name,email,edad);
        repo.appendNew(name+","+email+","+edad);
    }

    private void validate(String name,String email,String edad){
        if(name==null||name.isBlank()||name.length()<3){
            throw new IllegalArgumentException("El nombre es incorrecto");
        }
        String em= (email==null) ? "" : email.trim();
        if(em.isBlank()||!em.contains("@")||!em.contains(".")){
            throw new IllegalArgumentException("Email incorrecto");
        }
        String ed= (edad==null) ? "" : edad.trim();
        if(ed.isBlank()||!(ed.matches("\\d+"))||(Integer.parseInt(edad)<=17)||(Integer.parseInt(edad)>=120)){
            throw new IllegalArgumentException("Edad invalida");
        }


    }
}
