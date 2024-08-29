package ru.semyak.studentapp.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.semyak.studentapp.entities.Student;
import ru.semyak.studentapp.repositories.StudentRepository;
import ru.semyak.studentapp.service.StudentService;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findByEmail(String email) {
        return studentRepository.findStudentByEmail(email);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentByEmail(String email) {
        studentRepository.deleteByEmail(email);
    }
}
