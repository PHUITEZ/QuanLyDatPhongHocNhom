package service;

import model.Student;
import exception.BookingException;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student findStudentById(String studentId) throws BookingException {
        return students.stream()
                .filter(s -> s.getStudentId().equalsIgnoreCase(studentId))
                .findFirst()
                .orElseThrow(() -> new BookingException("Loi: Sinh vien co ma " + studentId + " khong ton tai trong he thong!"));
    }
}