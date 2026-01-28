//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

void main() {
    double resultado=0;
    double valor=0;
    int conversionAFaren=0;
    int conversionACenti=0;
    int conversionAkm=0;
    int conversionAMillas=0;
    int numConversion;
    int opc;
    int totalConversiones;
    Scanner scanner=new Scanner(System.in);
        do {
            System.out.println("");
            System.out.println("menu");
            System.out.println("1.-°c a °f");
            System.out.println("2.-°f a °c");
            System.out.println("3.-km a millas");
            System.out.println("4.-millas a km");
            System.out.println("5.-salir");
            opc=scanner.nextInt();
            switch (opc) {
                case 1->{valor=obtenerValor(scanner,"dame los °c a convertir");
                    resultado=centrigradoAFaren(valor);
                    System.out.printf("°f: %.2f",resultado);
                    conversionAFaren++;
                }
                case 2->{valor=obtenerValor(scanner,"dame los °f a convertir");
                    resultado=farenACentrigrados(valor);
                    System.out.printf("°c: %.2f",resultado);
                    conversionACenti++;
                }
                case 3->{valor=obtenerValor(scanner,"dame los km a convertir");
                    resultado=kmAMillas(valor);
                    System.out.printf("millas: %.2f",resultado);
                    conversionAMillas++;
                }
                case 4->{valor=obtenerValor(scanner,"dame las millas a convertir");
                    resultado=millasAKM(valor);
                    System.out.printf("km %.2f",resultado);
                    conversionAkm++;
                }
                case 5->{
                    System.out.println("conversion a farenheit:"+conversionAFaren);
                    System.out.println("conversion a centigrados:"+conversionACenti);
                    System.out.println("conversion a km:"+conversionAkm);
                    System.out.println("conversion a millas:"+conversionAMillas);
                    totalConversiones=conversionAkm+conversionAFaren+conversionACenti+conversionAMillas;
                    System.out.println("total de conversiones:"+totalConversiones);
                    System.out.println("adios");
                }
                default ->{
                    System.out.println("introduce una opcion valida");
                }
            }

        } while (opc!=5);
}
public static double obtenerValor(Scanner scanner,String mensaje){
    double valor;
    while(true) {
        System.out.println(mensaje);
        if (scanner.hasNextDouble()) {
            valor = scanner.nextDouble();
            return valor;
        }
        System.out.println("introduce un valor numerico");
        scanner.next();
    }
}
public static double centrigradoAFaren(double valor){
    valor= (valor*1.8)+32;
    return valor;
}

public static double farenACentrigrados(double valor){
    valor= (valor-32)/1.8;
    return valor;
}
public static double kmAMillas(double km){
    double millas= km*.6213;
    return millas;
}
public static double millasAKM(double millas){
    double km= millas*1.60934;
    return km;
}

