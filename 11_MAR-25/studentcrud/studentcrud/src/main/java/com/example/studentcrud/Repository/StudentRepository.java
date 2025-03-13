package main.java.com.example.studentcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentcrud.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    
}