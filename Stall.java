import java.util.*;
import java.io.*;

public class Stall extends Student implements Serializable {
    Example emm = new Example();
    private String Stall_Name;
    private String Stall_Type;
    private String Stall_StartDate;
    private String Stall_EndDate;
    private String Stall_Check;
    private int Stall_ID;
    private static int LastID = 0;


    public Stall() {
        this.Stall_ID = ++LastID;

    }

    public String getStall_Name() {
        return Stall_Name;
    }

    public void setStall_Name(String stall_Name) {
        Stall_Name = stall_Name;
    }

    public String getStall_Type() {
        return Stall_Type;
    }

    public void setStall_Type(String stall_Type) {
        Stall_Type = stall_Type;
    }

    public String getStall_StartDate() {
        return Stall_StartDate;
    }

    public void setStall_StartDate(String stall_StartDate) {
        Stall_StartDate = stall_StartDate;
    }

    public String getStall_EndDate() {
        return Stall_EndDate;
    }

    public void setStall_EndDate(String stall_EndDate) {
        Stall_EndDate = stall_EndDate;
    }

    public void setStall_Check(String stall_Check) {
        Stall_Check = stall_Check;
    }

    public String getStall_Check() {
        return Stall_Check;
    }

    public int getStall_ID() {
        return Stall_ID;
    }

    public void Request_For_Stalls_User() {
        System.out.print("Enter Student Name-------------: ");
        setStudent_Name(emm.getSc().nextLine());
        System.out.print("Enter Student Registration_No--: ");
        setStudent_Registration_No(emm.getSc().nextLine());
        System.out.print("Enter Student Department-------: ");
        setStudent_Department(emm.getSc().nextLine());
        System.out.print("Enter Student Semester---------: ");
        setStudent_Semester(emm.getSc().nextLine());
        System.out.print("Enter Student Phone_No---------: ");
        setStudent_Phone_No(emm.getSc().nextLine());
        System.out.print("Enter Stall Name---------------: ");
        this.Stall_Name = emm.getSc().nextLine();
        System.out.print("Enter Stall Type---------------: ");
        this.Stall_Type = emm.getSc().nextLine();
        System.out.print("Enter Starting Date------------: ");
        this.Stall_StartDate = emm.getSc().nextLine();
        System.out.print("Enter Ending Date--------------: ");
        this.Stall_EndDate = emm.getSc().nextLine();
        System.out.println();
    }

    public void View_Request_Stall_User() {
        System.out.println("My Request Details");
        System.out.println("Stall ID---------: " + this.Stall_ID);
        System.out.println("Student Name-----: " + getStudent_Name());
        System.out.println("Registration No--: " + getStudent_Registration_No());
        System.out.println("Department-------: " + getStudent_Department());
        System.out.println("Semester---------: " + getStudent_Semester());
        System.out.println("Phone-No---------: " + getStudent_Phone_No());
        System.out.println("Stall Name-------: " + this.Stall_Name);
        System.out.println("Stall Type-------: " + this.Stall_Type);
        System.out.println("Starting Date----: " + this.Stall_StartDate);
        System.out.println("Ending Date------: " + this.Stall_EndDate);

    }

    public void View_Request_Stalls_Admin() {
        System.out.println("Stall ID---------: " + this.Stall_ID);
        System.out.println("Student Name-----: " + getStudent_Name());
        System.out.println("Registration No--: " + getStudent_Registration_No());
        System.out.println("Department-------: " + getStudent_Department());
        System.out.println("Semester---------: " + getStudent_Semester());
        System.out.println("Phone-No---------: " + getStudent_Phone_No());
        System.out.println("Stall Name-------: " + this.Stall_Name);
        System.out.println("Stall Type-------: " + this.Stall_Type);
        System.out.println("Starting Date----: " + this.Stall_StartDate);
        System.out.println("Ending Date------: " + this.Stall_EndDate);
    }

    public void Action_On_Stall_Request_Admin() {
        System.out.println("->Accept ....1");
        System.out.println("->Reject.....2");
        try {
            int een = emm.getSc().nextInt();
            emm.getSc().nextLine();
            if (een == 1) {
                this.Stall_Check = "Accepted";
            } else {
                this.Stall_Check = "Rejected";
            }
        } catch (InputMismatchException ex) {
        } catch (Exception exc) {
        }
    }

    public void View_Stall_Public() {
        System.out.println("----------------------------------------");
        System.out.println("Student Name-----: " + getStudent_Name());
        System.out.println("Registration No--: " + getStudent_Registration_No());
        System.out.println("Department-------: " + getStudent_Department());
        System.out.println("Semester---------: " + getStudent_Semester());
        System.out.println("Phone-No---------: " + getStudent_Phone_No());
        System.out.println("Stall Name-------: " + this.Stall_Name);
        System.out.println("Stall Type-------: " + this.Stall_Type);
        System.out.println("Starting Date----: " + this.Stall_StartDate);
        System.out.println("Ending Date------: " + this.Stall_EndDate);
        System.out.println("----------------------------------------");

    }

    public static void saveStallData(List<Stall> stallList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Stall.txt"))) {
            oos.writeObject(stallList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
