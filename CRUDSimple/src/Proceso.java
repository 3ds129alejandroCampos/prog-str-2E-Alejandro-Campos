import java.util.Scanner;

public class Proceso {
    public void elige(Personas[] personas,Scanner sc,String opc){
        switch (opc) {
            case "1" -> alta(personas,sc);

            case "2" -> busquedaID(personas,sc);

            case "3" -> bajaLogica(personas,sc);

            case "4" -> lista(personas);

            case "5" -> acutualizarName(personas,sc);

            case "0"-> System.out.println("chao");
            default -> System.out.println("Opcion invalida");

        }
    }
    private void alta(Personas[] personas,Scanner sc){
        String name;
        int id;

        Verificador verifica=new Verificador();

        name= verifica.nombreCorrecto(sc);
        id=verifica.idCorrecto(sc,personas);

        Personas p1 = new Personas(name,id);
        int indice=p1.aumentarIndice();
        if(indice<20) {
            personas[indice] = p1;
        }
        else {
            System.out.println("espacio lleno");
        }
    }

    private Personas buscador(Personas [] personas,Scanner sc,String msg){
        int id;
        String convertir;
        while(true) {
            try {
                System.out.println(msg);
                convertir = sc.nextLine();
                id=Integer.parseInt(convertir);
                for(Personas p:personas){
                    if(!(p==null)&&id==p.getId()&& p.isActive()){
                        return p;
                    }
                }
                return null;
            } catch (NumberFormatException e) {
                System.out.println("Dame un valor numerico entero");
            }
        }
    }
    private void bajaLogica(Personas[] personas,Scanner sc){
        while(true) {
            Personas encontrada= buscador(personas, sc, "Dame el id a dar de baja");
            if(encontrada!=null){
                encontrada.setActive(false);
                break;
            }else{
                System.out.println("id no encontrado");
            }
        }
    }
    private void busquedaID(Personas[] personas,Scanner sc){
        while(true) {
            Personas encontrada= buscador(personas, sc, "Dame el id a dar a buscar");
            if(encontrada!=null){
                System.out.println(encontrada.getName());
                System.out.println(encontrada.getId());
                System.out.println("Esta activo: "+(encontrada.isActive() ? "si":"no"));
                break;

            }else{
                System.out.println("id no encontrado");
            }
        }
    }
    private void lista(Personas[] personas){
        for(Personas p:personas){
            if(p!=null&&p.isActive()){
                System.out.println("-------------");
                System.out.println(p.getId());
                System.out.println(p.getName());
                System.out.println("-------------");
            }
        }

    }
    private void acutualizarName(Personas[] personas,Scanner sc){
        String name;
        while(true) {
            Personas encontrada= buscador(personas, sc, "Dame el id a actualizar");
            if(encontrada!=null){
                System.out.println("nombre anterior: "+encontrada.getName());
                System.out.println("Dame el nuevo nombre");
                name=sc.nextLine();
                encontrada.setName(name);
                break;
            }else{
                System.out.println("id no encontrado");
            }
        }
    }

}
