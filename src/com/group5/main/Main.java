package com.group5.main;

import model.*;
import utils.IdGenerator;

public class Main {

    public static void main(String[] args) {

        Room room1 = new NormalRoom(
                IdGenerator.generateRoomId(),
                "A6:401-402",
                1,
                20,
                "AVAILABLE"
        );

        Room room2 = new ProjectorRoom(
                IdGenerator.generateRoomId(),
                "A2:201-202",
                2,
                30,
                "AVAILABLE"
        );

        Room room3 = new SeminarRoom(
                IdGenerator.generateRoomId(),
                "A4:405-406",
                3,
                100,
                "AVAILABLE"
        );

        System.out.println(room1.getRoomName());
        System.out.println(room2.getRoomName());
        System.out.println(room3.getRoomName());

        System.out.println(
                room2.getFeePolicy().calculateFee(2)
        );

        System.out.println(
                room3.getFeePolicy().calculateFee(2)
        );
    }
}