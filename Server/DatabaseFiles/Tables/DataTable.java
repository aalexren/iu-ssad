package Server.DatabaseFiles.Tables;

import Server.DatabaseFiles.Responses.*;
import Server.DatabaseFiles.TableRequests.TableRequest;

public interface DataTable {

    public DatabaseResponse read(TableRequest request);

    public DatabaseResponse update(TableRequest request);

    public DatabaseResponse create(TableRequest request);

    public DatabaseResponse delete(TableRequest request);
}