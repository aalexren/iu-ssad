package Client.Modules;

import Server.DatabaseFiles.Requests.ServerRequest;
import Server.DatabaseFiles.Requests.GetTicketRequest;
import SupportFiles.Ticket;
import Server.DatabaseFiles.Responses.IResponse;
import Server.DatabaseFiles.Responses.ResponseStatus;
import Server.DatabaseFiles.Responses.TicketResponse;

/*
 * Module to update information of ticket from database
 */
public class UpdaterModule {
    private TransferModule transferModule;

    public UpdaterModule(TransferModule transferModule) {
        this.transferModule = transferModule;
    }

    public Ticket getTicket(Ticket ticket) {
        ServerRequest request = new GetTicketRequest(ticket);
        IResponse response = transferModule.sendRequest(request);
        if (response.getStatus() == ResponseStatus.FAILURE){
             // Error in middleware
             System.out.println("Middleware checks error");
             return null;
        }
        TicketResponse ticketResponse = (TicketResponse) response;
        return ticketResponse.getTicket();
    }
}
