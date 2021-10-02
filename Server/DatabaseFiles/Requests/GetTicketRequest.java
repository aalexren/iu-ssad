package Server.DatabaseFiles.Requests;

import SupportFiles.Ticket;

public class GetTicketRequest extends DatabaseRequest {

    private Ticket ticket;

    public GetTicketRequest(Ticket ticket) {
        super("GetTicket");
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return this.ticket;
    }
}
