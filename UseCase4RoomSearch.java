import java.util.HashMap;

/**
 * Use Case 4: Room Search & Availability Check
 * @author Alwyn
 * @version 4.0
 */

class RoomInventory {

    private HashMap<String, Integer> inventory;

    RoomInventory() {
        inventory = new HashMap<>();
    }

    void addRoom(String type, int count) {
        inventory.put(type, count);
    }

    HashMap<String, Integer> getInventory() {
        return inventory;
    }
}

public class UseCase4RoomSearch {

    public static void main(String[] args) {

        RoomInventory inv = new RoomInventory();

        inv.addRoom("Single Room", 5);
        inv.addRoom("Double Room", 0);   // unavailable
        inv.addRoom("Suite Room", 2);

        System.out.println("Available Rooms:");

        // Search logic (read-only)
        for (String type : inv.getInventory().keySet()) {

            int available = inv.getInventory().get(type);

            if (available > 0) {
                System.out.println(type + " Available: " + available);
            }
        }
    }
}