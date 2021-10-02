package Server.DatabaseFiles;

import Server.DatabaseFiles.Requests.DatabaseRequest;
import Server.DatabaseFiles.Responses.IDatabaseResponse;

public interface IDatabase {
    public IDatabaseResponse execute(DatabaseRequest request);
}