package com.group5.main.model;

public class NormalRoom extends Room {
    public NormalRoom(String roomId, String roomName, int floor, int maxCapacity, String status) {
        super(roomId, roomName, floor, maxCapacity, status, hours -> 0.0);
    }
}