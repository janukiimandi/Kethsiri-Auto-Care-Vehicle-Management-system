package com.example.web.repository;

import com.example.web.models.MemberAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

import com.example.web.models.MemberAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberAppointmentRepository extends JpaRepository<MemberAppointment, Integer> {

    @Query(value = "SELECT COUNT(*) FROM member_appointment", nativeQuery = true)
    int getOrderCount();
}

