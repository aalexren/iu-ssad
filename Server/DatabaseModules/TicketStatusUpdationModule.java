package Server.DatabaseModules;

import Server.DatabaseFiles.*;
import Server.DatabaseFiles.Responses.IDatabaseResponse;
import Server.DatabaseFiles.Responses.TicketStatusResponse;
import Server.DatabaseFiles.Requests.IDatabaseRequest;
import Server.DatabaseFiles.Requests.SetTicketStatusRequest;
import SupportFiles.*;

public class TicketStatusUpdationModule implements IDatabaseModule {
    public IDatabaseResponse execute(IDatabaseRequest request) {
        Database db = Database.getInstance();
        SetTicketStatusRequest formalRequest = (SetTicketStatusRequest)request;
        Ticket ticket = formalRequest.getTicket();

        TicketData ticketData = new TicketData(ticket);
        ticketData.setTicketStatus(formalRequest.getTicketStatus());
        TicketTableRequest updateTicketRequest = new TicketTableRequest(formalRequest.getTicket().getTicketID(),ticketData);

        TicketStatusResponse response = (TicketStatusResponse) db.update(updateTicketRequest);
        return response;
    }
}