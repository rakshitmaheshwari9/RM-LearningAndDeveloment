import java.util.List;

public class DemoDriver {
    private CabBooking cabBooking = new CabBooking();

    public void run() {
        // Add users
        cabBooking.addUser("Alice", new Location(12.9716, 77.5946));  // Bangalore
        cabBooking.addUser("Bob", new Location(28.7041, 77.1025));  // Delhi

        // Add drivers
        cabBooking.addDriver("Charlie", "Sedan", new Location(12.9717, 77.5947));
        cabBooking.addDriver("David", "Sedan", new Location(12.9715, 77.5945));
        cabBooking.addDriver("Eve", "Hatchback", new Location(28.7042, 77.1024));

        // Find rides for Alice
        List<Ride> aliceRides = cabBooking.findRide("Alice", new Location(12.9716, 77.5946), new Location(12.9717, 77.5947));
        System.out.println("Available rides for Alice:");
        for (Ride ride : aliceRides) {
            System.out.println("Driver: " + ride.driver + ", Distance: " + ride.distance + " km, Fare: " + ride.fare);
        }

        // Choose a ride for Alice
        Ride chosenRide = cabBooking.chooseRide("Alice", "Charlie");
        System.out.println("Chosen ride for Alice: " + chosenRide.driver + ", Fare: " + chosenRide.fare);
    }

    public static class Ride {
        public Driver driver;
        public double distance;
        public double fare;

        public Ride(Driver driver, double distance, double fare) {
            this.driver = driver;
            this.distance = distance;
            this.fare = fare;
        }
    }
}
