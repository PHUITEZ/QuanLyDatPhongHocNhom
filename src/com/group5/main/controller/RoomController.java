package com.group5.main.controller;

import model.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private List<Room> rooms = new ArrayList<>();

    public RoomController() {

        rooms.add(new NormalRoom(
                "R001",
                "A6:401-402",
                1,
                20,
                "AVAILABLE"
        ));

        rooms.add(new ProjectorRoom(
                "R002",
                "A6-205",
                2,
                30,
                "AVAILABLE"
        ));

        rooms.add(new SeminarRoom(
                "R003",
                "A2-101",
                3,
                100,
                "AVAILABLE"
        ));
    }

    @GetMapping
    public List<Room> getAllRooms() {
        return rooms;
    }
}