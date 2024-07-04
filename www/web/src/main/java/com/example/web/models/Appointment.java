package com.example.web.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Booking_ID;

    private String Name;
    private String Email;
    private String Service;
    @Column(unique = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date service_datetime;
    private String Special_request;


    public  Appointment()
    {

    }

    public int getBooking_ID() {
        return Booking_ID;
    }

    public void setBooking_ID(int booking_ID) {
        Booking_ID = booking_ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getService() {
        return Service;
    }

    public void setService(String service) {
        Service = service;
    }

    public Date getService_datetime() {
        return service_datetime;
    }

    public void setService_datetime(Date service_datetime) {
        this.service_datetime = service_datetime;
    }

    public String getSpecial_request() {
        return Special_request;
    }

    public void setSpecial_request(String special_request) {
        Special_request = special_request;
    }
}

