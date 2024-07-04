package com.example.web.controller;

import com.example.web.EmailSenderService;
import com.example.web.models.Appointment;
import com.example.web.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private EmailSenderService emailSenderService;

    @PostMapping("/bookings")
    public ResponseEntity<String> submitBookingForm(@ModelAttribute Appointment appointment) {
        try {
            appointmentService.saveAppointment(appointment);
            emailSenderService.sendBookingConfirmation(appointment);
            return ResponseEntity.ok("Booking submitted successfully.");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("The selected date and time are not available. Please choose another time.");
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }


    @GetMapping("/order-count")
    public ResponseEntity<Integer> getOrderCount() {
        int orderCount = appointmentService.getOrderCount();
        return ResponseEntity.ok(orderCount);
    }
}
