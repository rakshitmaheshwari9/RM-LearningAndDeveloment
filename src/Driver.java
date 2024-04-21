public class Driver {
    public String name;
    public String vehicleDetails;
    public Location currentLocation;

    public Driver(String name, String vehicleDetails, Location currentLocation) {
        this.name = name;
        this.vehicleDetails = vehicleDetails;
        this.currentLocation = currentLocation;
    }

    public String toString() {
        return name;
    }

    public double distanceFrom(Location location) {
        double lat1 = Math.toRadians(currentLocation.latitude);
        double lon1 = Math.toRadians(currentLocation.longitude);
        double lat2 = Math.toRadians(location.latitude);
        double lon2 = Math.toRadians(location.longitude);
        double R = 6371;  // Radius of the earth in km
        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) + Math.cos(lat1) * Math.cos(lat2) * Math.sin(dLon/2) * Math.sin(dLon/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double d = R * c;  // Distance in km
        return d;
    }
}
