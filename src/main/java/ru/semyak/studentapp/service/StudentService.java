package ru.semyak.studentapp.service;

import org.springframework.stereotype.Service;
import ru.semyak.studentapp.entities.Student;

import java.util.List;

@Service
public interface StudentService {

    List<Student> findAllStudents();

    Student saveStudent(Student student);

    Student findByEmail(String email);

    Student updateStudent(Student student);

    void deleteStudentByEmail(String email);
}
