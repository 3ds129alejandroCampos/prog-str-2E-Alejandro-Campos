//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;



void main() {
    Personas[] personas=new Personas[20];
    Scanner sc=new Scanner(System.in);
    Proceso proceso = new Proceso();
    String opc;
    do {
        System.out.println("-----MENU-----");
        System.out.println("1-Alta");
        System.out.println("2-Buscar por ID");
        System.out.println("3-Baja logica por ID");
        System.out.println("4-Lista activa");
        System.out.println("5-Actualizar nombre por ID");
        System.out.println("0-Salir");
        opc = sc.nextLine();
        proceso.elige(personas,sc,opc);
    }while (!opc.equalsIgnoreCase("0"));

}
