package Server.DatabaseModules;

import Server.DatabaseFiles.*;
import Server.DatabaseFiles.Responses.ResponseStatus;
import Server.DatabaseFiles.Responses.IResponse;
import Server.DatabaseFiles.Responses.TicketResponse;
import Server.DatabaseFiles.Responses.TicketStatusResponse;
import Server.DatabaseFiles.TableRequests.TicketTableRequest;
import SupportFiles.TicketStatus;
import Server.DatabaseFiles.Requests.GetTicketStatusRequest;
import Server.DatabaseFiles.Requests.IServerRequest;

public class TicketStatusCheckingModule implements IDatabaseModule {
	public IResponse execute(IServerRequest request) {
		Database db = Database.getInstance();
		GetTicketStatusRequest formalRequest = (GetTicketStatusRequest) request;
		if (formalRequest.getTicket() == null)
			return new TicketStatusResponse(ResponseStatus.FAILURE, null);

		TicketTableRequest readTicketRequest = new TicketTableRequest(formalRequest.getTicket().getTicketID());
		TicketResponse ticketResponse = (TicketResponse) db.read(readTicketRequest);
		if(ticketResponse.getStatus() == ResponseStatus.FAILURE){
			return new TicketStatusResponse(ResponseStatus.FAILURE, TicketStatus.UTILIZED);
		}
		return new TicketStatusResponse(ResponseStatus.SUCCESS, ticketResponse.getTicketStatus());
	}
}