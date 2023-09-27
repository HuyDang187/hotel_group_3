package com.project.hotelmanagementsystem.dao;

import com.project.hotelmanagementsystem.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Integer> {
    List<Room> findAll();
    List<Room> findByRoomTitleContainingIgnoreCaseAndRoomTypeContainingIgnoreCase(String titleRoomKey,String typeRoomKey);
    List<Room> findByRoomTitleContainingIgnoreCase(String titleRoomKey);
    List<Room> findByRoomTypeContainingIgnoreCase(String typeRoomKey);
//    List<Room> findByRoomAvailableGreaterThan(int available);
}
