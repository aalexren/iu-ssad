package Gates;

import SupportFiles.*;

import javax.xml.crypto.Data;

import Server.DatabaseFiles.*;
import Server.DatabaseFiles.Responses.DataBaseResponse;
import Server.DatabaseFiles.Responses.IDataBaseResponse;
import Server.DatabaseFiles.Responses.TicketStatusResponse;

interface IGateManager {
    public boolean dataBaseRequest(Ticket ticket, String request);
    public TicketStatus getTicketStatus(Ticket ticket);
    public void setTicketStatus(Ticket ticket, TicketStatus status);
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
        DataBaseRequest request = new GetTicketStatusRequest();
        TicketStatusResponse response = sendRequest(request);
        if (response.getStatus()){
            return response.getTicketStatus();
        }
        return TicketStatus.UTILIZED;
        // return response.status
    }
    
    @Override
    public void setTicketStatus(Ticket ticket, TicketStatus status) {
        DataBaseRequest request = new SetTicketStatusRequest();
        DataBaseResponse response = sendRequest(request);
        
    }
}