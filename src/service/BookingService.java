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
            throw new BookingException("Lỗi: Thời gian kết thúc phải lớn hơn thời gian bắt đầu!");
        }

        Student student = studentService.findStudentById(studentId);

        Room room = roomService.findRoomById(roomId);

        if ("Đang bảo trì".equalsIgnoreCase(room.getStatus())) {
            throw new BookingException("Lỗi: Phòng " + roomId + " đang trong quá trình bảo trì, không thể đặt!");
        }

        if (numberOfParticipants > room.getMaxCapacity()) {
            throw new BookingException("Lỗi: Số lượng người tham gia (" + numberOfParticipants + ") vượt quá sức chứa tối đa của phòng (" + room.getMaxCapacity() + ")!");
        }

        for (Booking b : bookings) {
            if (b.getRoom().getRoomId().equalsIgnoreCase(roomId) && "Đã đặt".equalsIgnoreCase(b.getStatus())) {
                if (isTimeOverlapping(timeSlot, b.getTimeSlot())) {
                    throw new BookingException("Lỗi: Phòng " + roomId + " đã bị trùng lịch đặt trong khoảng thời gian này!");
                }
            }
        }

        long hoursRequested = Duration.between(timeSlot.getStartTime(), timeSlot.getEndTime()).toHours();
        long totalHoursBookedToday = 0;
        for (Booking b : bookings) {
            if (b.getStudent().getStudentId().equalsIgnoreCase(studentId)
                    && "Đã đặt".equalsIgnoreCase(b.getStatus())
                    && b.getTimeSlot().getStartTime().toLocalDate().equals(timeSlot.getStartTime().toLocalDate())) {
                totalHoursBookedToday += Duration.between(b.getTimeSlot().getStartTime(), b.getTimeSlot().getEndTime()).toHours();
            }
        }
        if (totalHoursBookedToday + hoursRequested > 4) {
            throw new BookingException("Lỗi: Sinh viên không được phép đặt quá 4 giờ trong một ngày! (Đã đặt: " + totalHoursBookedToday + "h, Đăng ký thêm: " + hoursRequested + "h)");
        }

        String bookingId = "BK-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();

        double totalFee = 0;
        if (room.getFeePolicy() != null) {
            totalFee = room.getFeePolicy().calculateFee(hoursRequested);
        }

        Booking newBooking = new Booking(bookingId, student, room, timeSlot, numberOfParticipants, "Đã đặt", totalFee);
        bookings.add(newBooking);

        System.out.println("Chúc mừng! Đặt phòng thành công. Mã đặt phòng của bạn là: " + bookingId);
        return newBooking;
    }

    public void cancelBooking(String bookingId, String studentId) throws BookingException {
        Booking booking = bookings.stream()
                .filter(b -> b.getBookingId().equalsIgnoreCase(bookingId))
                .findFirst()
                .orElseThrow(() -> new BookingException("Lỗi: Mã đặt phòng " + bookingId + " không tồn tại trên hệ thống!"));

        if ("Đã hủy".equalsIgnoreCase(booking.getStatus())) {
            throw new BookingException("Lỗi: Lịch đặt phòng này đã bị hủy trước đó rồi!");
        }

        if (!booking.getStudent().getStudentId().equalsIgnoreCase(studentId)) {
            throw new BookingException("Lỗi: Bạn không thể hủy lịch đặt phòng của sinh viên khác!");
        }

        booking.setStatus("Đã hủy");
        System.out.println("Hủy lịch đặt phòng thành công cho mã đặt: " + bookingId);
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