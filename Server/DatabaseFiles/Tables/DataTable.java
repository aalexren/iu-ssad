package Server.DatabaseFiles.Tables;

import Server.DatabaseFiles.Responses.*;
import Server.DatabaseFiles.TableRequests.TableRequest;

public interface DataTable {

    public ServerResponse read(TableRequest request);

    public ServerResponse update(TableRequest request);

    public ServerResponse create(TableRequest request);

    public ServerResponse delete(TableRequest request);
}