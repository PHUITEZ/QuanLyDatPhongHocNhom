package com.group5.main.model;

public class ProjectorRoom extends Room {
    public ProjectorRoom(String roomId, String roomName, int floor, int maxCapacity, String status) {
        super(roomId, roomName, floor, maxCapacity, status, hours -> hours * 50000.0);
    }
}