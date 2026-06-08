package repository;

import model.Booking;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BookingRepository {

    public void saveBookings(ArrayList<Booking> dsDatPhong) {
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

    public ArrayList<Booking> loadBookings() {
        ArrayList<Booking> dsDatPhong = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("bookings.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);

            // Ép kiểu
            dsDatPhong = (ArrayList<Booking>) ois.readObject();

            ois.close();
            fis.close();
        } catch (Exception e) {
            // Sinh viên thường để trống catch nếu chỉ muốn khởi tạo file mới
        }
        return dsDatPhong;
    }
}