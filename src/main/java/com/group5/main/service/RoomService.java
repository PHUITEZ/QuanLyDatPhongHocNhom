package com.group5.main.service;

import com.group5.main.exception.BookingException;
import com.group5.main.model.Room;
import com.group5.main.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {

    private final RoomRepository roomRepository = new RoomRepository();

    private List<Room> rooms;

    public RoomService() {
        rooms = roomRepository.loadRooms();
    }

    public void addRoom(Room room) {
        rooms.add(room);
        roomRepository.saveRooms(rooms);
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
                                "Loi: Phong co ma "
                                        + roomId
                                        + " khong ton tai!"
                        ));
    }

    public List<Room> findRoomsByType(String roomType) {

        return rooms.stream()
                .filter(r ->
                        r.getClass()
                                .getSimpleName()
                                .equalsIgnoreCase(roomType))
                .collect(Collectors.toList());
    }

    public void saveData() {
        roomRepository.saveRooms(rooms);
    }
}