package Server.DatabaseModules;

import Server.DatabaseFiles.*;
import Server.DatabaseFiles.Requests.GetTicketRequest;
import Server.DatabaseFiles.Responses.IDatabaseResponse;
import Server.DatabaseFiles.TableRequests.TicketTableRequest;
import Server.DatabaseFiles.Requests.IDatabaseRequest;

public class TicketExtractionModule implements IDatabaseModule {
	public IDatabaseResponse execute(IDatabaseRequest request) {
		Database db = Database.getInstance();
		GetTicketRequest formalRequest = (GetTicketRequest)request;

        TicketTableRequest readTicketRequest = new TicketTableRequest(formalRequest.getTicket().getTicketID());
		return  db.read(readTicketRequest);
	}
}