package com.group5.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {

    @GetMapping("/rooms")
    public String test() {
        return "Rooms API OK";
    }
}