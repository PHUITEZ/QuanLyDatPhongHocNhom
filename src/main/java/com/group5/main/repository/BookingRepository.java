package com.group5.main.repository;

import com.group5.main.model.Booking;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class BookingRepository {

    public void saveBookings(List<Booking> dsDatPhong) {

        try {
            FileOutputStream fos = new FileOutputStream("bookings.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(dsDatPhong);

            oos.close();
            fos.close();

        } catch (Exception e) {
            System.out.println("Loi khi ghi file bookings.dat: " + e.getMessage());
        }
    }

    public List<Booking> loadBookings() {

        List<Booking> dsDatPhong = new ArrayList<>();

        try {

            FileInputStream fis = new FileInputStream("bookings.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);

            dsDatPhong = (List<Booking>) ois.readObject();

            ois.close();
            fis.close();

        } catch (Exception e) {
            // Nếu file chưa tồn tại thì trả về danh sách rỗng
        }

        return dsDatPhong;
    }
}