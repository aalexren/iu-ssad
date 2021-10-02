package Server.DatabaseFiles;

import SupportFiles.*;

// Entity for Database

public class TicketData {
    public Location fromLocation;
    public Location toLocation;
    public long ID;
    public double price;
    public TicketStatus status;

    public TicketData(Location fromLocation, Location toLocation, long ID, double price, TicketStatus status) {
        this.fromLocation = fromLocation;
        this.toLocation   = toLocation;
        this.ID           = ID;
        this.price        = price;
        this.status       = status;
    }

    public TicketData(Ticket ticket) {
        this.fromLocation = ticket.getFromLocation();
        this.toLocation   = ticket.getToLocation();
        this.ID           = ticket.getTicketID();
        this.price        = ticket.getTicketPrice();
        this.status       = ticket.getTicketStatus();
    }
}