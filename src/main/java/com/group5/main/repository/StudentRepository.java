package com.group5.main.repository;

import com.group5.main.model.Student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    private static final String FILE_NAME = "students.dat";

    public void saveStudents(List<Student> students) {

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(
                             new FileOutputStream(FILE_NAME))) {

            oos.writeObject(students);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Student> loadStudents() {

        try (ObjectInputStream ois =
                     new ObjectInputStream(
                             new FileInputStream(FILE_NAME))) {

            return (List<Student>) ois.readObject();

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}