package com.example.web.service;

import com.example.web.models.Appointment;
import com.example.web.models.User;
import com.example.web.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentService {

     @Autowired
     private AppointmentRepository appointmentRepository;

    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public int getOrderCount() {
        return appointmentRepository.getOrderCount();
    }
}
