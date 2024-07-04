// AdminService.java
package com.example.web.service;

import com.example.web.models.Appointment;
import com.example.web.repository.AdminRepository;
import com.example.web.models.MemberAppointment;
import com.example.web.repository.NonMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private NonMemberRepository nonMemberRepository;

    public List<MemberAppointment> getAllAppointments() {
        return adminRepository.findAll();


    }

    public List<Appointment> getAllNonAppointments() {
        return nonMemberRepository.findAll();
    }

}
