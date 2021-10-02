package Server.DatabaseModules;

import Server.DatabaseFiles.*;
import Server.DatabaseFiles.Requests.DatabaseRequest;
import Server.DatabaseFiles.Responses.IDatabaseResponse;
import Server.DatabaseFiles.Requests.GetTicketStatusRequest;
import Server.DatabaseFiles.Requests.SetTicketStatusRequest;
import SupportFiles.*;


public class TicketStatusUpdationModule implements IDatabaseModule{
    
    public IDatabaseResponse execute(DatabaseRequest request) {
		Database db = Database.getInstance();
        SetTicketStatusRequest formalRequest = (SetTicketStatusRequest) request;
        Ticket ticket = formalRequest.getTicket();
        return db.setTicketStatus(ticket.getTicketID(), formalRequest.getTicketStatus());
	}
}