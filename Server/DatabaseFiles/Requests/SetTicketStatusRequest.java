package Server.DatabaseFiles.Requests;

import SupportFiles.Ticket;
import SupportFiles.TicketStatus;


public class SetTicketStatusRequest extends DatabaseRequest { 
    private Ticket ticket;
    private TicketStatus status;

    public SetTicketStatusRequest(Ticket ticket, TicketStatus status){
        super("SetTicketStatus");
        this.ticket = ticket;
        this.status = status;
    }

    public Ticket getTicket() {
        return this.ticket;
    }

    public TicketStatus getTicketStatus(){
        return this.status;
    }
}