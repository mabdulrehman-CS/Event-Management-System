import java.io.*;

public class Society implements Serializable {
    private String Society_Name;

    private Organizer[] ora;


    public Society() {
        ora = new Organizer[100];
    }

    public String getSociety_Name() {
        return Society_Name;
    }

    public void setSociety_Name(String society_Name) {
        Society_Name = society_Name;
    }


    public Organizer[] getOra() {
        return ora;
    }

    public void setOra(Organizer[] ora) {
        this.ora = ora;
    }

}
