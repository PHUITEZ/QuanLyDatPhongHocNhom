package com.group5.main.service;

import com.group5.main.exception.BookingException;
import com.group5.main.model.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoomService {

    private List<Room> rooms = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public List<Room> getAllRooms() {
        return rooms;
    }

    public Room findRoomById(String roomId) throws BookingException {

        return rooms.stream()
                .filter(r -> r.getRoomId().equalsIgnoreCase(roomId))
                .findFirst()
                .orElseThrow(() ->
                        new BookingException(
                                "Loi: Phong co ma " + roomId + " khong ton tai!"
                        ));
    }

    public List<Room> findRoomsByType(String roomType) {

        return rooms.stream()
                .filter(r ->
                        r.getClass().getSimpleName()
                                .equalsIgnoreCase(roomType))
                .collect(Collectors.toList());
    }
}