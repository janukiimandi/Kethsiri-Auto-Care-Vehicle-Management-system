package com.example.web.repository;

import com.example.web.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    @Query(value = "SELECT COUNT(*) FROM Appointment", nativeQuery = true)
    int getOrderCount();

}
