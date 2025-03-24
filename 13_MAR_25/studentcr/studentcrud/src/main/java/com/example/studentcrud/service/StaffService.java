package com.example.studentcrud.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.studentcrud.model.Staff;
import com.example.studentcrud.repository.StaffRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public List<Staff> listAll() {
        return staffRepository.findAll();
    }

    public void saveStaff(Staff staff) {
        if (staff == null) {
            throw new IllegalArgumentException("Staff object cannot be null");
        }
        staffRepository.save(staff);
    }

    public Staff getStaff(Long id) {
        return staffRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Staff not found with ID: " + id));
    }

    public void deleteStaff(Long id) {
        if (!staffRepository.existsById(id)) {
            throw new EntityNotFoundException("Cannot delete. Staff not found with ID: " + id);
        }
        staffRepository.deleteById(id);
    }
}
