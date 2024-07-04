package com.example.web.service;


import com.example.web.models.MemberAppointment;
import com.example.web.repository.MemberAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.web.EmailSenderService;

@Service
public class MemberAppointmentService {

    @Autowired
    private MemberAppointmentRepository memberAppointmentRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    public void addAppointment(MemberAppointment memberAppointment) {
        // Save the appointment
        memberAppointmentRepository.save(memberAppointment);

        // Send booking confirmation email
        emailSenderService.sendMemberBookingConfirmation(memberAppointment);
    }

    public int getOrderCount() {
        return memberAppointmentRepository.getOrderCount();
    }
}
