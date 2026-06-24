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

        service.addRoom(
                new NormalRoom(
                        "R001",
                        "Phong Hoc 101",
                        1,
                        10,
                        "San sang"
                )
        );

        service.addRoom(
                new ProjectorRoom(
                        "R002",
                        "Phong May Chieu",
                        2,
                        20,
                        "San sang"
                )
        );

        service.addRoom(
                new SeminarRoom(
                        "R003",
                        "Phong Hoi Thao",
                        3,
                        50,
                        "San sang"
                )
        );

        return service;
    }

    @Bean
    public StudentService studentService() {

        StudentService service = new StudentService();

        service.addStudent(
                new Student(
                        "SV001",
                        "Nguyen Van A",
                        "0901234567",
                        "CNTT01",
                        "a@gmail.com"
                )
        );

        service.addStudent(
                new Student(
                        "SV002",
                        "Tran Thi B",
                        "0907654321",
                        "CNTT02",
                        "b@gmail.com"
                )
        );

        return service;
    }

    @Bean
    public BookingService bookingService(
            StudentService studentService,
            RoomService roomService
    ) {

        BookingService service =
                new BookingService(studentService, roomService);

        try {

            service.createBooking(
                    "SV001",
                    "R001",
                    new TimeSlot(
                            LocalDateTime.now(),
                            LocalDateTime.now().plusHours(2)
                    ),
                    5
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return service;
    }
}