import java.util.HashMap;

/**
 * Use Case 3: Centralized Room Inventory
 * @author Alwyn
 * @version 3.0
 */

class RoomInventory {

    private HashMap<String, Integer> inventory;

    // Constructor
    RoomInventory() {
        inventory = new HashMap<>();
    }

    // Add room type
    void addRoom(String type, int count) {
        inventory.put(type, count);
    }

    // Get availability
    int getAvailability(String type) {
        return inventory.getOrDefault(type, 0);
    }

    // Display all
    void displayInventory() {
        for (String type : inventory.keySet()) {
            System.out.println(type + " Available: " + inventory.get(type));
        }
    }
}

public class UseCase3InventorySetup {

    public static void main(String[] args) {

        RoomInventory inv = new RoomInventory();

        inv.addRoom("Single Room", 5);
        inv.addRoom("Double Room", 3);
        inv.addRoom("Suite Room", 2);

        System.out.println("Room Inventory:");
        inv.displayInventory();
    }
}