package com.project.hotelmanagementsystem.controller.admin;

import com.project.hotelmanagementsystem.entity.Room;
import com.project.hotelmanagementsystem.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/rooms")
public class AdminRoomController {

    private RoomService roomService;

    public AdminRoomController(RoomService theAdminController){
        roomService = theAdminController;
    }
    @GetMapping("/list")
    public String getListRoom(Model theModel) {
        List<Room> theRooms = roomService.findAll();
        theModel.addAttribute("rooms",theRooms);
        return "/admin/room/list-room.html";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Room newRoom = new Room();
        model.addAttribute("room",newRoom);
        return "/admin/room/room-form";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForAdd(@RequestParam("roomId") int theId,Model theModel){
        //get room from service
        Room theRoom = roomService.findById(theId);

        theModel.addAttribute("room",theRoom);
        return "/admin/room/room-form";
    }

    @PostMapping("/save")
    public String saveRoom(@ModelAttribute("room")Room theRoom){
            roomService.save(theRoom);
            return "redirect:/admin/rooms/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("roomId")int theId){
        roomService.deleteById(theId);
        return "redirect:/admin/rooms/list";
    }
}
