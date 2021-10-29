 package Server.DatabaseFiles.Tables;

import Server.DatabaseFiles.TicketData;
import Server.DatabaseFiles.Responses.ServerResponse;
import Server.DatabaseFiles.Responses.ResponseStatus;
import SupportFiles.Ticket;
import SupportFiles.TicketStatus;
import Server.DatabaseFiles.Responses.TicketResponse;
import Server.DatabaseFiles.Responses.TicketStatusResponse;
import Server.DatabaseFiles.TableRequests.TableRequest;
import Server.DatabaseFiles.TableRequests.TicketTableRequest;

/*
 * Table for saving Ticket information
 */
public class TicketTable implements DataTable {
    private Table<Long, TicketData> table;

    public TicketTable() {
        table = new Table<>();
    }

    public ServerResponse read(TableRequest request) {
        TicketTableRequest _request = (TicketTableRequest)request;
        TicketData ticketData = table.read(_request.getKey());
        if (ticketData == null) {
            return new TicketResponse(ResponseStatus.FAILURE, null);
        }
		Ticket ticket = new Ticket(ticketData.getID(), ticketData.getLocationFrom(), ticketData.getLocationTo(), ticketData.getPrice());
        return new TicketResponse(ResponseStatus.SUCCESS, ticket, ticketData.getTicketStatus());
    }

    public ServerResponse update(TableRequest request) {
        TicketTableRequest _request = (TicketTableRequest)request;
        if (table.update(_request.getKey(), _request.getValue()) == null)
            return new TicketStatusResponse(ResponseStatus.FAILURE, TicketStatus.UTILIZED);
        return new TicketStatusResponse(ResponseStatus.SUCCESS,  _request.getValue().getTicketStatus());
    }

    public ServerResponse create(TableRequest request) {
        TicketTableRequest _request = (TicketTableRequest)request;
        table.create(_request.getKey(), _request.getValue());
        return null;
    }

    public ServerResponse delete(TableRequest request) {
        TicketTableRequest _request = (TicketTableRequest)request;
        table.delete(_request.getKey());
        return null;
    }
}