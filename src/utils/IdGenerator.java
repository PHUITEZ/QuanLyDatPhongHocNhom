package utils;

public class IdGenerator {

    private static int counter = 1;

    public static String generateRoomId() {
        return "R" + counter++;
    }
}