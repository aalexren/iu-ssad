 package Server.DatabaseFiles.Tables;

import java.util.HashMap;

import Server.DatabaseFiles.TicketData;
import Server.DatabaseFiles.Responses.DatabaseResponse;
import Server.DatabaseFiles.Responses.DatabaseResponseStatus;
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

    public DatabaseResponse read(TableRequest request) {
        TicketTableRequest _request = (TicketTableRequest)request;
        TicketData ticketData = data.get(_request.getKey());
        if (ticketData == null) {
            return new TicketResponse(DatabaseResponseStatus.FAILURE, null);
        }
		Ticket ticket = new Ticket(ticketData.getID(), ticketData.getLocationFrom(), ticketData.getLocationTo(), ticketData.getPrice());
        return new TicketResponse(DatabaseResponseStatus.SUCCESS, ticket, ticketData.getTicketStatus());
    }

    public DatabaseResponse update(TableRequest request) {
        TicketTableRequest _request = (TicketTableRequest)request;
        if (data.replace(_request.getKey(), _request.getValue()) == null)
            return new TicketStatusResponse(DatabaseResponseStatus.FAILURE, TicketStatus.UTILIZED);
        return new TicketStatusResponse(DatabaseResponseStatus.SUCCESS,  _request.getValue().getTicketStatus());
    }

    public DatabaseResponse create(TableRequest request) {
        TicketTableRequest _request = (TicketTableRequest)request;
        data.put(_request.getKey(), _request.getValue());
        return null;
    }

    public DatabaseResponse delete(TableRequest request) {
        TicketTableRequest _request = (TicketTableRequest)request;
        data.remove(_request.getKey());
        return null;
    }
}