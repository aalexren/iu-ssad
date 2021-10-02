package Server.DatabaseModules;

import Server.DatabaseFiles.*;
import Server.DatabaseFiles.Responses.IDatabaseResponse;
import Server.DatabaseFiles.Requests.GetTicketStatusRequest;
import Server.DatabaseFiles.Requests.IDatabaseRequest;


public class TicketStatusCheckingModule implements IDatabaseModule {
	public IDatabaseResponse execute(IDatabaseRequest request) {
		Database db = Database.getInstance();
        GetTicketStatusRequest formalRequest = (GetTicketStatusRequest) request;
		return db.getTicketStatusResponse((formalRequest.getTicket().getTicketID()));
	}
}