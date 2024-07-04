package com.example.web.repository;

import com.example.web.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUsername(String username);

    @Query(value = "SELECT COUNT(*) FROM user", nativeQuery = true)
    int getMemberCount();

}
