package com.group5.main.controller;

import model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private List<Student> students = new ArrayList<>();

    public StudentController() {

        students.add(new Student(
                "SV001",
                "Nguyen Van A",
                "0912345678",
                "CNTT01",
                "a@gmail.com"
        ));

        students.add(new Student(
                "SV002",
                "Tran Thi B",
                "0987654321",
                "CNTT02",
                "b@gmail.com"
        ));

        students.add(new Student(
                "SV003",
                "Le Van C",
                "0909090909",
                "CNTT03",
                "c@gmail.com"
        ));
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return students;
    }
}