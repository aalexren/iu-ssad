package Server.DatabaseFiles;

import Server.DatabaseFiles.Responses.*;
import Server.DatabaseFiles.Requests.IDatabaseRequest;
import SupportFiles.*;
import java.util.HashMap;

/*
* Singleton class
*/
public class Database implements IDatabase {
    private volatile static Database instance;

    private HashMap <Long, TicketData> ticketData   = new HashMap <Long, TicketData>() ;
    private HashMap <Long, Boolean> transactionData = new HashMap <Long, Boolean>() ;

    private Database() { } 

    public static Database getInstance() {
        if (instance == null) {
            synchronized (Database.class) {
                if (instance == null)
                    instance = new Database();
            }
        }
        return instance;
    }

	@Override
	public IDatabaseResponse execute(IDatabaseRequest request) {

		return null;
	}

    // MARK: - Ticket Methods

    public TicketStatusResponse setTicketStatus(long ID, TicketStatus status) {
        TicketData tempTicket = getTicket(ID);  
        tempTicket.status = status;
        ticketData.replace(Long.valueOf(ID), tempTicket);

        return new TicketStatusResponse(DatabaseResponseStatus.SUCCESS, status);
    } 

    public TicketStatusResponse getTicketStatusResponse(long ID) {
        TicketStatus ticketStatus = getTicket(ID).status;

        return new TicketStatusResponse(DatabaseResponseStatus.SUCCESS, ticketStatus);
    }

    public TicketStatus getTicketStatus(long ID) {
        return ticketData.get(Long.valueOf(ID)).status;
    }

	public void deleteTicket(long ID) {
        ticketData.remove(Long.valueOf(ID));
    }

    public TicketData getTicket(long ID) {
        if (ticketData.get(Long.valueOf(ID)) == null)
            return null;

        return ticketData.get(Long.valueOf(ID));
    }

    public void addTicket(long id, TicketData ticket) {
        ticketData.put(id, ticket);
    }

    // Transaction Methods

    public void setTransaction(long id, Boolean status) {
        if (transactionData.get(Long.valueOf(id)) == null) {
            transactionData.put(id, status);
        } else {
            transactionData.replace(Long.valueOf(id), status);
        }
    }

    public boolean getTransaction(long id) {
        return transactionData.get(Long.valueOf(id));
    }
}