import java.util.Scanner;

public class Proceso {
    public void alta(Personas[] personas,Scanner sc){
        String name;
        int id;
        boolean isActive;

        Verificador verifica=new Verificador();

        name= verifica.nombreCorrecto(sc);
        id=verifica.idCorrecto(sc,personas);
        isActive=true;

        Personas p1 = new Personas(name,id,isActive);
        int indice=p1.aumentarIndice();
        personas[indice]=p1;
    }

    public Personas buscador(Personas [] personas,int id){
        for(Personas p: personas){
            if(!(p==null)&&id==p.getId()){
                return p;
            }
        }
        return null;
    }
    public void bajaLogica(Personas[] personas,Scanner sc){
        int id;
        String convertir;
        while (true) {
            try {
                System.out.println("Dame el id para dar de baja");
                convertir = sc.nextLine();
                id=Integer.parseInt(convertir);
                Personas encontrada= buscador(personas,id);
                if(encontrada!=null){
                    encontrada.setActive(false);
                }
                else {
                    System.out.println("id no encontrado");
                }

            } catch (NumberFormatException e) {
                System.out.println("Dame un valor numerico entero");
            }
        }
    }

}
