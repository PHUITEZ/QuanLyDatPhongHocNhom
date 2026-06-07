package model;

public class ProjectorRoom extends Room {

    private int projectorCount;

    public ProjectorRoom(String roomId, String roomName, int capacity, int projectorCount) {

        super(roomId, roomName, capacity);
        this.projectorCount = projectorCount;
    }

    public int getProjectorCount() {
        return projectorCount;
    }

    public void setProjectorCount(int projectorCount) {
        this.projectorCount = projectorCount;
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
                        + " | Projectors: "
                        + projectorCount
        );
    }
}