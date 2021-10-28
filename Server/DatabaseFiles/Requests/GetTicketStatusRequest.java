package Server.DatabaseFiles.Requests;

import SupportFiles.Ticket;

public class GetTicketStatusRequest extends ServerRequest {

    private Ticket ticket;

    public GetTicketStatusRequest(Ticket ticket) {
        super("GetTicketStatus");
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return this.ticket;
    }
}
