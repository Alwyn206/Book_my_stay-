import java.util.*;

/**
 * Use Case 8: Booking History & Reporting
 * @author Alwyn
 * @version 8.0
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
        System.out.println(customerName + " booked " + roomType);
    }
}

public class UseCase8BookingHistoryReport {

    public static void main(String[] args) {

        // List to store booking history
        List<Reservation> history = new ArrayList<>();

        // Add confirmed bookings
        history.add(new Reservation("John", "Single Room"));
        history.add(new Reservation("Alice", "Double Room"));
        history.add(new Reservation("Bob", "Suite Room"));

        // Display history
        System.out.println("Booking History:");

        for (Reservation r : history) {
            r.display();
        }

        // Simple report (total bookings)
        System.out.println("Total Bookings: " + history.size());
    }
}