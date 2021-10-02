package Gates;

import SupportFiles.*;
import Server.DatabaseFiles.Requests.*;
import Server.DatabaseFiles.Responses.*;

public interface IGateManager {
    public boolean dataBaseRequest(Ticket ticket, String request);
    public TicketStatus getTicketStatus(Ticket ticket);
    public void setTicketStatus(Ticket ticket, TicketStatus status);
    public IDataBaseResponse sendRequest(DataBaseRequest request);
}