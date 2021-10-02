package Server.DatabaseFiles.Responses;

import SupportFiles.Ticket;

public class BuyTicketResponse extends DatabaseResponse {
    private Ticket ticket;

    public BuyTicketResponse(DatabaseResponseStatus status, Ticket ticket) {
		  super(status);
		  this.ticket = ticket;
    }   

    public Ticket getTicket() {
        return this.ticket;
    }
}