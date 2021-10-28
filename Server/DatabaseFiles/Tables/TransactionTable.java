package Server.DatabaseFiles.Tables;

import java.util.HashMap;

import Server.DatabaseFiles.Responses.DatabaseResponse;
import Server.DatabaseFiles.TableRequests.TableRequest;
import Server.DatabaseFiles.TableRequests.TransactionTableRequest;

public class TransactionTable implements DataTable{
    private HashMap<Long, Boolean> data;

    public TransactionTable() {
        data = new HashMap<>();
    }

    public DatabaseResponse read(TableRequest request) {
        TransactionTableRequest _request = (TransactionTableRequest)request;
        data.get(_request.getKey());
        return null;
    }

    public DatabaseResponse update(TableRequest request) {
        TransactionTableRequest _request = (TransactionTableRequest)request;
        data.replace(_request.getKey(), _request.getValue());
        return null;
    }

    public DatabaseResponse create(TableRequest request) {
        TransactionTableRequest _request = (TransactionTableRequest)request;
        data.put(_request.getKey(), _request.getValue());
        return null;
    }

    public DatabaseResponse delete(TableRequest request) {
        TransactionTableRequest _request = (TransactionTableRequest)request;
        data.remove(_request.getKey());
        return null;
    }
}
	