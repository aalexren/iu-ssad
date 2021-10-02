package Server.DatabaseFiles;

import Server.DatabaseFiles.Requests.IDatabaseRequest;
import Server.DatabaseFiles.Responses.IDatabaseResponse;

public interface IDatabase {
    public IDatabaseResponse execute(IDatabaseRequest request);
}