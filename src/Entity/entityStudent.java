package Entity;

public class entityStudent {
    private String name; // Nombre
    private String site; // Sede

    public entityStudent(String name, String site){
        this.name = name;
        this.site = site;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void setSite(String newSite){
        this.site = newSite;
    }

    public String getName(){
        return this.name;
    }

    public String getSite(){
        return this.site;
    }

    @Override
    public String toString() {
        return "Estudiante: " + name + ", Sede: " + site + "\n";
    }
}
