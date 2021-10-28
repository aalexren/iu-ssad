package Server.DatabaseFiles.Responses;

import SupportFiles.TicketStatus;

public class TicketStatusResponse extends ServerResponse {
    private TicketStatus ticketStatus;

    public TicketStatusResponse(ResponseStatus status, TicketStatus ticketStatus) {
        super(status);
        this.ticketStatus = ticketStatus;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}