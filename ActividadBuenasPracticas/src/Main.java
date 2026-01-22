import java.util.Scanner;
//contante para poner un limite minimo a lo introducido por el usuario
public static int VALORES_MINIMOS=0;

//metodo que pide al usuario los valores
void main() {
    int limite;
    try(Scanner sc=new Scanner(System.in)) {
        System.out.print("Dame el numero maximo a sumar(limite)");
        limite=comprobar(sc);
        System.out.println("El resultado de la suma es: "+calcular(limite));
    }
}
//metodo para comprobar que el usuario ingreso un valor valido
//en caso de ser verdadero este hace un return del valor
//valor valido es aquel que no sea ni un caracter y sea MAYOR a 0
//@param sc
//@return variable
public static int comprobar(Scanner sc){
    int variable;
    do {
        while (!sc.hasNextInt()) {
            System.out.println("Introduce el valor correcto");
            sc.next();
        }
        variable = sc.nextInt();
        if(variable<VALORES_MINIMOS){
            System.out.println("Introduce un valor mayor a 0");
        }
    }while (variable<VALORES_MINIMOS);
    return variable;
}
public static int calcular(int limite){
    int sumaNumeros=0;
    int indice;
    for(indice=1;indice<=limite;indice++)
    {
        sumaNumeros+=indice;
    }
    return sumaNumeros;
}
/*
import java.util.Scanner;
public class Main{
public static void main(String[]a){
Scanner sc=new Scanner(System.in);
System.out.print("n:");int n=sc.nextInt();
int s=0;
for(int i=1;i<=n;i++){s+=i;}
System.out.println("r:"+s);
}}
 */
//malas praacticas detectadas
//1.-nombres de variables no Descriptibles
//2.-sin identacion
//3.-lineas juntas/combinadas
//4.-dependencia a main
//5.no tener una "comprobacion" para cuando el numero del usuario sea negativo
//6.-nunca haber cerrado el Scanner leer o utilizar el try en el
//7.-personalmente el no declarar las variables al principio de las funciones
//8.-no tiene documentacion


