package Gates;

import SupportFiles.Ticket; 
import SupportFiles.TicketStatus;

interface IGateManager {
    public boolean dataBaseRequest(Ticket ticket, String request);
    public TicketStatus getTicketStatus(Ticket ticket);
    public void setTicketStatus(Ticket ticket, TicketStatus status);
}

interface IDataBaseResponse {
    public IDataBaseResponse getResponse();
}

class DataBaseResponseOne implements IDataBaseResponse {
    IDataBaseResponse response;

    public IDataBaseResponse getResponse() {
        this.response = //
    }
}

class DataBaseResponseTwo implements IDataBaseResponse {
    IDataBaseResponse response;

    public IDataBaseResponse getResponse() {
        this.response = //
    }
}

public class GateManager implements IGateManager {
    // private IDatabase database;

    public GateManager() {

    }

    @Override
    public IDataBaseResponse sendRequest(DataBaseRequest request) {

        return false;
    }

    @Override
    public TicketStatus getTicketStatus(Ticket ticket) {
        DataBaseRequest request = new GetTicketStatusRequest();
        IDataBaseResponse response = sendRequest(request);
        if (response.getStatus()){
            return response.ticketStatus;
        }
        return TicketStatus.UTILIZED;
        // return response.status
    }
    
    @Override
    public void setTicketStatus(Ticket ticket, TicketStatus status) {
        DataBaseRequest request = new SetTicketStatusRequest();
        if (response.getStatus()){

        }
    }

}