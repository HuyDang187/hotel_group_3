package com.project.hotelmanagementsystem.service;

import com.project.hotelmanagementsystem.dao.BookingRepository;
import com.project.hotelmanagementsystem.dao.RoomRepository;
import com.project.hotelmanagementsystem.dao.UserRepository;
import com.project.hotelmanagementsystem.entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookingServiceImpl implements BookingService{
     private RoomRepository roomRepository;
     private UserRepository userRepository;
     private BookingRepository bookingRepository;

     @Autowired
     public BookingServiceImpl(RoomRepository theRoomRepository,UserRepository theUserRepository,BookingRepository theBookingRepository  ){
         roomRepository=theRoomRepository;
         userRepository=theUserRepository;
         bookingRepository=theBookingRepository;
     }
     @Override
    public List<Booking> findAll(){
       return bookingRepository.findAll();
     }

}
