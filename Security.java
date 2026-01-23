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
    
    public void Sign_up() {
        System.out.println("Enter your details for Sign_up");
        System.out.println("Enter Your Name");
        this.User_Name = sc.nextLine();
        System.out.println("Enter Your PhoneNumber");
        this.PhoneNumber = sc.nextLine();
        System.out.println("Enter Your CNIC");
        this.CNIC = sc.nextLine();
        System.out.println("Enter Your Gmail");
        this.Gmail = sc.nextLine();
        System.out.println("Enter Passward");
        this.Passward = sc.nextLine();
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("SecurityPassward.txt"));
            bw.write(this.User_Name);
            bw.write(",");
            bw.write(this.Passward);
            bw.write(",");
            bw.write(this.PhoneNumber);
            bw.write(",");
            bw.write(this.CNIC);
            bw.write(",");
            bw.write(this.Gmail);
            bw.newLine();
        } catch (Exception ee) {
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (Exception ee) {
            }
        }
    }

    public boolean Login() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("SecurityPassward.txt"));
            String st;
            while ((st = br.readLine()) != null) {
                String[] sta = st.split(",");
                this.User_Name = sta[0].trim();
                this.Passward = sta[1].trim();
            }
        } catch (IOException io) {
        } catch (Exception ex) {
        }

        System.out.println("Enter Username and Passward for Login");
        System.out.println("Enter User Name");
        String us = sc.nextLine();
        System.out.println("Enter Passward");
        String pa = sc.nextLine();
        if (us.equals(getUserName()) & pa.equals(getPassward())) {
            System.out.println("Login Successfull");
            return true;
        } else {
            System.out.println("Wrong UserName or Passward");
            return false;
        }
    }
}

