package SupportFiles;

interface ITicket {
    Location getFromLocation();

    Location getToLocation();

    long getTicketID();

    double getTicketPrice();
}

public class Ticket implements ITicket {
    private Location fromLocation;
    private Location toLocation;
    private long ID;
    private double price;
    private TicketStatus status;

    public Ticket(Long ticketID, Location fromLocation, Location toLocation, double price) {
        this.ID = ticketID;
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
    public long getTicketID() {
        return ID;
    }

    @Override
    public double getTicketPrice() {
        return price;
    }

    public TicketStatus getTicketStatus() {
        return this.status;
    }

    private void recalculatePrice() {
        // TODO somehow change the price
    }
}