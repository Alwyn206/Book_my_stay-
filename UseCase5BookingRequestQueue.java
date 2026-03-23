import java.util.LinkedList;
import java.util.Queue;

/**
 * Use Case 5: Booking Request Queue (FIFO)
 * @author Alwyn
 * @version 5.0
 */

// Reservation class
class Reservation {
    String customerName;
    String roomType;

    Reservation(String customerName, String roomType) {
        this.customerName = customerName;
        this.roomType = roomType;
    }

    void display() {
        System.out.println(customerName + " requested " + roomType);
    }
}

public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        Queue<Reservation> bookingQueue = new LinkedList<>();

        // Adding requests (enqueue)
        bookingQueue.add(new Reservation("John", "Single Room"));
        bookingQueue.add(new Reservation("Alice", "Double Room"));
        bookingQueue.add(new Reservation("Bob", "Suite Room"));

        System.out.println("Booking Requests in Order:");

        // Display queue
        for (Reservation r : bookingQueue) {
            r.display();
        }
    }
}