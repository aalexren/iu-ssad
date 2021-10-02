package Gates;

import Server.DatabaseFiles.Requests.*;
import Server.DatabaseFiles.Responses.*;
import SupportFiles.Ticket;
import SupportFiles.TicketStatus;

interface IGateManager {
    public boolean dataBaseRequest(Ticket ticket, String request);
    public TicketStatus getTicketStatus(Ticket ticket);
    public void setTicketStatus(Ticket ticket, TicketStatus status);
    public IDataBaseResponse sendRequest(DataBaseRequest request);
}

public class GateManager implements IGateManager {
    // private IDatabase database;

    public GateManager() {

    }

    @Override
    public IDataBaseResponse sendRequest(DataBaseRequest request) {

        return null;
    }

    @Override
    public TicketStatus getTicketStatus(Ticket ticket) {
        DataBaseRequest request = new GetTicketStatusRequest(ticket);
        TicketStatusResponse response = (TicketStatusResponse) sendRequest(request);
        if (response.getStatus() == DataBaseResponseStatus.SUCCESS){
            return response.getTicketStatus();
        }
        return TicketStatus.UTILIZED;
        // return response.status
    }
    
    @Override
    public void setTicketStatus(Ticket ticket, TicketStatus status) {
        DataBaseRequest request = new SetTicketStatusRequest(ticket);
        DataBaseResponse response = (DataBaseResponse) sendRequest(request);
        
    }

    @Override
    public boolean dataBaseRequest(Ticket ticket, String request) {
        // TODO Auto-generated method stub
        return false;
    }
}