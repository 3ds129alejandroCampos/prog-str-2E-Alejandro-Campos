import java.util.Scanner;

public class Process {
    public void choose(Scanner sc,String opc,Alumnos[] alumnos,Validator validator){
        switch (opc){
            case "1"->
                addStudent(sc,alumnos,validator);

            case "2"->
                searcher(sc,alumnos);

            case "3"->
                updateAverage(sc,validator,alumnos);

            case "4"->
                softDeleted(alumnos,sc);

            case "5"->registration(alumnos);
            case "6"->report(alumnos);
            case "0"-> System.out.println("adios");
            default -> System.out.println("opcion invalida");
        }
    }
    private void addStudent(Scanner sc,Alumnos[] alumnos,Validator validator){
        int id=validator.correctID(sc,alumnos,"Dame el id");
        String name=validator.CorrectName(sc);
        double promedio= validator.average(sc,"Dame el promedio");

        Alumnos a1= new Alumnos(id,name,promedio,true);
        int index= a1.increaseIndex();

        if(index<25){
            alumnos[index]=a1;
        }else {
            System.out.println("centro de datos lleno ");
        }

    }
    private  void searcher(Scanner sc,Alumnos[] alumnos){
        Alumnos a1 = sercherStudent(alumnos,sc,"Dame el id a buscar");
        if(a1!=null) {
            System.out.println("--------");
            System.out.println("Alumno: " + a1.getName());
            System.out.println("Promedio: " + a1.getPromedio());
            System.out.println("--------");
        }
    }
    private  void updateAverage(Scanner sc,Validator validator,Alumnos[] alumnos){
       Alumnos a1 =sercherStudent(alumnos,sc,"Dame el id a para actualizar");
        System.out.println("Calificacion anterior: "+a1.getPromedio());
       double average= validator.average(sc,"Calificacion actualizada:");

       a1.setPromedio(average);

    }
    private Alumnos sercherStudent(Alumnos[] alumnos,Scanner sc,String msg){
        String change;
        int id;
        while(true) {
            try {
                System.out.println(msg);
                change = sc.nextLine();
                id=Integer.parseInt(change);
                for (Alumnos a1:alumnos){
                    if(a1!=null&&id==a1.getId()&&a1.isActivo()){
                        return a1;
                    }
                    else {
                        System.out.println("id no encontrado");
                        return null;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("no puede haber id con digitos no numericos");
            }
        }
    }
    private void softDeleted(Alumnos[] alumnos,Scanner sc){
        String opc;
        Alumnos a1 =sercherStudent(alumnos,sc,"Dame el id a para borrar");
        System.out.println("¿Estas seguro que quieres borrar este alumno?S/N");
        opc=sc.nextLine();
        if(opc.equalsIgnoreCase("s")){
            a1.setActivo(false);
        }
    }
    private void registration(Alumnos[] alumnos){
        for (Alumnos a:alumnos){
            if(a!=null&&a.isActivo()){
                System.out.println("--------");
                System.out.println("id: "+a.getId());
                System.out.println("nombre: "+a.getName());
                System.out.println("promedio: "+a.getPromedio());
            }else {
                break;
            }
        }
    }
    private void report(Alumnos[] alumnos){
       double average=0;
       Alumnos highest=null;
       Alumnos lower=null;
       int cont=0;
       int alive=0;
       double averageGroup=0;

       for (Alumnos a: alumnos){
           if(a!=null&&a.isActivo()) {
               if (highest == null || a.getPromedio() > highest.getPromedio()) {
                   highest = a;
               }
               if (lower == null || a.getPromedio() < lower.getPromedio()) {
                   lower = a;
               }
               if (a.getPromedio() >= 8) {
                   cont++;
               }
               alive++;
               averageGroup=averageGroup +a.getPromedio();
           }
       }
       if(alive>0) {
           averageGroup=averageGroup/alive;
           System.out.println("Mayor promedio: " + highest.getName() + " promedio:" + highest.getPromedio() + " id:" + highest.getId());
           System.out.println("Menor promedio: " + lower.getName() + " promedio:" + lower.getPromedio() + " id:" + lower.getId());
           System.out.println("Numero de alumnos con promedio mayor a 8:" + cont);
           System.out.println("Promedio: "+averageGroup);
       }
    }
}
