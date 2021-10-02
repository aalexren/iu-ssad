package Server.DatabaseFiles;

import Server.DatabaseFiles.Requests.DataBaseRequest;
import Server.DatabaseFiles.Responses.IDataBaseResponse;

public interface IDatabase {
    public IDataBaseResponse execute(DataBaseRequest request);
}