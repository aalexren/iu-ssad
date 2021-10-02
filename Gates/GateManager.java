package Gates;

import Server.DatabaseFiles.IDatabase;
import Server.DatabaseFiles.Requests.*;
import Server.DatabaseFiles.Responses.*;
import SupportFiles.Ticket;
import SupportFiles.TicketStatus;

public class GateManager implements IGateManager {
    private IDatabase fireWall;

    public GateManager(IDatabase firewall) {
        this.fireWall = firewall;
    }

    @Override
    public IDatabaseResponse sendRequest(DatabaseRequest request) {
        return fireWall.execute(request);
    }

    @Override
    public TicketStatus getTicketStatus(Ticket ticket) {
        DatabaseRequest request = new GetTicketStatusRequest(ticket);
        TicketStatusResponse response = (TicketStatusResponse) sendRequest(request);
        if (response.getStatus() == DatabaseResponseStatus.SUCCESS){
            return response.getTicketStatus();
        }
        return TicketStatus.UTILIZED;
    }
    
    @Override
    public void setTicketStatus(Ticket ticket, TicketStatus status) {
        DatabaseRequest request = new SetTicketStatusRequest(ticket, status);
        DatabaseResponse response = (DatabaseResponse) sendRequest(request);
    }

    @Override
    public boolean DatabaseRequest(Ticket ticket, String request) {
        // TODO Auto-generated method stub
        return false;
    }
}