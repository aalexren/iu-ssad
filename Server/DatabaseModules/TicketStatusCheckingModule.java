package Server.DatabaseModules;

import Server.DatabaseFiles.*;
import Server.DatabaseFiles.Requests.DatabaseRequest;
import Server.DatabaseFiles.Responses.IDatabaseResponse;
import Server.DatabaseFiles.Requests.GetTicketStatusRequest;
import Server.DatabaseFiles.Requests.SetTicketStatusRequest;
import SupportFiles.*;


public class TicketStatusCheckingModule implements IDatabaseModule {

	public IDatabaseResponse execute(DatabaseRequest request) {
		Database db = Database.getInstance();
        GetTicketStatusRequest formalRequest = (GetTicketStatusRequest) request;
		return db.getTicketStatus((formalRequest.getTicket().getTicketID()));
	}
}