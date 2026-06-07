package model;

public class NormalRoom extends Room {

    public NormalRoom(String roomId, String roomName, int capacity) {
        super(roomId, roomName, capacity);
    }

    @Override
    public double calculateFee(int hours) {
        return 0;
    }

    @Override
    public void displayInfo() {

        System.out.println(
                "Normal Room | ID: "
                        + getRoomId
                        + " | Name: "
                        + getRoomName
                        + " | Capacity: "
                        + getCapacity
        );
    }
}