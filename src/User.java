public class User {
    public String name;
    public Location location;

    public User(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public String toString() {
        return name;
    }
}
