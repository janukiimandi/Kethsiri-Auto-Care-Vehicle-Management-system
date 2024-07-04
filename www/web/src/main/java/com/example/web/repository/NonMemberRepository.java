package com.example.web.repository;

import com.example.web.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NonMemberRepository extends JpaRepository<Appointment,Integer> {

    @Query(value = "SELECT * FROM appointment", nativeQuery = true)
    List<Appointment> findAll();

}
