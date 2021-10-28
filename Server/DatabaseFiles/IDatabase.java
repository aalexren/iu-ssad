package Server.DatabaseFiles;

import Server.DatabaseFiles.Requests.IServerRequest;
import Server.DatabaseFiles.Responses.*;

public interface IDatabase {
    public IResponse execute(IServerRequest request);
}