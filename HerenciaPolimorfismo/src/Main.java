//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    System.out.println("-".repeat(15));
    Animal a1= new Animal("animal generico");
    System.out.println("nombre:"+a1.getNombre());
    a1.hacerSonido();
    System.out.println("-".repeat(15));
    Gato g1=new Gato("Baileys");
    System.out.println("nombre: "+a1.getNombre());
    g1.hacerSonido();
    System.out.println("-".repeat(15));
    Perro p1=new Perro("Firulays");
    System.out.println("nombre: "+p1.getNombre());
    p1.hacerSonido();


}
