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
            result.add("nombre: " + name + " - " + email);
        }
        return result;
    }

    public void addPerson(String name,String email) throws IOException{
        validate(name,email);
        repo.appendNew(name+","+email);
    }

    private void validate(String name,String email){
        if(name==null||name.isBlank()||name.length()<3){
            throw new IllegalArgumentException("El nombre es incorrecto");
        }
        String em= (email==null) ? "" : email.trim();
        if(em.isBlank()||!em.contains("@")||!em.contains(".")){
            throw new IllegalArgumentException("Email incorrecto");
        }

    }
}
