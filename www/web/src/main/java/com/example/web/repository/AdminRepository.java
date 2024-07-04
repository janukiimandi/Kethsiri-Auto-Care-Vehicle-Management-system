package com.example.web.repository;


import com.example.web.models.MemberAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<MemberAppointment, Integer> {

    @Query(value = "SELECT * FROM member_appointment", nativeQuery = true)
    List<MemberAppointment> findAll();



}
