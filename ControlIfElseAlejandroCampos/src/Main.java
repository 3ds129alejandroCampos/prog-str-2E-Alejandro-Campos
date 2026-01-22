//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
void main() {
    int edad=0;
    int tarifa=0;
    boolean esEstudiante;
    String estudiante;

    Scanner leer = new Scanner(System.in);

    System.out.println("Dame tu edad");
    edad=leer.nextInt();

    leer.nextLine();




    if(edad>=0&&edad<120) {
        System.out.println("¿Eres estudiante? true/false");
        estudiante= leer.nextLine();
        esEstudiante=asignacionFalsoVerdadero(estudiante);
        tarifa=evaluar(edad,leer,esEstudiante);
        System.out.println("Edad: "+edad);
        System.out.println("tarifa: "+tarifa);
        System.out.println("Es estudiante: "+esEstudiante);

    }
    else{
        System.out.println("Edad invalida");
    }

}
public static boolean asignacionFalsoVerdadero(String estudiante){
    boolean op;
    op=estudiante.equalsIgnoreCase("true");

    return op;
}
public static int evaluar(int edad,Scanner leer,boolean esEstudiante){
    int tarifa=0;

    if(edad<12){
        tarifa=50;
    }
    if(edad>=12&&edad<=17){
        if(esEstudiante){
            tarifa=60;
        }
        else{
            tarifa=80;
        }

    }
    if(edad>18){
        if(esEstudiante){
            tarifa=90;
        }
        else{
            tarifa=120;
        }
    }
    return tarifa;
}
