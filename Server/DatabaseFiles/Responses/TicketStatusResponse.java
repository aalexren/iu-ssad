package Server.DatabaseFiles.Responses;

import SupportFiles.TicketStatus;

public class TicketStatusResponse extends DataBaseResponse {
    private TicketStatus ticketStatus;

    public TicketStatusResponse(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
