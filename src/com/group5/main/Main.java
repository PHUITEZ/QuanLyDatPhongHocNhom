package com.group5.main;

import model.*;
import utils.IdGenerator;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Room> rooms = new ArrayList<>();

        rooms.add(new NormalRoom(
                IdGenerator.generateRoomId(),
                "A101",
                1,
                20,
                "AVAILABLE"
        ));

        rooms.add(new ProjectorRoom(
                IdGenerator.generateRoomId(),
                "B202",
                2,
                30,
                "AVAILABLE"
        ));

        rooms.add(new SeminarRoom(
                IdGenerator.generateRoomId(),
                "C303",
                3,
                100,
                "AVAILABLE"
        ));

        int choice;

        do {

            System.out.println("\n================================");
            System.out.println(" HE THONG QUAN LY DAT PHONG HOC ");
            System.out.println("================================");
            System.out.println("1. Xem danh sach phong");
            System.out.println("2. Them phong moi");
            System.out.println("3. Tim phong theo ID");
            System.out.println("4. Tinh phi su dung phong");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("\nDANH SACH PHONG:");

                    for (Room room : rooms) {

                        System.out.println(
                                room.getRoomId()
                                        + " | "
                                        + room.getRoomName()
                                        + " | Tang "
                                        + room.getFloor()
                                        + " | Suc chua "
                                        + room.getMaxCapacity()
                                        + " | "
                                        + room.getStatus()
                        );
                    }

                    break;

                case 2:

                    sc.nextLine();

                    System.out.print("Nhap ten phong: ");
                    String roomName = sc.nextLine();

                    System.out.print("Nhap tang: ");
                    int floor = sc.nextInt();

                    System.out.print("Nhap suc chua: ");
                    int capacity = sc.nextInt();

                    Room newRoom = new NormalRoom(
                            IdGenerator.generateRoomId(),
                            roomName,
                            floor,
                            capacity,
                            "AVAILABLE"
                    );

                    rooms.add(newRoom);

                    System.out.println("Them phong thanh cong!");
                    break;

                case 3:

                    sc.nextLine();

                    System.out.print("Nhap ID phong: ");
                    String id = sc.nextLine();

                    boolean found = false;

                    for (Room room : rooms) {

                        if (room.getRoomId().equals(id)) {

                            System.out.println("Tim thay:");
                            System.out.println(
                                    room.getRoomName()
                                            + " | Tang "
                                            + room.getFloor()
                            );

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Khong tim thay phong!");
                    }

                    break;

                case 4:

                    System.out.print("Nhap so gio su dung: ");
                    int hours = sc.nextInt();

                    for (Room room : rooms) {

                        double fee =
                                room.getFeePolicy()
                                        .calculateFee(hours);

                        System.out.println(
                                room.getRoomName()
                                        + " -> "
                                        + fee
                                        + " VND"
                        );
                    }

                    break;

                case 0:

                    System.out.println("Cam on da su dung chuong trinh!");
                    break;

                default:

                    System.out.println("Lua chon khong hop le!");
            }

        } while (choice != 0);

        sc.close();
    }
}