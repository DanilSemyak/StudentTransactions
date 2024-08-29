package ru.semyak.studentapp.repositories;

import com.sun.jdi.StackFrame;
import org.apache.logging.log4j.util.StackLocatorUtil;
import org.springframework.stereotype.Repository;
import ru.semyak.studentapp.entities.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryPersonDAO {

    private final List<Student> STUDENTS = new ArrayList<>();

    public List<Student> findAllStudents() {
        return STUDENTS;
    }

    public Student saveStudent(Student student) {
        STUDENTS.add(student);
        return student;
    }

    public Student findByEmail(String email) {
        return STUDENTS.stream().filter(student -> student.getEmail()
                .equals(email)).findFirst().orElse(null);
    }

    public Student updateStudent(Student student) {

        int studentIndex = IntStream.range(0, STUDENTS.size())
                .filter(index -> STUDENTS.get(index).getEmail().equals(student.getEmail()))
                .findFirst().orElse(-1);
        if (studentIndex > -1) {
            STUDENTS.set(studentIndex, student);
            return student;
        }
        return null;
    }

    public void deleteStudent(String email) {
        Student student = findByEmail(email);
        if (student != null)
            STUDENTS.remove(student);
    }
}
