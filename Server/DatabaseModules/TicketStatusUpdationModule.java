package Server.DatabaseModules;

import Server.DatabaseFiles.*;
import Server.DatabaseFiles.Responses.IResponse;
import Server.DatabaseFiles.Responses.TicketStatusResponse;
import Server.DatabaseFiles.TableRequests.TicketTableRequest;
import Server.DatabaseFiles.Requests.IServerRequest;
import Server.DatabaseFiles.Requests.SetTicketStatusRequest;
import SupportFiles.*;

public class TicketStatusUpdationModule implements IDatabaseModule {
    public IResponse execute(IServerRequest request) {
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