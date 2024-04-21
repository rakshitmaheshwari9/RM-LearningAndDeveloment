import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CabBooking {
    private List<User> users = new ArrayList<>();
    private List<Driver> drivers = new ArrayList<>();
    private List<DemoDriver.Ride> rides = new ArrayList<>();

    public void addUser(String name, Location location) {
        User user = new User(name, location);
        users.add(user);
    }

    public void addDriver(String name, String vehicleDetails, Location currentLocation) {
        Driver driver = new Driver(name, vehicleDetails, currentLocation);
        drivers.add(driver);
    }

    public List<DemoDriver.Ride> findRide(String username, Location source, Location destination) {
        User user = getUser(username);
        if (user != null) {
            List<DemoDriver.Ride> rides = new ArrayList<>();
            for (Driver driver : drivers) {
                if (driver.vehicleDetails.equals(driver.vehicleDetails)) {
                    double distance = driver.distanceFrom(source);
                    DemoDriver.Ride ride = new DemoDriver.Ride(driver, distance, distance * 10);  // Fare calculation: 10 Rs per km
                    rides.add(ride);
                }
            }
            Collections.sort(rides, new Comparator<DemoDriver.Ride>() {
                public int compare(DemoDriver.Ride ride1, DemoDriver.Ride ride2) {
                    return Double.compare(ride1.distance, ride2.distance);
                }
            });
            return rides;
        } else {
            return null;
        }
    }


    private User getUser(String username) {
        for (User user : users) {
            if (user.name.equals(username)) {
                return user;
            }
        }
        return null;
    }

    public DemoDriver.Ride chooseRide(String username, String driverName) {
        User user = getUser(username);
        if (user != null) {
            DemoDriver.Ride ride = getRide(driverName);
            if (ride != null) {
                rides.remove(ride);
                return ride;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    private DemoDriver.Ride getRide(String driverName) {
        for (DemoDriver.Ride ride : rides) {
            if (ride.driver.name.equals(driverName)) {
                return ride;
            }
        }
        return null;
    }

}
