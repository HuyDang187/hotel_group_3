package com.project.hotelmanagementsystem.dao;

import com.project.hotelmanagementsystem.entity.Booking;
import com.project.hotelmanagementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findAll();
    User findByUsername(String userName);
}
