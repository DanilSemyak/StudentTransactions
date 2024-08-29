package ru.semyak.studentapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.semyak.studentapp.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    void deleteByEmail(String email);
    Student findStudentByEmail(String email);

}
