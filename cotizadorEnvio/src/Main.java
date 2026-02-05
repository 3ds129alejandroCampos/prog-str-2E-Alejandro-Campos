//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
private   static int RANGOMAXSINEXTRAS=50;
private  static double RANGOMIN=.1;
private static int DISTANCIAMAX=2000;
private static int DISTANCIAMIN=1;


void main() {
    InputValidar validar = new InputValidar();
    Scanner sc= new Scanner(System.in);
    ShippingCalculator calculator= new ShippingCalculator();
    double kg;
    int distancia,tipoServicio;
    boolean zonaRemota;

    kg=validar.leerDoubleEnRango(sc,"dame el peso",RANGOMIN,RANGOMAXSINEXTRAS);
    distancia=validar.leerIntKM(sc,"dame la distancia",DISTANCIAMAX,DISTANCIAMIN);
    tipoServicio=validar.tipoDeServicio(sc,"dame el tipo de servicio");
    zonaRemota=validar.zonaRemota(sc,"Es una zona remota?");

    calculator.datos(kg,distancia,tipoServicio,zonaRemota);
    calculator.imprimir(kg,distancia);


}

