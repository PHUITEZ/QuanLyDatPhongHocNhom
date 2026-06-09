package model;

// Tính kế thừa (Inheritance) - Student kế thừa thuộc tính từ User
public class Student extends User {
    private String studentId;
    private String className;

    public Student(String studentId, String fullName, String phone, String email, String className) {
        // Gọi hàm khởi tạo của lớp cha User
        super(fullName, phone, email);
        this.studentId = studentId;
        this.className = className;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}