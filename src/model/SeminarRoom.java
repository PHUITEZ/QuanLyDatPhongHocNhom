package model;

public class SeminarRoom extends Room {

    private boolean soundSystem;

    public SeminarRoom(String roomId, String roomName, int capacity, boolean soundSystem) {

        super(roomId, roomName, capacity);
        this.soundSystem = soundSystem;
    }

    public boolean isSoundSystem() {

        return soundSystem;
    }

    public void setSoundSystem(boolean soundSystem) {

        this.soundSystem = soundSystem;
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
                        + getCapacity
                        + " | Sound System: "
                        + soundSystem
        );
    }
}