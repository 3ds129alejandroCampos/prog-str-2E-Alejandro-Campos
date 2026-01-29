//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.Random;

public static int intentosMax=7;
public static int numeroMax=100;
public static int numeroMin=1;
public static int valorNumInvalido=0;
public static int caracterInvalido=0;

void main() {
  int intentos,num;
  boolean gano=false;
  Random numRandom = new Random();

  Scanner sc= new Scanner(System.in);

  intentos=0;

  int secreto= numRandom.nextInt(numeroMax)+numeroMin;

    System.out.println("Bienvenido tienes 7 intentos para adivinar el numero");

    while(!gano){
        System.out.println("Dame un numero");
        num=comprobacion(sc);
        if(num==secreto){
            System.out.println("felicidades ganaste en el intento "+intentos);
            gano=true;
            break;
        }
        else {
            System.out.println(evaluar(num,secreto));
            intentos++;
        }
        if(intentos>=7){
            System.out.println("limite de intentos alcanzado");
            System.out.println("el numero a adivinar era"+secreto);
            break;
        }
        if(gano){
            System.out.println("felicidades ganaste en el intento "+intentos);
        }

    }

    System.out.println("valores fuera de rango "+valorNumInvalido);
    System.out.println("caracteres invalidos: "+caracterInvalido);


}
public static String evaluar(int num,int secreto){
    if(num<secreto){
        return "el numero es mayor";
    }
    else{
        return "el numero es menor";
    }
}


public static int comprobacion(Scanner sc){
    int numero;
    while (true){
        if(sc.hasNextInt()){
            numero = sc.nextInt();
            if(numero>=numeroMin&&numero<=numeroMax) {
                return numero;
            }
            else {
                System.out.println("introduce un valor que este entre el 1 y el 100");
                valorNumInvalido++;
            }
        }
        else {
            System.out.println("Dame un valor entero");
            caracterInvalido++;
            sc.next();
        }

    }
}
