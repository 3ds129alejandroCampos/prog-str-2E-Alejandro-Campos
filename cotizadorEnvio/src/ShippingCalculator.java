public class ShippingCalculator {
    public double subTotal;
    public double impuestosTotales;
    public double costoPeso;
    public double costoDistancia;
    public double costoServicio;
    public double total;
    public String servicio;
    public String zonaRemota;

    private static double PRECIOPORKG=12;
    private static double ZONAREMOTA=1.10;
    private static double IMPUESTOS=.16;


    public void datos(double kg,int distancia,int tipoDeServicio,boolean zonaRemota){
        calcularCostoServicio(tipoDeServicio);
        calculaCostoPeso(kg);
        calculaCostoDistancia(distancia);
        calculaSubtotal();
        calculaZonaRemota(zonaRemota);
        impuestosDeServicio();
    }
    private void  calcularCostoServicio(int tipoDeServicio){
        if(tipoDeServicio==1){
            this.servicio="Estandar";
            this.costoServicio=+50;
        }
        else{
            this.servicio="Express";
            this.costoServicio=+90;
        }
    }
    private void calculaCostoPeso(double kg){
        this.costoPeso=kg*PRECIOPORKG;
    }
    private  void calculaCostoDistancia(int distancia){
        if(distancia<=50){
            this.costoDistancia=+20;
        } else if (distancia>=51&&distancia<=200) {
            this.costoDistancia=+60;
        }else{
            this.costoDistancia=+120;

        }
    }
    private void calculaSubtotal(){
        this.subTotal=costoDistancia+costoPeso+costoServicio;
    }
    private void calculaZonaRemota(boolean zonaRemota){
        if(zonaRemota){
            this.zonaRemota="si";
            this.subTotal=subTotal*ZONAREMOTA;
        }
        else{
            this.zonaRemota="no";
        }
    }
    private void impuestosDeServicio(){
        this.impuestosTotales=subTotal*IMPUESTOS;
        this.total=subTotal+impuestosTotales;
    }
    public void imprimir(double kg,int distancia){
        System.out.println("----------------");
        System.out.println("Tipo de servicio: "+servicio);
        System.out.println("Peso (kg): "+kg);
        System.out.println("Distancia(km): "+distancia);
        System.out.println("Zona Remota:"+zonaRemota);

        System.out.printf("subtotal: %.2f%n",subTotal);
        System.out.printf("impuestos: %.2f%n",impuestosTotales);
        System.out.printf("total: %.2f%n",total);
    }

}
