package com.group5.main.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.group5.main.interfaces.RoomFeePolicy;

import java.io.Serializable;

public abstract class Room implements Serializable {

    private static final long serialVersionUID = 1L;

    private String roomId;
    private String roomName;
    private int floor;
    private int maxCapacity;
    private String status;

    @JsonIgnore
    private transient RoomFeePolicy feePolicy;

    public Room() {
    }

    public Room(String roomId, String roomName, int floor,
                int maxCapacity, String status,
                RoomFeePolicy feePolicy) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.floor = floor;
        this.maxCapacity = maxCapacity;
        this.status = status;
        this.feePolicy = feePolicy;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RoomFeePolicy getFeePolicy() {
        return feePolicy;
    }

    public void setFeePolicy(RoomFeePolicy feePolicy) {
        this.feePolicy = feePolicy;
    }
}