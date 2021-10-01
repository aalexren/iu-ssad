package SupportFiles;

enum TicketStatus {
    BOUGHT, IN_PROCESS, UTILIZED
}

interface ITicket {
    Location getFromLocation();

    Location getToLocation();

    int getTicketID();

    double getTicketPrice();

    boolean setToLocation(Location newLocation);

    boolean setFromLocation(Location newLocation);
}

public class Ticket implements ITicket {
    private Location fromLocation;
    private Location toLocation;
    private int ID;
    private double price;
    private TicketStatus status;

    public Ticket(int ID, Location fromLocation, Location toLocation, double price) {
        this.ID = ID;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.price = price;
        this.status = TicketStatus.BOUGHT;
    }

    @Override
    public Location getFromLocation() {
        return fromLocation;
    }

    @Override
    public Location getToLocation() {
        return toLocation;
    }

    @Override
    public boolean setToLocation(Location newLocation) {
        if (this.status == TicketStatus.UTILIZED)
            return false;

        recalculatePrice();
        toLocation = newLocation;
        return true;
    }

    @Override
    public boolean setFromLocation(Location newLocation) {
        if (this.status == TicketStatus.BOUGHT)
            return false;

        recalculatePrice();
        fromLocation = newLocation;
        return true;
    }

    @Override
    public int getTicketID() {
        return ID;
    }

    @Override
    public double getTicketPrice() {
        return price;
    }

    private void recalculatePrice() {
        // Somehow change the price
    }
}