/**
 * Use Case 2: Room Initialization using OOP
 * @author Alwyn
 * @version 2.0
 */

// Abstract class
abstract class Room {
    String type;
    int price;

    Room(String type, int price) {
        this.type = type;
        this.price = price;
    }

    abstract void display();
}

// Single Room
class SingleRoom extends Room {
    SingleRoom() {
        super("Single Room", 1000);
    }

    void display() {
        System.out.println(type + " - Price: " + price);
    }
}

// Double Room
class DoubleRoom extends Room {
    DoubleRoom() {
        super("Double Room", 2000);
    }

    void display() {
        System.out.println(type + " - Price: " + price);
    }
}

// Suite Room
class SuiteRoom extends Room {
    SuiteRoom() {
        super("Suite Room", 5000);
    }

    void display() {
        System.out.println(type + " - Price: " + price);
    }
}

// Main class
public class UseCase2RoomInitialization {
    public static void main(String[] args) {

        Room r1 = new SingleRoom();
        Room r2 = new DoubleRoom();
        Room r3 = new SuiteRoom();

        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        r1.display();
        System.out.println("Available: " + singleAvailable);

        r2.display();
        System.out.println("Available: " + doubleAvailable);

        r3.display();
        System.out.println("Available: " + suiteAvailable);
    }
}