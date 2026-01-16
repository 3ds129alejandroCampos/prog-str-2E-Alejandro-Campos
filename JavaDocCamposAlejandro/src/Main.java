//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public static double CLASIFICACION_BAJA=18.5;
public static double CLASIFICACION_MEDIA=25;
public static double CLASIFICACION_ALTA=30;
public static int EQUIVALENCIA_FARENHEIT=32;
public static double FARENHEIT_MULTIPLICAS=1.8;
public static double PI=3.1416;
//clase main donde el usuario introdiuce la opcion del 1-5 siendo la 5 la salida del programa
//cada llamada de clase se lleva consigo misma a +leer+ variable scanner
void main() {
    int opc;
    Scanner leer= new Scanner(System.in);

    do {
        System.out.println("Opciones");
        System.out.println("1-IMC");
        System.out.println("2-Area de un rectangulo");
        System.out.println("3-Convertir centrigrados a farenheit");
        System.out.println("4-Area de un circulo");
        System.out.println("5-salir");
        System.out.println("opcion: ");

        opc=leer.nextInt();

        switch (opc){
            case 1 -> {calcularIMC(leer);
            }
            case 2 -> {calcularArea(leer);}
            case 3 -> {calcularGrados(leer);}
            case 4 -> {calcularCirculo(leer);}
            default -> System.out.println("opcion invalida");
        }
    }while (opc!=5);
}
//metodo para comprobar/saber en que clasificacion entra del IMC
//@param IMC previamente calculado en calcularIMC
public static String comprobarImc(double IMC){
    if (IMC < CLASIFICACION_BAJA) return "Peso Bajo";
    else if (IMC < CLASIFICACION_MEDIA) return"medio";
    else if (IMC < CLASIFICACION_ALTA) return"Sobre peso";
    else return"Obesidad";
}
//metodo para comprobar que el usuario esta introduciendo un caracter o un digito si es asi lo retorna
//en caso de este ser un digito volvera a pedir al usuario introducir un valor
//@return double
//@param leer es un parametro de scanner
public static double datos(Scanner leer){
    double variable;
    while(!leer.hasNextDouble()){
        System.out.println("Introduce un valor valido");
        leer.next();
    }
    variable= leer.nextDouble();
    return variable;
}
//metodo para calcular el IMC de una persona (peso/estatura^2)
//@param leer es un parametro de scanner
public static void calcularIMC(Scanner leer){

        System.out.println("Dame tu pesso en kg");
        double peso = datos(leer);
        System.out.println("Dame tu estatura en metros");
        double estatura = datos(leer);

        double IMC = peso / (estatura * estatura);

        System.out.printf(comprobarImc(IMC)+": %.1f\n",IMC);

}
//metodo para calcular el area de un rectangulo (b*h)
//@param leer es un parametro de scanner
public static void calcularArea(Scanner leer){
    System.out.println("Dame la base");
    double base= datos(leer);
    System.out.println("Dame la altura");
    double altura=datos(leer);

    double area=base*altura;
    System.out.println("Base total: "+area);
}
//metodo para convertir grados centigrados a farenheit (centrigrados*1.8)+32
//@param leer es un parametro de scanner
public static void calcularGrados(Scanner leer){
    System.out.println("Dame los grados a convertir(centrigrados)");
    double c = datos(leer);
    double f=(c*FARENHEIT_MULTIPLICAS)+EQUIVALENCIA_FARENHEIT;
    System.out.printf("Farenheit: %.1f\n",f);

}
//metodo para calcular el area de un circulo (r^2*pi)
//@param leer es un parametro de scanner
public static void calcularCirculo(Scanner leer){
    System.out.println("Dame el radio del circulo");
    double radio= datos(leer);
    double area=(radio*radio)*PI;
    System.out.println("EL area total:"+area);

}

