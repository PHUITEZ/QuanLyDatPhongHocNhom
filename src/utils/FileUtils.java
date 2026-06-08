package utils;

import model.Room;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileUtils {

    public static void saveRooms(List<Room> rooms,
                                 String fileName) {

        try (FileWriter writer = new FileWriter(fileName)) {

            for (Room room : rooms) {

                writer.write(
                        room.getRoomId() + "," + room.getRoomName() + "," + room.getCapacity() + "\n");
            }

            System.out.println("Luu file thanh cong!");

        } catch (IOException e) {

            System.out.println("Loi ghi file!");
        }
    }
}