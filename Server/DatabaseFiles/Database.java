package Server.DatabaseFiles;

import Server.DatabaseFiles.Responses.*;
import Server.DatabaseFiles.TableRequests.*;
import Server.DatabaseFiles.Requests.IServerRequest;
import Server.DatabaseFiles.Tables.*;
import Server.DatabaseFiles.*;

/*
* Singleton class
*/
public class Database implements IDatabase {
    private volatile static Database instance;

    private DataTable ticketTable = new TicketTable();
    private DataTable transactionTable = new TransactionTable();

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
    public IResponse execute(IServerRequest request) {

        return null;
    }

    public ServerResponse create(TableRequest request) {
        switch (request.getTableType()) {
        case TicketTable:
            return ticketTable.create(request);
        case TransactionTable:
            return transactionTable.create(request);
        default:
            System.out.println("Something went wrong in Database");
            return new ServerResponse(ResponseStatus.FAILURE);
        }
    }

    public ServerResponse read(TableRequest request) {
        switch (request.getTableType()) {
        case TicketTable:
            return ticketTable.read(request);
        case TransactionTable:
            return transactionTable.read(request);
        default:
            System.out.println("Something went wrong in Database");
            return new ServerResponse(ResponseStatus.FAILURE);
        }
    }

    public ServerResponse update(TableRequest request) {
        switch (request.getTableType()) {
        case TicketTable:
            return ticketTable.update(request);
        case TransactionTable:
            return transactionTable.update(request);
        default:
            System.out.println("Something went wrong in Database");
            return new ServerResponse(ResponseStatus.FAILURE);
        }
    }

    public ServerResponse delete(TableRequest request) {
        switch (request.getTableType()) {
        case TicketTable:
            return ticketTable.delete(request);
        case TransactionTable:
            return transactionTable.delete(request);
        default:
            System.out.println("Something went wrong in Database");
            return new ServerResponse(ResponseStatus.FAILURE);
        }
    }

}