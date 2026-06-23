package com.group5.main.controller;

import model.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private List<Booking> bookings = new ArrayList<>();

    public BookingController() {

        Student student = new Student(
                "SV001",
                "Nguyen Van A",
                "0912345678",
                "CNTT01",
                "a@gmail.com"
        );

        Room room = new NormalRoom(
                "R001",
                "A6:401-402",
                1,
                20,
                "AVAILABLE"
        );

        TimeSlot slot = new TimeSlot(
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(2)
        );

        bookings.add(
                new Booking(
                        "B001",
                        student,
                        room,
                        slot,
                        10,
                        "BOOKED",
                        50000
                )
        );
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookings;
    }
}