package com.project.hotelmanagementsystem.service;

import com.project.hotelmanagementsystem.dao.RoomRepository;
import com.project.hotelmanagementsystem.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository ;

    @Autowired
    public RoomServiceImpl(RoomRepository theRoomRepository){

         roomRepository=theRoomRepository;
    }

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public Room findById(int theId) {
        Optional<Room> result = roomRepository.findById(theId);
        Room theRoom = null;
        if (result.isPresent()) {
            theRoom = result.get();

        } else {
            throw new RuntimeException("Did not find the Room id - " + theId);
        }
        return theRoom;
    }

    @Override
    public void save(Room theRoom) {
            roomRepository.save(theRoom);
    }

    @Override
    public void deleteById(int theId) {
            roomRepository.deleteById(theId);
    }
}
