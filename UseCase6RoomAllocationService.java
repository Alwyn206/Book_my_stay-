import java.util.*;

/**
 * Use Case 6: Room Allocation & Reservation Confirmation
 * @author Alwyn
 * @version 6.0
 */

// Reservation class
class Reservation {
    String customerName;
    String roomType;

    Reservation(String customerName, String roomType) {
        this.customerName = customerName;
        this.roomType = roomType;
    }
}

// Inventory class
class RoomInventory {
    HashMap<String, Integer> inventory = new HashMap<>();

    void addRoom(String type, int count) {
        inventory.put(type, count);
    }

    boolean isAvailable(String type) {
        return inventory.getOrDefault(type, 0) > 0;
    }

    void reduceRoom(String type) {
        inventory.put(type, inventory.get(type) - 1);
    }
}

// Booking service
class BookingService {

    Set<String> allocatedRooms = new HashSet<>();
    HashMap<String, Set<String>> roomMap = new HashMap<>();

    void processBooking(Queue<Reservation> queue, RoomInventory inv) {

        while (!queue.isEmpty()) {

            Reservation r = queue.poll();

            if (inv.isAvailable(r.roomType)) {

                // Generate unique room ID
                String roomId = r.roomType + "-" + (allocatedRooms.size() + 1);

                // Store in set
                allocatedRooms.add(roomId);

                // Map room type → room IDs
                roomMap.putIfAbsent(r.roomType, new HashSet<>());
                roomMap.get(r.roomType).add(roomId);

                // Update inventory
                inv.reduceRoom(r.roomType);

                System.out.println("Booking confirmed for " + r.customerName +
                        " | Room ID: " + roomId);
            } else {
                System.out.println("No rooms available for " + r.customerName);
            }
        }
    }
}

public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        // Inventory setup
        RoomInventory inv = new RoomInventory();
        inv.addRoom("Single Room", 1);
        inv.addRoom("Double Room", 1);

        // Queue (from UC5)
        Queue<Reservation> queue = new LinkedList<>();
        queue.add(new Reservation("John", "Single Room"));
        queue.add(new Reservation("Alice", "Single Room")); // will fail
        queue.add(new Reservation("Bob", "Double Room"));

        // Process bookings
        BookingService service = new BookingService();
        service.processBooking(queue, inv);
    }
}