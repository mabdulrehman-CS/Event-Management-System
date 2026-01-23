import java.io.*;

public class Organizer implements Serializable {
    private String Organizer_Name;
    private String Organizer_Reg_No;
    private String Organizer_Ph_No;

    public Organizer() {

    }

    public String getOrganizer_Name() {
        return Organizer_Name;
    }

    public void setOrganizer_Name(String organizer_Name) {
        Organizer_Name = organizer_Name;
    }

    public String getOrganizer_Reg_No() {
        return Organizer_Reg_No;
    }

    public void setOrganizer_Reg_No(String organizer_Reg_No) {
        Organizer_Reg_No = organizer_Reg_No;
    }

    public String getOrganizer_Ph_No() {
        return Organizer_Ph_No;
    }

    public void setOrganizer_Ph_No(String organizer_Ph_No) {
        Organizer_Ph_No = organizer_Ph_No;
    }
}
