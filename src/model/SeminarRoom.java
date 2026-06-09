package model;

public class SeminarRoom extends Room {

    public SeminarRoom(String roomId, String roomName, int capacity) {

        super(roomId, roomName, capacity);
    }


    @Override
    public double calculateFee(int hours) {

        return hours * 50000;
    }

    @Override
    public void displayInfo() {

        System.out.println(
                "Seminar Room | ID: "
                        + getRoomID
                        + " | Name: "
                        + getRoomName
                        + " | Capacity: "
                        + getCapacity);
    }
}