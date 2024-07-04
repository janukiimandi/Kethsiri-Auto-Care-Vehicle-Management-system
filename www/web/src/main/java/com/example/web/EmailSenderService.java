package com.example.web;

import com.example.web.models.Appointment;
import com.example.web.models.MemberAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String toEmail, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("chamipunsara09@gmail.com");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);

        System.out.println("Mail sent successfully!!");
    }

    public void sendBookingConfirmation(Appointment appointment) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(appointment.getEmail());
        message.setSubject("Booking Confirmation");
        message.setText("Dear " + appointment.getName() + ",\n\n"
                + "Thank you for booking a service.\n\n"
                + "Service: " + appointment.getService() + "\n"
                + "Date and Time: " + appointment.getService_datetime() + "\n"
                + "Special Request: " + (appointment.getSpecial_request() != null ? appointment.getSpecial_request() : "None") + "\n\n"
                + "We look forward to serving you.\n\n"
                + "Best regards,\n"
                + "Udara Samaranayaka,\n"
                + "Owner/Auto engineer,\n"
                + "Kethsiri AutoCare");

        mailSender.send(message);

        System.out.println("Mail sent successfully!!");
    }

    public void sendMemberBookingConfirmation(MemberAppointment memberAppointment) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(memberAppointment.getEmail());
        message.setSubject("Booking Confirmation");
        message.setText("Dear " + memberAppointment.getName() + ",\n\n"
                + "Thank you for booking a service.\n\n"
                + "Service: " + memberAppointment.getService() + "\n"
                + "Date and Time: " + memberAppointment.getServiceDatetime() + "\n"
                + "Special Request: " + (memberAppointment.getSpecialRequest() != null ?memberAppointment.getSpecialRequest() : "None") + "\n\n"
                + "We look forward to serving you.\n\n"
                + "Best regards,\n"
                + "Udara Samaranayaka,\n"
                + "Owner/Auto engineer,\n"
                + "Kethsiri AutoCare");

        mailSender.send(message);

        System.out.println("Mail sent successfully!!");
    }
}