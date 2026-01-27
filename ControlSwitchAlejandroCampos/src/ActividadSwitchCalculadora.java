import java.util.Scanner;
public class ActividadSwitchCalculadora {
    static void main() {
        double variableA,variableB,resultado;
        int opcion;
        String operador;

        Scanner leer=new Scanner(System.in);

        System.out.println("Dame el valor 1");
        variableA= leer.nextDouble();

        System.out.println("Dame el valor 2");
        variableB=leer.nextDouble();

        System.out.println("main");

        System.out.println("Menu");
        System.out.println("1-Sumar");
        System.out.println("2-Restar");
        System.out.println("3-multiplicar");
        System.out.println("4-Dividir");
        opcion=leer.nextInt();
        operador=numeroAOpcion(opcion);
        switch (opcion){
            case 1:
                resultado=suma(variableA,variableB);
                imprimir(variableA,variableB,resultado,operador);
                break;
            case 2:
                resultado=resta(variableA,variableB);
                imprimir(variableA,variableB,resultado,operador);
                break;
            case 3:
                resultado=multiplicacion(variableA,variableB);
                imprimir(variableA,variableB,resultado,operador);
                break;
            case 4:
                if(!entreCero(variableB)){
                    resultado=division(variableA,variableB);
                    imprimir(variableA,variableB,resultado,operador);
                }
                else{
                    System.out.println("no se puede dividir entre 0");

                }
                break;
            default:
                System.out.println("elige una opcion valida");
        }

    }
    public static double suma(double a,double b){
        return a+b;
    }
    public static double resta(double a,double b){
    return a-b;
    }
    public static double multiplicacion(double a,double b){
        return a*b;
    }
    public static double division(double a,double b){
        return a/b;
    }
    public static boolean entreCero(double b){
        return b==0;
    }
    public static String numeroAOpcion(int opcion){
        switch(opcion){
            case 1:
                return "+";
            case 2:
                return "-";
            case 3:
                return "x";
            case 4:
                return "/";
            default:
                return "opcion invalida";
        }
    }

    public static void imprimir(double variableA,double variableB,double resultado,String operador) {
        System.out.println(variableA+" "+operador+" "+variableB+" = "+resultado);
    }
}

