import java.util.Scanner;

public class Validator {
    public int correctID(Scanner sc,Alumnos[] alumnos,String msg){

        String change;
        int id;
        while (true) {
            boolean repeatedId=false;
            try {
                System.out.println(msg);
                change=sc.nextLine();
                id=Integer.parseInt(change);
                if(id>0){
                    for (Alumnos a:alumnos){
                        if(a!=null&&id==a.getId()){
                            repeatedId=true;
                            break;
                        }
                        if(a==null){
                            break;
                        }
                    }
                    if(repeatedId){
                        System.out.println("Id repetido");
                    }
                    else {
                        return id;
                    }

                }
                else {
                    System.out.println("no puede haber id de 0");
                }
            }catch (NumberFormatException e){
                System.out.println("Este dato no es un numero");
            }


        }
    }
    public  String CorrectName(Scanner sc){
        String name;
        while (true) {
            System.out.println("Dame el nombre");
            name = sc.nextLine();
            if(name.isBlank()){
                System.out.println("Nombre invalido");
            }else {
                return name;
            }
        }

    }
    public double average(Scanner sc,String msg){
        double average;
        String change;
        while (true){
            try {
                System.out.println(msg);
                change=sc.nextLine();
                average=Double.parseDouble(change);
                if(average>=0&&average<=10){
                    return average;
                }
                else{
                    System.out.println("Dato fuera de rango");
                }
            }catch (NumberFormatException e){
                System.out.println("Dato invalido");
            }
        }

    }

}
