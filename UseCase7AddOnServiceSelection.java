import java.util.*;

/**
 * Use Case 7: Add-On Service Selection
 * @author Alwyn
 * @version 7.0
 */

// Service class
class Service {
    String name;
    int cost;

    Service(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
}

public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        // Map: Reservation ID -> List of Services
        HashMap<String, List<Service>> serviceMap = new HashMap<>();

        // Create services
        Service wifi = new Service("WiFi", 200);
        Service breakfast = new Service("Breakfast", 300);
        Service spa = new Service("Spa", 1000);

        // Add services to a reservation
        List<Service> servicesForR1 = new ArrayList<>();
        servicesForR1.add(wifi);
        servicesForR1.add(breakfast);

        serviceMap.put("R1", servicesForR1);

        // Display services and total cost
        System.out.println("Services for Reservation R1:");

        int total = 0;

        for (Service s : serviceMap.get("R1")) {
            System.out.println(s.name + " - Cost: " + s.cost);
            total += s.cost;
        }

        System.out.println("Total Add-On Cost: " + total);
    }
}