package com.group5.main.repository;

import com.group5.main.model.Room;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
public class RoomRepository {

    // Ghi dữ liệu mảng ArrayList xuống file
    public void saveRooms(List<Room> dsPhong){
        try {
            FileOutputStream fos = new FileOutputStream("rooms.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(dsPhong);

            // Đóng luồng theo thứ tự
            oos.close();
            fos.close();
        } catch (Exception e) {
            System.out.println("Loi khi ghi file rooms.dat: " + e.getMessage());
        }
    }

    // Đọc dữ liệu từ file lên ArrayList
    public ArrayList<Room> loadRooms() {
        ArrayList<Room> dsPhong = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("rooms.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);

            // Ép kiểu Object về dạng ArrayList<Room>
            dsPhong = (ArrayList<Room>) ois.readObject();

            ois.close();
            fis.close();
        } catch (Exception e) {
            // Nếu lỗi (ví dụ file chưa có lúc mới chạy), bỏ qua và trả về mảng rỗng
        }
        return dsPhong;
    }
}