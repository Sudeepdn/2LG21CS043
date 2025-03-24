package com.example.studentcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.studentcrud.model.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
}
