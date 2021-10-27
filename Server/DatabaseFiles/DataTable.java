package Server.DatabaseFiles;

import Server.DatabaseFiles.Responses.*;

public interface DataTable {

    public DatabaseResponse read(TableRequest request);

    public DatabaseResponse update(TableRequest request);

    public DatabaseResponse create(TableRequest request);

    public DatabaseResponse delete(TableRequest request);
}