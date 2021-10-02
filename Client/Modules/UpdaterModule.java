package Client.Modules;

import Server.DatabaseFiles.Requests.DatabaseRequest;
import Server.DatabaseFiles.Requests.GetTicketRequest;
import SupportFiles.Ticket;
import Server.DatabaseFiles.Responses.TicketResponse;

public class UpdaterModule {
    private TransferModule transferModule;

    public UpdaterModule(TransferModule transferModule){
        this.transferModule = transferModule;
    }

    // public TicketStatus getTicketStatus(Ticket ticket) {
    //     DatabaseRequest request = new GetTicketStatusRequest(ticket);
    //     TicketStatusResponse response = (TicketStatusResponse) transferModule.sendRequest(request);
    //     return response.getTicketStatus();
    // }

    public Ticket getTicket(Ticket ticket) {
        DatabaseRequest request = new GetTicketRequest(ticket);
        TicketResponse response = (TicketResponse) transferModule.sendRequest(request);
        return response.getTicket();
    }
}
