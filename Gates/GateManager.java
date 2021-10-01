package Gates;

import SupportFiles.Ticket; 
import SupportFiles.TicketStatus;

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
    public boolean dataBaseRequest(Ticket ticket, String request) {

        return false;
    }

    @Override
    public TicketStatus getTicketStatus(Ticket ticket) {
        
        return null;
    }
    
    @Override
    public void setTicketStatus(Ticket ticket, TicketStatus status) {
    
    }

}