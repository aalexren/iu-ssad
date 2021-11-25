package Gates;

import Server.DatabaseFiles.IDatabase;
import Server.DatabaseFiles.Crypter.RequestCipher;
import Server.DatabaseFiles.Crypter.ResponseCipher;
import Server.DatabaseFiles.Requests.*;
import Server.DatabaseFiles.Responses.*;
import SupportFiles.Ticket;
import SupportFiles.TicketStatus;

interface IGateManager {
    public TicketStatus getTicketStatus(Ticket ticket);

    public void setTicketStatus(Ticket ticket, TicketStatus status);

    public IResponse sendRequest(ServerRequest request);
}

/*
 * Manage connection of IGate classes and database
 */
public class GateManager implements IGateManager {
    private IDatabase fireWall;

    public GateManager(IDatabase firewall) {
        this.fireWall = firewall;
    }

    @Override
    public IResponse sendRequest(ServerRequest request) {
        RequestCipher requestCipher = new RequestCipher(request);
        IResponse databaseResponse = fireWall.execute(requestCipher);

        return ((ResponseCipher) databaseResponse).decrypt();
    }

    @Override
    public TicketStatus getTicketStatus(Ticket ticket) {
        ServerRequest request = new GetTicketStatusRequest(ticket);
        TicketStatusResponse response = (TicketStatusResponse) sendRequest(request);

        if (response.getStatus() == ResponseStatus.SUCCESS)
            return response.getTicketStatus();

        return TicketStatus.UTILIZED;
    }

    @Override
    public void setTicketStatus(Ticket ticket, TicketStatus status) {
        ServerRequest request = new SetTicketStatusRequest(ticket, status);
        sendRequest(request);
    }

}