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

