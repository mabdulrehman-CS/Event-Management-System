import java.io.*;
import java.util.*;

public class Main implements Serializable {
    public static void main(String[] args) {

        Example emm = new Example();
        List<Event> E_List = new ArrayList<>();
        List<Stall> S_List = new ArrayList<>();
        Event e;
        Stall s;
        int ne = 0;
        int ns = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("Variables.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    if ("ne".equals(key)) {
                        ne = Integer.parseInt(value);
                    } else if ("ns".equals(key)) {
                        ns = Integer.parseInt(value);
                    }
                }
            }
        } catch (IOException | NumberFormatException eee) {
            eee.printStackTrace();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Event.txt"))) {
            E_List = (List) ois.readObject();
        } catch (IOException | ClassNotFoundException ef) {
            ef.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Stall.txt"))) {
            S_List = (List) ois.readObject();
        } catch (IOException | ClassNotFoundException ef) {
            ef.printStackTrace();
        }

        System.out.println("======================Instructions======================");
        System.out.println("Please Read them Carefully for Guidance------");
        System.out.println("First Goto User Side and Place Requests------");
        System.out.println("Second Goto to Admin Side and then Take Action on Request---");
        System.out.println("Third Again Goto User Side and Check status of Your Requests");
        System.out.println("Then Goto Public Side for View all the Requests");
        System.out.println("=========================================================");
        System.out.println("*******Welcome to Event Manangement System*******");
        System.out.println("For Admin Side Press----- 1");
        System.out.println("For User Side Press------ 2");
        System.out.println("For Public Side Press---- 3");
        System.out.println("For Exit Press----------- 4");

        System.out.println("Enter Number..............");

        char nma = emm.getSc().next().charAt(0);
        switch (nma) {
            case '1': {
                Security su = new Security();
                boolean bb = true;
                System.out.println("Press 1 for Sign_up");
                System.out.println("Press 2 for Login");
                char suu = emm.getSc().next().charAt(0);
                switch (suu) {
                    case '1': {
                        System.out.println("Enter Security_Key to Sign_up");
                        try {
                            double dou = emm.getSc().nextDouble();
                            if (dou == su.getSecurity_Key()) {
                                su.Sign_up();
                                System.out.println("You signed up Successfully");
                                System.out.println("For Admin access Login Please");
                                System.out.println("-----------------------------");
                            } else {
                                System.out.println("Wrong Security Key Can't Sign_up");
                            }
                        } catch (InputMismatchException ex) {
                        } catch (Exception exc) {
                        }

                    }
                    case '2': {
                        System.out.println("You have only 3 Attempts for Passward");
                        System.out.println("If Your all attempts failed you go to user side by Default");
                        int passwordAttempts = 0;
                        while (passwordAttempts < 3) {
                            bb = su.Login();
                            if (bb) {
                                break;
                            } else {
                                passwordAttempts++;
                                System.out.println("Invalid password! Remaining attempts: " + (3 - passwordAttempts));
                                if (passwordAttempts == 3) {
                                    System.out.println("Maximum password attempts reached. Returning to the main menu......");
                                    break;
                                }
                            }
                        }
                    }

                }
                if (bb == true) {

                    while (true) {
                        System.out.println("===================================");
                        System.out.println("Press 1 for Events Info------:Admin");
                        System.out.println("Press 2 for Stalls Info------:Admin");
                        System.out.println("Press 3 for Decoration Info--:Admin");
                        System.out.println("Press 4 for Exit-------------------");
                        System.out.println("===================================");
                        char nmb = emm.getSc().next().charAt(0);
                        switch (nmb) {
                            case '1': {
                                System.out.println("->Press 1 for Show Events Request------------:Admin");
                                System.out.println("->Press 2 for Action on Event Request--------:Admin");
                                System.out.println("->Press 3 for Allot Paces To Accepted Event--:Admin");
                                char nmd = emm.getSc().next().charAt(0);
                                switch (nmd) {
                                    case '1': {
                                        for (int i = 0; i < ne; i++) {
                                            E_List.get(i).View_Request_Event_Admin();
                                            System.out.println();
                                        }
                                    }
                                    break;
                                    case '2': {
                                        for (int i = 0; i < ne; i++) {
                                            E_List.get(i).View_Request_Event_Admin();
                                            System.out.println();
                                        }
                                        for (int i = 0; i < ne; i++) {
                                            System.out.println("ID of Event:" + E_List.get(i).getEvent_ID());
                                            E_List.get(i).Action_On_Event_Request_Admin();
                                        }
                                    }
                                    break;
                                    case '3': {
                                        for (int i = 0; i < ne; i++) {
                                            if (E_List.get(i).getEvent_Check().equals("Accepted")) {
                                                E_List.get(i).Allot_Event_Venue_Admin();
                                            }
                                        }
                                    }
                                    break;
                                    default: {
                                        System.out.println("Invalid Input");
                                    }
                                    break;
                                }
                            }
                            break;
                            case '2': {
                                System.out.println("->Press 1 for View Stall Request-------:Admin");
                                System.out.println("->Press 2 for Action on Stall Request--:Admin");
                                char cme = emm.getSc().next().charAt(0);
                                switch (cme) {
                                    case '1': {
                                        for (int i = 0; i < ns; i++) {
                                            S_List.get(i).View_Request_Stalls_Admin();
                                            System.out.println();
                                        }
                                    }
                                    break;
                                    case '2': {
                                        for (int i = 0; i < ns; i++) {
                                            S_List.get(i).View_Request_Stalls_Admin();
                                            System.out.println();
                                        }
                                        for (int i = 0; i < ns; i++) {
                                            System.out.println("ID of Stall: " + S_List.get(i).getStall_ID());
                                            S_List.get(i).Action_On_Stall_Request_Admin();
                                        }
                                    }
                                    break;
                                    default: {
                                        System.out.println("Invalid Input");
                                    }
                                    break;
                                }
                            }
                            break;
                            case '3': {
                                System.out.println("->Press 1 for View Decor Items---:Admin");
                                System.out.println("->Press 2 for Action on Request--:Admin");
                                char smg = emm.getSc().next().charAt(0);
                                switch (smg) {
                                    case '1': {
                                        for (int i = 0; i < ne; i++) {
                                            if (E_List.get(i).isBo() == true) {
                                                E_List.get(i).View_Decoration_Request_Admin();
                                            }
                                        }
                                    }
                                    break;
                                    case '2': {
                                        for (int i = 0; i < ne; i++) {
                                            if (E_List.get(i).getEvent_Check().equals("Accepted")) {
                                                E_List.get(i).Action_On_Event_Decoration_Admin();
                                            }
                                        }
                                    }
                                    break;
                                    default: {
                                        System.out.println("Invalid Input");
                                    }
                                    break;
                                }
                            }
                            break;
                            case '4': {
                                Event.saveEventData(E_List);
                                Stall.saveStallData(S_List);
                                System.exit(0);
                            }
                            break;
                            default: {
                                System.out.println("Invalid Input");
                            }
                            break;
                        }
                    }
                }
            }
            case '2': {
                while (true) {
                    System.out.println("==================================");
                    System.out.println("Press 1 for Events Info------:User");
                    System.out.println("Press 2 for Stalls Info------:User");
                    System.out.println("Press 3 for Decoration Info--:User");
                    System.out.println("Press 4 for Exit------------------");
                    System.out.println("==================================");
                    char nmc = emm.getSc().next().charAt(0);
                    switch (nmc) {

                        case '1': {
                            System.out.println("->Press 1 for Request Event------------------:User");
                            System.out.println("->Press 2 for View Request Event-------------:User");
                            System.out.println("->Press 3 for Check Status of your Request---:User");
                            System.out.println("->Press 4 for View Alloted Places of Event---:User");
                            int nmd = emm.getSc().next().charAt(0);
                            switch (nmd) {
                                case '1': {
                                    System.out.println("***How Many Events You Wants To Enter***");
                                    try {
                                        ne = emm.getSc().nextInt();
                                        emm.getSc().nextLine();
                                        for (int i = 0; i < ne; i++) {
                                            e = new Event();
                                            System.out.println("Enter Info Of Event " + (i + 1) + " : ");
                                            e.Request_For_Event_User();
                                            E_List.add(e);
                                            System.out.println("ID of your Event is--- " + E_List.get(i).getEvent_ID() + " ---");
                                            System.out.println("Dont Forget your ID if you want to Know the Status of your Event Request");
                                            System.out.println();
                                        }
                                    } catch (InputMismatchException ex) {
                                    } catch (Exception exc) {
                                    }
                                }
                                break;
                                case '2': {
                                    System.out.println("Enter ID of your Request");
                                    try {
                                        int eid = emm.getSc().nextInt();
                                        emm.getSc().nextLine();
                                        int ep = 0;
                                        for (int i = 0; i < ne; i++) {
                                            if (eid == E_List.get(i).getEvent_ID()) {
                                                System.out.println("Details I Entered");
                                                E_List.get(i).View_Request_Event_User();
                                                System.out.println();
                                                ep = 1;
                                                break;
                                            } else {
                                                ep = 0;
                                            }
                                        }
                                        if (ep == 0) {
                                            System.out.println("Wrong ID");
                                        }
                                    } catch (InputMismatchException ex) {
                                    } catch (Exception exc) {
                                    }
                                }
                                break;
                                case '3': {
                                    System.out.println("Enter ID of your Request");
                                    try {
                                        int eid = emm.getSc().nextInt();
                                        emm.getSc().nextLine();
                                        int ep = 0;
                                        for (int i = 0; i < ne; i++) {
                                            if (eid == E_List.get(i).getEvent_ID()) {
                                                E_List.get(i).View_Request_Event_User();
                                                System.out.println();
                                                System.out.println("Status of my Request Against ID--- " + E_List.get(i).getEvent_ID() + " --- " + E_List.get(i).getEvent_Check());
                                                ep = 1;
                                                break;
                                            } else {
                                                ep = 0;
                                            }
                                        }
                                        if (ep == 0) {
                                            System.out.println("Wrong ID");
                                        }
                                    } catch (InputMismatchException ex) {
                                    } catch (Exception exc) {
                                    }
                                }
                                break;
                                case '4': {
                                    System.out.println("Enter ID of Event you want to Check the Allot Places");
                                    try {
                                        int eid = emm.getSc().nextInt();
                                        emm.getSc().nextLine();
                                        int ed = 0;
                                        int edd = 0;
                                        for (int i = 0; i < ne; i++) {
                                            if (eid == E_List.get(i).getEvent_ID()) {
                                                ed = 1;
                                                if (E_List.get(i).getEvent_Check().equals("Accepted")) {
                                                    E_List.get(i).View_Event_Venue_User();
                                                    edd = 1;
                                                    break;
                                                } else {
                                                    edd = 0;
                                                }
                                                break;
                                            } else {
                                                ed = 0;
                                                edd = 1;
                                            }
                                            break;
                                        }
                                        if (edd == 0) {
                                            System.out.println("Event is Rejected");
                                        }
                                        if (ed == 0) {
                                            System.out.println("Wrong ID");
                                        }
                                    } catch (InputMismatchException ex) {
                                    } catch (Exception exc) {
                                    }
                                }
                                break;
                                default: {
                                    System.out.println("Invalid Input");
                                }
                                break;
                            }
                        }
                        break;
                        case '2': {
                            System.out.println("->Press 1 For Request Stall-----------------:User");
                            System.out.println("->Press 2 For View Request Stall------------:User");
                            System.out.println("->Press 3 For Check Status of your Request--:User");
                            char nmf = emm.getSc().next().charAt(0);
                            switch (nmf) {
                                case '1': {
                                    System.out.println("***How Many Stalls You Want To Enter***");
                                    try {
                                        ns = emm.getSc().nextInt();
                                        emm.getSc().nextLine();
                                        for (int i = 0; i < ns; i++) {
                                            s = new Stall();
                                            System.out.println("Enter Info Of Stall " + (i + 1) + " : ");
                                            s.Request_For_Stalls_User();
                                            S_List.add(s);
                                            System.out.println("ID of your Stall is-----  " + S_List.get(i).getStall_ID() + "  -----");
                                            System.out.println("Dont Forget your ID if you want to Know the Status of your Stall Request");
                                            System.out.println();
                                        }
                                    } catch (InputMismatchException ex) {
                                    } catch (Exception exc) {
                                    }
                                }
                                break;
                                case '2': {
                                    System.out.println("Enter ID of your Request");
                                    try {
                                        int sid = emm.getSc().nextInt();
                                        emm.getSc().nextLine();
                                        int sp = 0;
                                        for (int i = 0; i < ns; i++) {
                                            if (sid == S_List.get(i).getStall_ID()) {
                                                S_List.get(i).View_Request_Stall_User();
                                                System.out.println();
                                                sp = 1;
                                                break;
                                            } else {
                                                sp = 0;
                                            }
                                        }
                                        if (sp == 0) {
                                            System.out.println("Wrong ID");
                                        }
                                    } catch (InputMismatchException ex) {
                                    } catch (Exception exc) {
                                    }
                                }
                                break;
                                case '3': {
                                    System.out.println("Enter ID of your Request");
                                    try {
                                        int sid = emm.getSc().nextInt();
                                        emm.getSc().nextLine();
                                        int sp = 0;
                                        for (int i = 0; i < ns; i++) {
                                            if (sid == S_List.get(i).getStall_ID()) {
                                                S_List.get(i).View_Request_Stall_User();
                                                System.out.println();
                                                System.out.println("Status of my Request Against ID--- " + S_List.get(i).getStall_ID() + " --- " + S_List.get(i).getStall_Check());
                                                sp = 1;
                                                break;
                                            } else {
                                                sp = 0;
                                            }
                                        }
                                        if (sp == 0) {
                                            System.out.println("Wrong ID");
                                        }
                                    } catch (InputMismatchException ex) {
                                    } catch (Exception exc) {
                                    }
                                }
                                break;
                                default: {
                                    System.out.println("Invalid Input");
                                }
                                break;
                            }
                        }
                        break;
                        case '3': {
                            System.out.println("->Press 1 For Request Decor Items------:User");
                            System.out.println("->Press 2 For View Your Request--------:User");
                            System.out.println("->Press 3 For Check Status of Request--:User");
                            char dmh = emm.getSc().next().charAt(0);
                            switch (dmh) {
                                case '1': {
                                    System.out.print("Enter ID Of Event Your Want Decore Items: ");
                                    try {
                                        int id = emm.getSc().nextInt();
                                        emm.getSc().nextLine();
                                        int nd = 0;
                                        int ndd = 0;
                                        for (int i = 0; i < ne; i++) {
                                            nd = 1;
                                            if (id == E_List.get(i).getEvent_ID()) {
                                                if (E_List.get(i).getEvent_Check().equals("Accepted")) {
                                                    E_List.get(i).setBo(true);
                                                    System.out.println("Event Name Is: " + E_List.get(i).getEvent_Name());
                                                    E_List.get(i).Request_For_Decoration_User();
                                                    ndd = 1;
                                                    break;
                                                } else {
                                                    ndd = 0;
                                                }
                                                break;
                                            } else {
                                                nd = 0;
                                                ndd = 1;
                                            }
                                        }
                                        if (nd == 0) {
                                            System.out.println("Wrong ID");
                                        }
                                        if (ndd == 0) {
                                            System.out.println("Event is Rejected");
                                        }
                                    } catch (InputMismatchException ex) {
                                    } catch (Exception exc) {
                                        exc.printStackTrace();
                                    }
                                }
                                break;
                                case '2': {
                                    System.out.println("Enter ID of your Request");
                                    try {
                                        int did = emm.getSc().nextInt();
                                        emm.getSc().nextLine();
                                        int dp = 0;
                                        int dpp = 0;
                                        for (int i = 0; i < ne; i++) {
                                            if (did == E_List.get(i).getEvent_ID()) {
                                                dp = 1;
                                                if (E_List.get(i).getEvent_Check().equals("Accepted")) {
                                                    E_List.get(i).View_Decoration_Request_User();
                                                    dpp = 1;
                                                    break;
                                                } else {
                                                    dpp = 0;
                                                }
                                                break;
                                            } else {
                                                dp = 0;
                                                dpp = 1;
                                            }
                                        }
                                        if (dp == 0) {
                                            System.out.println("Wrong ID");
                                        }
                                        if (dpp == 0) {
                                            System.out.println("Event is Rejected");
                                        }
                                    } catch (InputMismatchException ex) {
                                    } catch (Exception exc) {
                                    }
                                }
                                break;
                                case '3': {
                                    System.out.println("Enter ID of your Request");
                                    try {
                                        int did = emm.getSc().nextInt();
                                        emm.getSc().nextLine();
                                        int dp = 0;
                                        int dpp = 0;
                                        int dppp = 0;
                                        for (int i = 0; i < ne; i++) {
                                            dp = 1;
                                            if (did == E_List.get(i).getEvent_ID()) {
                                                dpp = 1;
                                                if (E_List.get(i).getEvent_Check().equals("Accepted")) {
                                                    if (E_List.get(i).getDecor_Event_Check().equals("Accepted")) {
                                                        E_List.get(i).View_Decoration_Request_User();
                                                        dppp = 1;
                                                        break;
                                                    } else {
                                                        dppp = 0;
                                                    }
                                                    break;
                                                } else {
                                                    dpp = 0;
                                                    dppp = 1;
                                                }
                                                break;
                                            } else {
                                                dp = 0;
                                                dppp = 1;
                                                dpp = 1;
                                            }
                                        }
                                        if (dppp == 0) {
                                            System.out.println("Decoration Request is Rejected");
                                        }
                                        if (dpp == 0) {
                                            System.out.println("Event Request Rejected");
                                        }
                                        if (dp == 0) {
                                            System.out.println("Wrong ID");
                                        }
                                    } catch (InputMismatchException ex) {
                                    } catch (Exception exc) {
                                    }
                                }
                                break;
                                default: {
                                    System.out.println("Invalid Input");
                                }
                                break;
                            }
                        }
                        break;
                        case '4': {
                            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Variables.txt"))) {
                                writer.write("ne=" + ne);
                                writer.newLine();
                                writer.write("ns=" + ns);
                            } catch (IOException ee) {
                                ee.printStackTrace();
                            }
                            Event.saveEventData(E_List);
                            Stall.saveStallData(S_List);
                            System.exit(0);
                        }
                        break;
                        default: {
                            System.out.println("Invalid Input");
                        }
                        break;
                    }
                }

            }
            case '3': {
                while (true) {
                    System.out.println("================================");
                    System.out.println("Press 1 for Event info---:Public");
                    System.out.println("Press 2 for Stall info---:Public");
                    System.out.println("Press 3 for Exit----------------");
                    System.out.println("================================");
                    char np = emm.getSc().next().charAt(0);
                    emm.getSc().nextLine();
                    switch (np) {
                        case '1': {
                            System.out.println("->Press 1 for View Event all Events------:Public");
                            System.out.println("->Press 2 for View Event By Society Name-:Public");
                            System.out.println("->Press 3 for View Event By Day----------:Public");
                            char npp = emm.getSc().next().charAt(0);
                            switch (npp) {
                                case '1': {
                                    for (int i = 0; i < ne; i++) {
                                        if (E_List.get(i).getEvent_Check().equals("Accepted")) {
                                            E_List.get(i).View_Event_Public();
                                        }
                                    }
                                }
                                break;
                                case '2': {
                                    for (int i = 0; i < ne; i++) {
                                        System.out.println("Socitie ---" + (i + 1) + "---" + E_List.get(i).getSociety_Name());
                                    }
                                    System.out.println("Enter Society Name form The Given List");
                                    emm.getSc().nextLine();
                                    System.out.println("Enter Society Name:");
                                    String ven = emm.getSc().nextLine();
                                    for (int i = 0; i < ne; i++) {
                                        if (ven.equals(E_List.get(i).getSociety_Name())) {
                                            if (E_List.get(i).getEvent_Check().equals("Accepted")) {
                                                E_List.get(i).View_Event_Public();
                                            }
                                        }
                                    }
                                }
                                break;
                                case '3': {
                                    emm.getSc().nextLine();
                                    System.out.println("Saturday and Sunday are Holidays");
                                    System.out.println("Enter Event Day:");
                                    String ven = emm.getSc().nextLine();
                                    for (int i = 0; i < ne; i++) {
                                        if (ven.equals(E_List.get(i).getEvent_Day())) {
                                            if (E_List.get(i).getEvent_Check().equals("Accepted")) {
                                                E_List.get(i).View_Event_Public();
                                            }
                                        }
                                    }
                                }
                                break;
                                default: {
                                    System.out.println("Invalid Input");
                                }
                                break;
                            }
                        }
                        break;
                        case '2': {
                            for (int i = 0; i < ns; i++) {
                                if (S_List.get(i).getStall_Check().equals("Accepted")) {
                                    S_List.get(i).View_Stall_Public();
                                }
                            }
                        }
                        break;
                        case '3': {
                            Event.saveEventData(E_List);
                            Stall.saveStallData(S_List);
                            System.exit(0);
                        }
                        break;
                        default: {
                            System.out.println("Invalid Input");
                        }
                        break;

                    }
                }
            }
            case '4': {
                Event.saveEventData(E_List);
                Stall.saveStallData(S_List);
                System.exit(0);
            }
            break;
            default: {
                System.out.println("Invalid Input!!!!!");
                System.out.println("---Input Again---");
            }
            break;
        }
    }
}