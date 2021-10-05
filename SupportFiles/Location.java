package SupportFiles;

interface ILocation {
    String getLocation();

    void setLocation(String newLocation);
}

public class Location implements ILocation {
    protected String location;

    public Location(String location) {
        this.location = location;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public void setLocation(String newLocation) {
        location = newLocation;
    }
}