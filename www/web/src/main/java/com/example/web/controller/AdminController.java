// AdminController.java
package com.example.web.controller;

import com.example.web.models.Appointment;
import com.example.web.service.AdminService;
import com.example.web.models.MemberAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/getappointments")
    public List<MemberAppointment> getAllAppointments() {
        return adminService.getAllAppointments();
    }

    @GetMapping("/getnonmemberappointments")
    public List<Appointment> getAllNonAppointments() {
        return adminService.getAllNonAppointments();
    }
}
