public class Alumnos {
    private  static int index;

    private int id;
    private String name;
    private double promedio;
    private boolean activo;

    public Alumnos(int id,String name,double promedio,boolean activo) {
        this.id = id;
        this.name = name;
        this.promedio = promedio;
        this.activo = activo;

    }
    public int increaseIndex() {
        return index++;
    }


    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
