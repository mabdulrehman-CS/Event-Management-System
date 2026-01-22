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

        public void View_Request_Event_Admin() {
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

        public void Action_On_Event_Request_Admin() {
        System.out.println("->Accept ....1");
        System.out.println("->Reject.....2");
        try {
            int een = emm.getSc().nextInt();
            emm.getSc().nextLine();
            if (een == 1) {
                this.Event_Check = "Accepted";
            } else {
                this.Event_Check = "Rejected";
            }
        } catch (InputMismatchException ex) {
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

        public void Allot_Event_Venue_Admin() {
        System.out.println("---------------------------------");
        System.out.println("ID of Event  " + this.Event_ID);
        System.out.println("Enter Event Venue");
        this.Event_Venue = emm.getSc().nextLine();
        System.out.println("Enter Event Date");
        this.Event_Date = emm.getSc().nextLine();
        System.out.println("Enter Event Day");
        this.Event_Day = emm.getSc().nextLine();
        System.out.println("Enter Starting Time ");
        this.Event_Time_Start = emm.getSc().nextLine();
        System.out.println("Enter Ending Time");
        this.Event_Time_End = emm.getSc().nextLine();
        System.out.println("-----------------------");
    }

        public void View_Event_Venue_User() {
        View_Request_Event_User();
        System.out.println("---------------------------------");
        System.out.println("Venue of Event ---" + this.Event_Venue);
        System.out.println("Date of Event-----" + this.Event_Date);
        System.out.println("Day of Event------" + this.Event_Day);
        System.out.println("Starting Time of Event--" + this.Event_Time_Start);
        System.out.println("Ending Time of Event----" + this.Event_Time_End);

    }

    public void Request_For_Decoration_User() {
        dea = new Decoration[50];
        System.out.print("How Many Items You Want To Enter:  ");
        try {
            this.ncb = emm.getSc().nextInt();
            emm.getSc().nextLine();
            for (int i = 0; i < this.ncb; i++) {
                dea[i] = new Decoration();
                System.out.println("Enter Info------: " + (i + 1));
                System.out.println("Enter Item----: ");
                dea[i].setDcoration_Items(emm.getSc().nextLine());
                System.out.print("Enter Quantity--: ");
                dea[i].setDecoration_Items_Quantity(emm.getSc().nextInt());
                emm.getSc().nextLine();
            }
        } catch (InputMismatchException ex) {
        } catch (Exception exc) {
        }
    }

    public void View_Decoration_Request_User() {
        System.out.println("My Request Details");
        System.out.println("Event Id------: " + this.Event_ID);
        System.out.println("Event Name----: " + this.Event_Name);
        System.out.println("Society Name--: " + getSociety_Name());
        for (int i = 0; i < this.ncb; i++) {
            System.out.println("Item Name------: " + dea[i].getDcoration_Items());
            System.out.println("Item Quantity--: " + dea[i].getDecoration_Items_Quantity());
        }

    }

    public void View_Decoration_Request_Admin() {
        System.out.println("Event Id------: " + this.Event_ID);
        System.out.println("Event Name----: " + this.Event_Name);
        System.out.println("Society Name--: " + getSociety_Name());
        for (int i = 0; i < this.ncb; i++) {
            System.out.println("Item Name------: " + dea[i].getDcoration_Items());
            System.out.println("Item Quantity--: " + dea[i].getDecoration_Items_Quantity());
        }
    }

    public void Action_On_Event_Decoration_Admin() {
        View_Decoration_Request_Admin();
        System.out.println("->Accept ....1");
        System.out.println("->Reject.....2");
        try {
            int een = emm.getSc().nextInt();
            emm.getSc().nextLine();
            if (een == 1) {
                this.Decor_Event_Check = "Accepted";
            } else {
                this.Decor_Event_Check = "Rejected";
            }
        } catch (InputMismatchException ex) {
        } catch (Exception exc) {
        }
    }

    public void View_Event_Public() {
        System.out.println("---------------------------------------");
        System.out.println("Event Name-----------:" + getEvent_Name());
        System.out.println("Society Name---------:" + getSociety_Name());
        System.out.println("Event Date-----------:" + getEvent_Date());
        System.out.println("Event Day------------:" + getEvent_Day());
        System.out.println("Event Venue----------:" + getEvent_Venue());
        System.out.println("Event Starting Time--:" + getEvent_Time_Start());
        System.out.println("Event Ending Time----:" + getEvent_Time_End());
        for (int i = 0; i < this.nca; i++) {
            System.out.println("Organizer Detail --- " + (i + 1) + " ---");
            System.out.println("Name Of Organizer--: " + getOra()[i].getOrganizer_Name());
            System.out.println("Phone No-----------: " + getOra()[i].getOrganizer_Ph_No());
        }
        System.out.println("---------------------------------------");
    }

    public static void saveEventData(List<Event> eventList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Event.txt", true))) {
            oos.writeObject(eventList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
