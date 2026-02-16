import java.util.Scanner;
void main() {
    String opc;


    Process process=new Process();
    Alumnos[] alumnos=new Alumnos[25];
    Validator validator=new Validator();
    Scanner sc=new Scanner(System.in);

    do {
        System.out.println("-----Menu-----");
        System.out.println("1-Alta de alumnos");
        System.out.println("2-Buscar ID");
        System.out.println("3-Actualizar promedio");
        System.out.println("4-Baja logica");
        System.out.println("5-Lista de Alumnos");
        System.out.println("6-Reportes");
        System.out.println("0-Salir");
        opc=sc.nextLine();

        process.choose(sc,opc,alumnos,validator);

    }while (!opc.equalsIgnoreCase("0"));




}
