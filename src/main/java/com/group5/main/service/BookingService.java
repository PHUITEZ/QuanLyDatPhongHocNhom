package com.group5.main.service;

import com.group5.main.exception.BookingException;
import com.group5.main.model.Booking;
import com.group5.main.model.Room;
import com.group5.main.model.Student;
import com.group5.main.model.TimeSlot;
import com.group5.main.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

@Service
public class BookingService {

    private List<Booking> bookings;

    private final BookingRepository bookingRepository =
            new BookingRepository();

    private final StudentService studentService;
    private final RoomService roomService;

    public BookingService(StudentService studentService,
                          RoomService roomService) {

        this.studentService = studentService;
        this.roomService = roomService;

        this.bookings = bookingRepository.loadBookings();
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public Booking createBooking(
            String studentId,
            String roomId,
            TimeSlot timeSlot,
            int numberOfParticipants)
            throws BookingException {

        if (timeSlot.getEndTime().isBefore(timeSlot.getStartTime())
                || timeSlot.getEndTime().equals(timeSlot.getStartTime())) {

            throw new BookingException(
                    "Loi: Thoi gian ket thuc phai lon hon thoi gian bat dau!");
        }

        Student student =
                studentService.findStudentById(studentId);

        Room room =
                roomService.findRoomById(roomId);

        if ("Dang bao tri".equalsIgnoreCase(room.getStatus())) {

            throw new BookingException(
                    "Loi: Phong "
                            + roomId
                            + " dang bao tri!");
        }

        if (numberOfParticipants >
                room.getMaxCapacity()) {

            throw new BookingException(
                    "Loi: Vuot qua suc chua toi da cua phong!");
        }

        for (Booking b : bookings) {

            if (b.getRoom()
                    .getRoomId()
                    .equalsIgnoreCase(roomId)
                    &&
                    "Da dat".equalsIgnoreCase(
                            b.getStatus())) {

                if (isTimeOverlapping(
                        timeSlot,
                        b.getTimeSlot())) {

                    throw new BookingException(
                            "Loi: Phong da trung lich!");
                }
            }
        }

        long hoursRequested =
                Duration.between(
                                timeSlot.getStartTime(),
                                timeSlot.getEndTime())
                        .toHours();

        String bookingId =
                "BK-"
                        + UUID.randomUUID()
                        .toString()
                        .substring(0, 8)
                        .toUpperCase();

        double totalFee = 0;

        if (room.getFeePolicy() != null) {

            totalFee =
                    room.getFeePolicy()
                            .calculateFee(hoursRequested);
        }

        Booking newBooking =
                new Booking(
                        bookingId,
                        student,
                        room,
                        timeSlot,
                        numberOfParticipants,
                        "Da dat",
                        totalFee);

        bookings.add(newBooking);

        bookingRepository.saveBookings(bookings);

        return newBooking;
    }

    public void cancelBooking(
            String bookingId,
            String studentId)
            throws BookingException {

        Booking booking =
                bookings.stream()
                        .filter(b ->
                                b.getBookingId()
                                        .equalsIgnoreCase(
                                                bookingId))
                        .findFirst()
                        .orElseThrow(() ->
                                new BookingException(
                                        "Khong tim thay lich dat"));

        if (!booking.getStudent()
                .getStudentId()
                .equalsIgnoreCase(studentId)) {

            throw new BookingException(
                    "Ban khong duoc huy lich dat nay");
        }

        booking.setStatus("Da huy");

        bookingRepository.saveBookings(bookings);
    }

    private boolean isTimeOverlapping(
            TimeSlot slot1,
            TimeSlot slot2) {

        return slot1.getStartTime()
                .isBefore(slot2.getEndTime())
                &&
                slot1.getEndTime()
                        .isAfter(slot2.getStartTime());
    }
}