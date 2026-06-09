package model;

import interfaces.Bookable;
import interfaces.RoomFeePolicy;

public abstract class Room implements Bookable, RoomFeePolicy {
    private String roomId;
    private String roomName;
    private int capacity;
    private boolean available;

    public Room(String roomId, String roomName, int capacity) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.capacity = capacity;
        this.available = true;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public boolean bookRoom() {
        if (available) {
            available = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean cancelBooking() {
        if (!available) {
            available = true;
            return true;
        }
        return false;
    }


    public abstract void displayInfo();
}