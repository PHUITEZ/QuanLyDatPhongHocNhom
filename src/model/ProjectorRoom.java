package model;

public class ProjectorRoom extends Room {


    public ProjectorRoom(String roomId, String roomName, int capacity) {

        super(roomId, roomName, capacity);
    }

    @Override
    public double calculateFee(int hours) {

        return hours * 20000;
    }

    @Override
    public void displayInfo() {

        System.out.println(
                "Projector Room | ID: "
                        + getRoomID
                        + " | Name: "
                        + getRoomName
                        + " | Capacity: "
                        + getCapacity

        );
    }
}