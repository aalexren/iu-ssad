package Server.DatabaseFiles.Responses;

import SupportFiles.Ticket;

public class TicketResponse extends DatabaseResponse {
    private Ticket ticket;

    public TicketResponse(DatabaseResponseStatus status, Ticket ticket) {
        super(status);
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return this.ticket;
    }
}