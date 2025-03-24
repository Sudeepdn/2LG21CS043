package com.example.studentcrud.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.studentcrud.model.Staff;
import com.example.studentcrud.service.StaffService;

@Controller
@RequestMapping("/staff")
public class StaffController {

    private static final Logger logger = LoggerFactory.getLogger(StaffController.class);

    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("staff", staffService.listAll());
        return "staff/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("staff", new Staff());
        return "staff/create";
    }

    @PostMapping("/save")
    public String saveStaff(
        @RequestParam("name") String name,
        @RequestParam("email") String email,
        @RequestParam("phone") String phone,
        @RequestParam("profilepic") MultipartFile profilePic) {

        String uploadDir = System.getProperty("user.dir") + "/upload";
        File uploadFolder = new File(uploadDir);
        if (!uploadFolder.exists()) {
            uploadFolder.mkdirs();
        }

        try {
            String fileName = profilePic.getOriginalFilename();
            File destFile = new File(uploadFolder, fileName);
            profilePic.transferTo(destFile);

            Staff staff = new Staff();
            staff.setName(name);
            staff.setEmail(email);
            staff.setPhone(phone);
            staff.setProfilepic("/upload/" + fileName);

            staffService.saveStaff(staff);
        } catch (IOException e) {
            logger.error("File upload failed", e);
            return "redirect:/staff/create?error=fileUpload";
        }

        return "redirect:/staff/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteStaff(@PathVariable Long id) {
        staffService.deleteStaff(id);
        return "redirect:/staff/list";
    }

    @GetMapping("/edit/{id}")
    public String editStaff(@PathVariable Long id, Model model) {
        Staff staff = staffService.getStaff(id);
        if (staff == null) {
            return "redirect:/staff/list";
        }
        model.addAttribute("staff", staff);
        return "staff/edit";
    }

    @PostMapping("/update/{id}")
    public String updateStaff(@PathVariable Long id, @ModelAttribute Staff staff) {
        staff.setId(id);
        staffService.saveStaff(staff);
        return "redirect:/staff/list";
    }
}
