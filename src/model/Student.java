package model;

public class Student {
    private String studentId;
    private String fullName;
    private String phoneNumber;
    private String className;
    private String email;

    public Student() {
    }

    public Student(String studentId, String fullName, String phoneNumber, String className, String email) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.className = className;
        this.email = email;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}