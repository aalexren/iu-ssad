 package Server.DatabaseFiles.Tables;

import java.util.HashMap;

import Server.DatabaseFiles.TicketData;
import Server.DatabaseFiles.Responses.ServerResponse;
import Server.DatabaseFiles.Responses.ResponseStatus;
import SupportFiles.Ticket;
import SupportFiles.TicketStatus;
import Server.DatabaseFiles.Responses.TicketResponse;
import Server.DatabaseFiles.Responses.TicketStatusResponse;
import Server.DatabaseFiles.TableRequests.TableRequest;
import Server.DatabaseFiles.TableRequests.TicketTableRequest;

public class TicketTable implements DataTable {
    private HashMap<Long, TicketData> data;

    public TicketTable() {
        data = new HashMap<>();
    }

    public ServerResponse read(TableRequest request) {
        TicketTableRequest _request = (TicketTableRequest)request;
        TicketData ticketData = data.get(_request.getKey());
        if (ticketData == null) {
            return new TicketResponse(ResponseStatus.FAILURE, null);
        }
		Ticket ticket = new Ticket(ticketData.getID(), ticketData.getLocationFrom(), ticketData.getLocationTo(), ticketData.getPrice());
        return new TicketResponse(ResponseStatus.SUCCESS, ticket, ticketData.getTicketStatus());
    }

    public ServerResponse update(TableRequest request) {
        TicketTableRequest _request = (TicketTableRequest)request;
        if (data.replace(_request.getKey(), _request.getValue()) == null)
            return new TicketStatusResponse(ResponseStatus.FAILURE, TicketStatus.UTILIZED);
        return new TicketStatusResponse(ResponseStatus.SUCCESS,  _request.getValue().getTicketStatus());
    }

    public ServerResponse create(TableRequest request) {
        TicketTableRequest _request = (TicketTableRequest)request;
        data.put(_request.getKey(), _request.getValue());
        return null;
    }

    public ServerResponse delete(TableRequest request) {
        TicketTableRequest _request = (TicketTableRequest)request;
        data.remove(_request.getKey());
        return null;
    }
}