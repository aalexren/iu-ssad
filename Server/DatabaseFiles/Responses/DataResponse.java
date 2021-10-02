package Server.DatabaseFiles.Responses;

import SupportFiles.TicketStatus;

public class DataResponse extends DataBaseResponse implements IDataResponse {
    private TicketStatus ticketStatus;

    public DataResponse(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
