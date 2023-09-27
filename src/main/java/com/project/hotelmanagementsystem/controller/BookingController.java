package com.project.hotelmanagementsystem.controller;

import com.project.hotelmanagementsystem.entity.Booking;
import com.project.hotelmanagementsystem.service.BookingService;
import com.project.hotelmanagementsystem.service.RoomService;
import com.project.hotelmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookings")
public class BookingController {
    private BookingService bookingService;


    private BookingController(BookingService theBookingController){
        bookingService=theBookingController;

    }

}
