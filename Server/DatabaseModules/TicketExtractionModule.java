package Server.DatabaseModules;

import Server.DatabaseFiles.*;
import Server.DatabaseFiles.Requests.GetTicketRequest;
import Server.DatabaseFiles.Responses.IResponse;
import Server.DatabaseFiles.TableRequests.TicketTableRequest;
import Server.DatabaseFiles.Requests.IServerRequest;

public class TicketExtractionModule implements IDatabaseModule {
	public IResponse execute(IServerRequest request) {
		Database db = Database.getInstance();
		GetTicketRequest formalRequest = (GetTicketRequest)request;

        TicketTableRequest readTicketRequest = new TicketTableRequest(formalRequest.getTicket().getTicketID());
		return  db.read(readTicketRequest);
	}
}