package ru.semyak.studentapp.controllers;

import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ru.semyak.studentapp.entities.Student;
import ru.semyak.studentapp.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> findAllStudents() {
        return studentService.findAllStudents();
    }

    @PostMapping("save_student")
    public String saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "человек успешно сохранен";
    }

    @GetMapping("/{email}")
    public Student getStudentByEmail(@PathVariable("email") String email) {
        return studentService.findByEmail(email);
    }

    @PutMapping("update_student")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("delete_student/{email}")
    @Transactional
    public void deleteStudent(@PathVariable String email) {
        studentService.deleteStudentByEmail(email);
    }
}
