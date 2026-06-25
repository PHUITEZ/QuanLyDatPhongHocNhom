package com.group5.main.service;

import com.group5.main.exception.BookingException;
import com.group5.main.model.Student;
import com.group5.main.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private List<Student> students;

    private final StudentRepository studentRepository =
            new StudentRepository();

    public StudentService() {

        this.students =
                studentRepository.loadStudents();
    }

    public void addStudent(Student student) {

        students.add(student);

        studentRepository.saveStudents(students);
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student findStudentById(String studentId)
            throws BookingException {

        return students.stream()
                .filter(s ->
                        s.getStudentId()
                                .equalsIgnoreCase(studentId))
                .findFirst()
                .orElseThrow(() ->
                        new BookingException(
                                "Loi: Sinh vien co ma "
                                        + studentId
                                        + " khong ton tai!"));
    }
}