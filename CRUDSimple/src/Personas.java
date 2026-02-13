public class Personas {

    private static int indice=0;
    private String name;
    private int id;
    private boolean isActive;

    @Override
    public String toString() {
        return "Personas{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", isActive=" + isActive +
                '}';
    }

    public Personas(String name, int id) {
        this.name = name;
        this.id = id;
        this.isActive = true;
    }
    public int aumentarIndice(){
        return indice++;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
