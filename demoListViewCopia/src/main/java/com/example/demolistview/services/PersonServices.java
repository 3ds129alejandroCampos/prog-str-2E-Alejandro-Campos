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
            result.add( name + " - " + email + " - "+edad);
        }
        return result;
    }

    private List<String> getCleanLines()throws  IOException{
        List<String> lines= repo.readAllLines();
        List<String> cleanLines= new ArrayList<>();
        for(String line:lines){
            if(line!=null&&!line.isBlank()){
                cleanLines.add(line);
            }
        }
        return cleanLines;

    }
    public void removePerson(int index)throws IOException{
        if(index<0){
            throw new IllegalArgumentException("indice invalido");
        }
        List<String> data = getCleanLines();
        data.remove(index);
        repo.saveFile(data);

    }
    public void updatePerson(int index,String name,String correo,String edad) throws IOException{
        validate(name,correo,edad);
        if(index<0){
            throw new IllegalArgumentException("indice invalido");
        }
        List<String> data = getCleanLines();

        data.set(index,name+","+correo+","+edad);
        repo.saveFile(data);
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
