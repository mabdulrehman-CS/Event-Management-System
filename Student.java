import java.io.*;

public class Student implements Serializable {
    private String Student_Name;
    private String Student_Department;
    private String Student_Semester;
    private String Student_Registration_No;
    private String Student_Phone_No;

    public Student() {

    }

    public String getStudent_Name() {
        return Student_Name;
    }

    public void setStudent_Name(String student_Name) {
        Student_Name = student_Name;
    }

    public String getStudent_Department() {
        return Student_Department;
    }

    public void setStudent_Department(String student_Department) {
        Student_Department = student_Department;
    }

    public String getStudent_Semester() {
        return Student_Semester;
    }

    public void setStudent_Semester(String student_Semester) {
        Student_Semester = student_Semester;
    }

    public String getStudent_Registration_No() {
        return Student_Registration_No;
    }

    public void setStudent_Registration_No(String student_Registration_No) {
        Student_Registration_No = student_Registration_No;
    }

    public String getStudent_Phone_No() {
        return Student_Phone_No;
    }

    public void setStudent_Phone_No(String student_Phone_No) {
        Student_Phone_No = student_Phone_No;
    }

}
