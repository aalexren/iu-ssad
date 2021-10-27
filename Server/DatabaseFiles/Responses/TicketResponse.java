package Server.DatabaseFiles.Responses;

import SupportFiles.Ticket;
import SupportFiles.TicketStatus;

public class TicketResponse extends DatabaseResponse {
    private Ticket ticket;
    private TicketStatus ticketStatus;

    public TicketResponse(DatabaseResponseStatus status, Ticket ticket, TicketStatus ticketStatus) {
        super(status);
        this.ticket = ticket;
        this.ticketStatus = ticketStatus;
    }

    public TicketResponse(DatabaseResponseStatus status, Ticket ticket) {
        super(status);
        this.ticket = ticket;
        this.ticketStatus = TicketStatus.UTILIZED;
    }

    public Ticket getTicket() {
        return this.ticket;
    }

    public TicketStatus getTicketStatus() {
        return this.ticketStatus;
    }
}