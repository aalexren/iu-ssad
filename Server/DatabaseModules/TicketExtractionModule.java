package Server.DatabaseModules;

import Server.DatabaseFiles.*;
import Server.DatabaseFiles.Requests.GetTicketRequest;
import Server.DatabaseFiles.Responses.DatabaseResponseStatus;
import Server.DatabaseFiles.Responses.IDatabaseResponse;
import Server.DatabaseFiles.Responses.TicketResponse;
import Server.DatabaseFiles.Requests.IDatabaseRequest;
import SupportFiles.*;


public class TicketExtractionModule implements IDatabaseModule {
	public IDatabaseResponse execute(IDatabaseRequest request) {
		Database db = Database.getInstance();
        GetTicketRequest formalRequest = (GetTicketRequest) request;
		TicketData ticketData = db.getTicket(formalRequest.getTicket().getTicketID());
		if (ticketData == null){
			return new TicketResponse(DatabaseResponseStatus.FAILURE, null);
		}

		Ticket ticket = new Ticket(ticketData.ID, ticketData.fromLocation, ticketData.toLocation,ticketData.price);
		return new TicketResponse(DatabaseResponseStatus.SUCCESS, ticket);
	}
}