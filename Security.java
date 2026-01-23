import java.io.*;
import java.util.*;

public class Security implements Serializable {
    Scanner sc = new Scanner(System.in);
    private String User_Name;
    private String PhoneNumber;
    private String CNIC;
    private String Gmail;
    private String Passward;
    private double Security_Key = 1.1;


    public Security() {

    }

    public String getUserName() {
        return User_Name;
    }

    public void setUserName(String userName) {
        User_Name = userName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    public String getGmail() {
        return Gmail;
    }

    public void setGmail(String gmail) {
        Gmail = gmail;
    }

    public String getPassward() {
        return Passward;
    }

    public void setPassward(String passward) {
        Passward = passward;
    }

    public double getSecurity_Key() {
        return Security_Key;
    }

    public void setSecurity_Key(double security_Key) {
        Security_Key = security_Key;
    }

