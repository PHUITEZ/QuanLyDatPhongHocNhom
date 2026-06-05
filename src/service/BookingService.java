package service;

import model.*;
import exception.BookingException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.time.Duration;

public class BookingService {
    private List<Booking> bookings = new ArrayList<>();
    private StudentService studentService;
    private RoomService roomService;

    public BookingService(StudentService studentService, RoomService roomService) {
        this.studentService = studentService;
        this.roomService = roomService;
    }

    public Booking createBooking(String studentId, String roomId, TimeSlot timeSlot, int numberOfParticipants) throws BookingException {
        if (timeSlot.getEndTime().isBefore(timeSlot.getStartTime()) || timeSlot.getEndTime().equals(timeSlot.getStartTime())) {
            throw new BookingException("Loi: Thoi gian ket thuc phai lon hon thoi gian bat dau!");
        }

        Student student = studentService.findStudentById(studentId);
        Room room = roomService.findRoomById(roomId);

        if ("Dang bao tri".equalsIgnoreCase(room.getStatus())) {
            throw new BookingException("Loi: Phong " + roomId + " dang trong qua trinh bao tri, khong the dat!");
        }

        if (numberOfParticipants > room.getMaxCapacity()) {
            throw new BookingException("Loi: So luong nguoi tham gia (" + numberOfParticipants + ") vuot qua suc chua toi da cua phong (" + room.getMaxCapacity() + ")!");
        }

        for (Booking b : bookings) {
            if (b.getRoom().getRoomId().equalsIgnoreCase(roomId) && "Da dat".equalsIgnoreCase(b.getStatus())) {
                if (isTimeOverlapping(timeSlot, b.getTimeSlot())) {
                    throw new BookingException("Loi: Phong " + roomId + " da bi trung lich dat trong khoang thoi gian nay!");
                }
            }
        }

        long hoursRequested = Duration.between(timeSlot.getStartTime(), timeSlot.getEndTime()).toHours();
        long totalHoursBookedToday = 0;
        for (Booking b : bookings) {
            if (b.getStudent().getStudentId().equalsIgnoreCase(studentId)
                    && "Da dat".equalsIgnoreCase(b.getStatus())
                    && b.getTimeSlot().getStartTime().toLocalDate().equals(timeSlot.getStartTime().toLocalDate())) {
                totalHoursBookedToday += Duration.between(b.getTimeSlot().getStartTime(), b.getTimeSlot().getEndTime()).toHours();
            }
        }
        if (totalHoursBookedToday + hoursRequested > 4) {
            throw new BookingException("Loi: Sinh vien khong duoc phep dat qua 4 gio trong mot ngay! (Da dat: " + totalHoursBookedToday + "h, Dang ky them: " + hoursRequested + "h)");
        }

        String bookingId = "BK-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();

        double totalFee = 0;
        if (room.getFeePolicy() != null) {
            totalFee = room.getFeePolicy().calculateFee(hoursRequested);
        }

        Booking newBooking = new Booking(bookingId, student, room, timeSlot, numberOfParticipants, "Da dat", totalFee);
        bookings.add(newBooking);

        System.out.println("Chuc mung! Dat phong thanh cong. Ma dat phong cua ban la: " + bookingId);
        return newBooking;
    }

    public void cancelBooking(String bookingId, String studentId) throws BookingException {
        Booking booking = bookings.stream()
                .filter(b -> b.getBookingId().equalsIgnoreCase(bookingId))
                .findFirst()
                .orElseThrow(() -> new BookingException("Loi: Ma dat phong " + bookingId + " khong ton tai tren he thong!"));

        if ("Da huy".equalsIgnoreCase(booking.getStatus())) {
            throw new BookingException("Loi: Lich dat phong nay da bi huy truoc do roi!");
        }

        if (!booking.getStudent().getStudentId().equalsIgnoreCase(studentId)) {
            throw new BookingException("Loi: Ban khong the huy lich dat phong cua sinh vien khac!");
        }

        booking.setStatus("Da huy");
        System.out.println("Huy lich dat phong thanh cong cho ma dat: " + bookingId);
    }

    public List<Booking> getBookingsByStudent(String studentId) {
        List<Booking> result = new ArrayList<>();
        for (Booking b : bookings) {
            if (b.getStudent().getStudentId().equalsIgnoreCase(studentId)) {
                result.add(b);
            }
        }
        return result;
    }

    private boolean isTimeOverlapping(TimeSlot slot1, TimeSlot slot2) {
        return slot1.getStartTime().isBefore(slot2.getEndTime()) && slot1.getEndTime().isAfter(slot2.getStartTime());
    }
}