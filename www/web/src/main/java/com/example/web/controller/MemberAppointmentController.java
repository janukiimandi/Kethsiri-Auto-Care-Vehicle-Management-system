package com.example.web.controller;

import com.example.web.service.MemberAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;


import com.example.web.models.MemberAppointment;
import com.example.web.service.MemberAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class MemberAppointmentController {

    @Autowired
    private MemberAppointmentService memberAppointmentService;

    @PostMapping("/appointments")
    public String addAppointment(@RequestParam("name") String name,
                                 @RequestParam("email") String email,
                                 @RequestParam("service") String service,
                                 @RequestParam("serviceDatetime") String serviceDatetimeStr,
                                 @RequestParam("specialRequest") String specialRequest) {
        // Parse the serviceDatetime string into a Date object
        Date serviceDatetime;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
            serviceDatetime = formatter.parse(serviceDatetimeStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return "Error parsing serviceDatetime";
        }

        // Create a MemberAppointment object from the request parameters
        MemberAppointment appointment = new MemberAppointment();
        appointment.setName(name);
        appointment.setEmail(email);
        appointment.setService(service);
        appointment.setServiceDatetime(serviceDatetime);
        appointment.setSpecialRequest(specialRequest);

        // Add the appointment using the service
        memberAppointmentService.addAppointment(appointment);

        return "Appointment added successfully";
    }

    @GetMapping("/memberorder-count")
    public ResponseEntity<Integer> getOrderCount() {
        int orderCount = memberAppointmentService.getOrderCount();
        return ResponseEntity.ok(orderCount);
    }
}