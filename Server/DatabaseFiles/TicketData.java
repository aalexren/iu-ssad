package Server.DatabaseFiles;

import SupportFiles.*;

/*
* Entity for Database
*/
public class TicketData {
    private Location fromLocation;
    private Location toLocation;
    private long ID;
    private double price;
    private TicketStatus status;

    public TicketData(Location fromLocation, Location toLocation, long ID, double price, TicketStatus status) {
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.ID = ID;
        this.price = price;
        this.status = status;
    }

    public TicketData(Ticket ticket) {
        this.fromLocation = ticket.getFromLocation();
        this.toLocation = ticket.getToLocation();
        this.ID = ticket.getTicketID();
        this.price = ticket.getTicketPrice();
        this.status = ticket.getTicketStatus();
    }

    public void setTicketStatus(TicketStatus status) {
        this.status = status;
    }

    public TicketStatus getTicketStatus() {
        return status;
    }

    public void setLocationTo(Location to) {
        this.toLocation = to;
    }

    public Location getLocationTo() {
        return toLocation;
    }

    public void setLocationFrom(Location from) {
        this.fromLocation = from;
    }

    public Location getLocationFrom() {
        return fromLocation;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public long getID() {
        return ID;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}