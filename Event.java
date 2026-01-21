import java.util.*;
import java.io.*;

public class Event extends Society implements Serializable {
    Example emm = new Example();
    private String Event_Name;
    private String Event_Venue;
    private String Event_Day;
    private String Event_Date;
    private String Event_Time_Start;
    private String Event_Time_End;
    private String Event_Check;
    private String Decor_Event_Check;
    private int Event_ID;
    private static int LastId = 0;

    private Decoration[] dea;
    private boolean bo;
    private int nca;
    private int ncb;

    public Event() {
        this.Event_ID = ++LastId;
        this.bo = false;
    }

    public String getEvent_Name() {
        return Event_Name;
    }

    public void setEvent_Name(String event_Name) {
        Event_Name = event_Name;
    }

    public String getEvent_Venue() {
        return Event_Venue;
    }

    public void setEvent_Venue(String event_Venue) {
        Event_Venue = event_Venue;
    }

    public String getEvent_Day() {
        return Event_Day;
    }

    public void setEvent_Day(String event_Day) {
        Event_Day = event_Day;
    }

    public String getEvent_Date() {
        return Event_Date;
    }

    public void setEvent_Date(String event_Date) {
        Event_Date = event_Date;
    }

    public String getEvent_Time_Start() {
        return Event_Time_Start;
    }

    public void setEvent_Time_Start(String event_Time_Start) {
        Event_Time_Start = event_Time_Start;
    }

    public String getEvent_Time_End() {
        return Event_Time_End;
    }

    public void setEvent_Time_End(String event_Time_End) {
        Event_Time_End = event_Time_End;
    }

    public void setEvent_Check(String event_Check) {
        Event_Check = event_Check;
    }

    public String getEvent_Check() {
        return Event_Check;
    }

    public void setDecor_Event_Check(String decor_Event_Check) {
        Decor_Event_Check = decor_Event_Check;
    }

    public String getDecor_Event_Check() {
        return Decor_Event_Check;
    }

    public Decoration[] getDea() {
        return dea;
    }

    public void setDea(Decoration[] dea) {
        this.dea = dea;
    }

    public boolean isBo() {
        return bo;
    }

    public void setBo(boolean bo) {
        this.bo = bo;
    }

    public int getEvent_ID() {
        return Event_ID;
    }

        public void Request_For_Event_User() {
        System.out.print("Enter Event Name----------------------------------: ");
        this.Event_Name = emm.getSc().nextLine();
        System.out.print("Enter Society Name Which is Conducting the Event--: ");
        setSociety_Name(emm.getSc().nextLine());
        try {
            System.out.print("How many Organizers are of the Event--------------: ");
            this.nca = emm.getSc().nextInt();
            emm.getSc().nextLine();
            for (int i = 0; i < nca; i++) {
                getOra()[i] = new Organizer();
                System.out.println("Enter Info of--- " + (i + 1) + " ---Organizer");
                System.out.print("Enter Name Of Organizer---: ");
                getOra()[i].setOrganizer_Name(emm.getSc().nextLine());
                System.out.print("Enter Registration No-----: ");
                getOra()[i].setOrganizer_Reg_No(emm.getSc().nextLine());
                System.out.print("Enter Phone_No------------: ");
                getOra()[i].setOrganizer_Ph_No(emm.getSc().nextLine());
                System.out.println();
            }
        } catch (InputMismatchException ex) {
        } catch (Exception exc) {
        }
    }

        public void View_Request_Event_User() {
        System.out.println("Event ID-----: " + this.Event_ID);
        System.out.println("Event Name---: " + this.Event_Name);
        System.out.println("Society Name-: " + getSociety_Name());
        System.out.println("***ORGANIZERS***");
        for (int i = 0; i < this.nca; i++) {
            System.out.println("Organizer Detail --- " + (i + 1) + " ---");
            System.out.println("Name Of Organizer--: " + getOra()[i].getOrganizer_Name());
            System.out.println("Registration No----: " + getOra()[i].getOrganizer_Reg_No());
            System.out.println("Phone No-----------: " + getOra()[i].getOrganizer_Ph_No());

        }
    }