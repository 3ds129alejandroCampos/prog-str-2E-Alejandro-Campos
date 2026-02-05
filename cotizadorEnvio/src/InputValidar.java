import java.util.Scanner;

public class InputValidar {
    public static double leerDoubleEnRango(Scanner sc, String mensaje,double RANGOMIN,int RANGOMAXSINEXTRAS){
        double kg;
        System.out.println(mensaje);
        while(true){
            if (sc.hasNextDouble()){
                kg=sc.nextDouble();
                if(kg>=RANGOMIN&&kg<=RANGOMAXSINEXTRAS){
                    return kg;
                }
                else{
                    System.out.println("el peso del paquete tiene que ir de .1 kg a 50 kg");
                }
            }
            else{
                System.out.println("dame un valor decimal");
            }
            sc.nextLine();
        }
    }
    public static int leerIntKM(Scanner sc, String mensaje,int DISTANCIAMAX,int DISTANCIAMIN){
        int km;
        if (sc.hasNextLine()) {
            sc.nextLine();
        }
        System.out.println(mensaje);
        while (true){
            if(sc.hasNextInt()){
                km=sc.nextInt();
                if(km>=DISTANCIAMIN&&km<=DISTANCIAMAX){
                    return  km;
                }
                else{
                    System.out.println("el rango es de 1 a 2000(numero introducido invalido)");
                }
            }
            else{
                System.out.println("dame un valor numerico");
            }
            sc.nextLine();
        }
    }
    public int tipoDeServicio(Scanner sc,String mensaje){
        int tiposServicio;
        String op;
        if (sc.hasNextLine()) {
            sc.nextLine();
        }

            while(true) {
                System.out.println(mensaje);
                System.out.println("1.-Estandar");
                System.out.println("2.-Express");
                op=sc.nextLine();
                switch (op) {
                    case "1":
                        tiposServicio=1;
                        return tiposServicio;
                    case "2":
                        tiposServicio=2;
                        return tiposServicio;
                    default:
                        System.out.println("Dame una opcion 1-2");
                }
            }
    }
    public boolean zonaRemota(Scanner sc,String mensaje){
        boolean remoto;
        String op;

        while(true) {
            System.out.println(mensaje);
            System.out.println("1.-si");
            System.out.println("2.-no");
            op=sc.nextLine();
            switch (op) {
                case "1":
                    remoto=true;
                    return remoto;
                case "2":
                    remoto=false;
                    return remoto;
                default:
                    System.out.println("Dame una opcion 1-2");
            }
        }


    }
}
