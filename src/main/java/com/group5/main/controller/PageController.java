package com.group5.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/rooms-page")
    public String rooms() {
        return "rooms";
    }

    @GetMapping("/students-page")
    public String students() {
        return "students";
    }

    @GetMapping("/bookings-page")
    public String bookings() {
        return "bookings";
    }
}