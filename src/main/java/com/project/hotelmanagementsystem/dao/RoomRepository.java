package com.project.hotelmanagementsystem.dao;

import com.project.hotelmanagementsystem.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Integer> {
    List<Room> findAll();
}
