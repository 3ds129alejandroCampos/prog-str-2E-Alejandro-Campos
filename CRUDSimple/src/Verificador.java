import java.util.Scanner;

public class Verificador {


    public int idCorrecto(Scanner sc,Personas[] personas){
        int id;
        boolean estaRepetido;
        String validador;
        while (true){
            try {
                estaRepetido=false;
                System.out.println("Dame el id");
                validador= sc.nextLine();
                id=Integer.parseInt(validador);
                if(id>0){
                    for(Personas p: personas){
                        if(!(p==null)&&id==p.getId()){
                            estaRepetido=true;
                            break;
                        }
                    }
                    if(estaRepetido){
                        System.out.println("Este id esta repetido");
                    }
                    else {
                        return id;
                    }
                }
                else{
                    System.out.println("Dame un numero mayor a 0");
                }
            }catch (NumberFormatException e) {
                System.out.println("Dame un valor numerico entero");
            }
        }
    }

    public String nombreCorrecto(Scanner sc){
        String name;
        while(true){
            System.out.println("Dame tu nombre");
            name=sc.nextLine();
            if (!name.isBlank()){
                return name;
            }
            else{
                System.out.println("nombre sin caracteres");
            }

        }
    }
}
