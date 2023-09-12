package com.project.hotelmanagementsystem.dao;

import com.project.hotelmanagementsystem.entity.Booking;
import com.project.hotelmanagementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface BookingRepository extends JpaRepository<Booking,Integer> {
    List<Booking> findAll();
    List<User> findByUser_id(int theUserId);

}
