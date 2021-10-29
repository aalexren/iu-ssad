package Server.DatabaseFiles.Tables;

import Server.DatabaseFiles.Responses.ServerResponse;
import Server.DatabaseFiles.TableRequests.TableRequest;
import Server.DatabaseFiles.TableRequests.TransactionTableRequest;

/*
 * Table for saving Transaction information
 */
public class TransactionTable implements DataTable {
    private Table<Long, Boolean> table;

    public TransactionTable() {
        table = new Table<>();
    }

    public ServerResponse read(TableRequest request) {
        TransactionTableRequest _request = (TransactionTableRequest) request;
        table.read(_request.getKey());
        return null;
    }

    public ServerResponse update(TableRequest request) {
        TransactionTableRequest _request = (TransactionTableRequest) request;
        table.update(_request.getKey(), _request.getValue());
        return null;
    }

    public ServerResponse create(TableRequest request) {
        TransactionTableRequest _request = (TransactionTableRequest) request;
        table.create(_request.getKey(), _request.getValue());
        return null;
    }

    public ServerResponse delete(TableRequest request) {
        TransactionTableRequest _request = (TransactionTableRequest) request;
        table.delete(_request.getKey());
        return null;
    }
}
