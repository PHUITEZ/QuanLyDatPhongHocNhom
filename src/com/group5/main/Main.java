package com.group5.main;

import model.*;
import utils.IdGenerator;

public class Main {

    public static void main(String[] args) {

        Room room1 =
                new NormalRoom(
                        IdGenerator.generateRoomId(),
                        "A101",
                        20);

        Room room2 =
                new ProjectorRoom(
                        IdGenerator.generateRoomId(),
                        "B202",
                        30,
                        2);

        Room room3 =
                new SeminarRoom(
                        IdGenerator.generateRoomId(),
                        "C303",
                        100,
                        true);

        room1.displayInfo();
        room2.displayInfo();
        room3.displayInfo();

        System.out.println(
                room2.calculateFee(3)
        );
    }
}