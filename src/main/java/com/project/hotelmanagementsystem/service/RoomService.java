package com.project.hotelmanagementsystem.service;

import com.project.hotelmanagementsystem.entity.Room;

import java.util.List;

public interface RoomService {
    List<Room> findAll();
    Room findById(int theId);
    void save(Room theRoom);
    void deleteById(int theId);
    List<Room> searchRoomsByTitleAndType(String titleRoomKey,String typeRoomKey);

}
