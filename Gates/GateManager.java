package Gates;

import Server.DatabaseFiles.IDatabase;
import Server.DatabaseFiles.Crypter.RequestCrypter;
import Server.DatabaseFiles.Crypter.ResponseCrypter;
import Server.DatabaseFiles.Requests.*;
import Server.DatabaseFiles.Responses.*;
import SupportFiles.Ticket;
import SupportFiles.TicketStatus;

interface IGateManager {
    public TicketStatus getTicketStatus(Ticket ticket);

    public void setTicketStatus(Ticket ticket, TicketStatus status);

    public IDatabaseResponse sendRequest(DatabaseRequest request);
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
    public IDatabaseResponse sendRequest(DatabaseRequest request) {
        RequestCrypter requestCrypter = new RequestCrypter(request);
        IDatabaseResponse databaseResponse = fireWall.execute(requestCrypter);

        return ((ResponseCrypter)databaseResponse).decrypt();
    }

    @Override
    public TicketStatus getTicketStatus(Ticket ticket) {
        DatabaseRequest request = new GetTicketStatusRequest(ticket);
        TicketStatusResponse response = (TicketStatusResponse)sendRequest(request);

        if (response.getStatus() == DatabaseResponseStatus.SUCCESS)
            return response.getTicketStatus();

        return TicketStatus.UTILIZED;
    }

    @Override
    public void setTicketStatus(Ticket ticket, TicketStatus status) {
        DatabaseRequest request = new SetTicketStatusRequest(ticket, status);
        sendRequest(request);
    }

}