package com.project.hotelmanagementsystem.controller;

import com.project.hotelmanagementsystem.entity.Room;
import com.project.hotelmanagementsystem.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    private RoomService roomService;

    public RoomController(RoomService theRoomController){

        roomService = theRoomController;
    }
    @GetMapping("/list")
    public String listRoom(Model theModel){
        List<Room> theRooms = roomService.findAll();
        theModel.addAttribute("rooms",theRooms);
        return "rooms.html";
    }
}
