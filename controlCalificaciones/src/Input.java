import java.util.Scanner;

public class Input {
    public static String obtenerNombre(Scanner sc, String mensaje){
        String name;
        System.out.println(mensaje);
        while(true){
            if(sc.hasNextLine()){
                name=sc.nextLine();
                if(!name.isBlank()){
                    return name;
                }
                else{
                    System.out.println("introduce un dato");
                }
            }
        }
    }

    public double obtenerCalificaciones(Scanner sc,String mensaje) {
        double num;
        System.out.println(mensaje);
        while (true){
            if(sc.hasNextDouble()){
                num= sc.nextDouble();
                if(num>=0&&num<=100){
                  return num;
                }
                System.out.println("dame un valor de 0-10");
            }
            System.out.println("dame un valor numerico");
            sc.nextLine();
        }
    }

    public int obtenerAsistenciaTotal(Scanner sc,String mensaje) {
        int asistTotal;
        System.out.println(mensaje);
        while (true){
            if (sc.hasNextInt()){
                asistTotal = sc.nextInt();
                if(asistTotal>=0&&asistTotal<=100) {
                    return asistTotal;
                }
                System.out.println("Dame un numero valido del 0-100");
            }
            System.out.println("Dame un numero no decimal");
        }
    }


    public boolean proyecto(Scanner sc,String mensaje) {
        String decision;
        if(sc.hasNextLine()){
            sc.nextLine();
        }
        System.out.println(mensaje);
        while (true){
            decision=sc.nextLine();
            if(decision.equalsIgnoreCase("si")){
                return true;
            }
            if (decision.equalsIgnoreCase("no")){
                return false;
            }
            System.out.println("escribe si o no");
        }
    }
}
