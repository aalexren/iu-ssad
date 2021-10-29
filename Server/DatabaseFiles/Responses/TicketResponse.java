package Server.DatabaseFiles.Responses;

import SupportFiles.Ticket;
import SupportFiles.TicketStatus;

public class TicketResponse extends ServerResponse {
    private Ticket ticket;
    private TicketStatus ticketStatus;

    public TicketResponse(ResponseStatus status, Ticket ticket, TicketStatus ticketStatus) {
        super(status);
        this.ticket = ticket;
        this.ticketStatus = ticketStatus;
    }

    public TicketResponse(ResponseStatus status, Ticket ticket) {
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