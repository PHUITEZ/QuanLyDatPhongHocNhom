package com.group5.main;

import com.group5.main.model.*;
import com.group5.main.service.BookingService;
import com.group5.main.service.RoomService;
import com.group5.main.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    @Bean
    public RoomService roomService() {

        RoomService service = new RoomService();

        if (service.getAllRooms().isEmpty()) {

            service.addRoom(new NormalRoom(
                    "R001", "Phong Hoc 101", 1, 10, "San sang"));

            service.addRoom(new NormalRoom(
                    "R002", "Phong Hoc 102", 1, 15, "San sang"));

            service.addRoom(new NormalRoom(
                    "R003", "Phong Hoc 103", 2, 20, "San sang"));

            service.addRoom(new ProjectorRoom(
                    "R004", "Phong May Chieu A", 2, 25, "San sang"));

            service.addRoom(new ProjectorRoom(
                    "R005", "Phong May Chieu B", 3, 30, "San sang"));

            service.addRoom(new ProjectorRoom(
                    "R006", "Phong May Chieu C", 3, 35, "San sang"));

            service.addRoom(new SeminarRoom(
                    "R007", "Phong Hoi Thao A", 4, 50, "San sang"));

            service.addRoom(new SeminarRoom(
                    "R008", "Phong Hoi Thao B", 4, 80, "San sang"));

            service.addRoom(new SeminarRoom(
                    "R009", "Phong Hoi Thao C", 5, 100, "San sang"));
        }

        return service;
    }

    @Bean
    public StudentService studentService() {

        StudentService service = new StudentService();

        if (service.getAllStudents().isEmpty()) {

            service.addStudent(new Student(
                    "SV001",
                    "Nguyen Van A",
                    "0901111111",
                    "CNTT01",
                    "a@gmail.com"));

            service.addStudent(new Student(
                    "SV002",
                    "Tran Thi B",
                    "0902222222",
                    "CNTT02",
                    "b@gmail.com"));

            service.addStudent(new Student(
                    "SV003",
                    "Le Van C",
                    "0903333333",
                    "CNTT03",
                    "c@gmail.com"));

            service.addStudent(new Student(
                    "SV004",
                    "Pham Thi D",
                    "0904444444",
                    "CNTT04",
                    "d@gmail.com"));

            service.addStudent(new Student(
                    "SV005",
                    "Hoang Van E",
                    "0905555555",
                    "CNTT05",
                    "e@gmail.com"));

            service.addStudent(new Student(
                    "SV006",
                    "Nguyen Thi F",
                    "0906666666",
                    "CNTT06",
                    "f@gmail.com"));
        }

        return service;
    }

    @Bean
    public BookingService bookingService(
            StudentService studentService,
            RoomService roomService) {

        BookingService service =
                new BookingService(studentService, roomService);

        if (service.getBookings().isEmpty()) {

            try {

                service.createBooking(
                        "SV001",
                        "R001",
                        new TimeSlot(
                                LocalDateTime.now(),
                                LocalDateTime.now().plusHours(2)),
                        5);

                service.createBooking(
                        "SV002",
                        "R004",
                        new TimeSlot(
                                LocalDateTime.now().plusDays(1),
                                LocalDateTime.now().plusDays(1).plusHours(3)),
                        15);

                service.createBooking(
                        "SV003",
                        "R007",
                        new TimeSlot(
                                LocalDateTime.now().plusDays(2),
                                LocalDateTime.now().plusDays(2).plusHours(4)),
                        40);

                service.createBooking(
                        "SV004",
                        "R003",
                        new TimeSlot(
                                LocalDateTime.now().plusDays(3),
                                LocalDateTime.now().plusDays(3).plusHours(2)),
                        10);

                service.createBooking(
                        "SV005",
                        "R005",
                        new TimeSlot(
                                LocalDateTime.now().plusDays(4),
                                LocalDateTime.now().plusDays(4).plusHours(3)),
                        20);

                service.createBooking(
                        "SV006",
                        "R008",
                        new TimeSlot(
                                LocalDateTime.now().plusDays(5),
                                LocalDateTime.now().plusDays(5).plusHours(5)),
                        60);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return service;
    }
}