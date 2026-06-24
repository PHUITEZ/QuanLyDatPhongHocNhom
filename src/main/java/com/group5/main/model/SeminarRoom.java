package com.group5.main.model;

public class SeminarRoom extends Room {
    public SeminarRoom(String roomId, String roomName, int floor, int maxCapacity, String status) {
        super(roomId, roomName, floor, maxCapacity, status, hours -> hours * 100000.0);
    }
}