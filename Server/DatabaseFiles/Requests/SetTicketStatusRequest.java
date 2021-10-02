package Server.DatabaseFiles.Requests;

import SupportFiles.Ticket;

public class SetTicketStatusRequest extends DataBaseRequest { 
    private Ticket ticket;

    public SetTicketStatusRequest(Ticket ticket){
        super("SetTicketStatus");
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return this.ticket;
    }
}