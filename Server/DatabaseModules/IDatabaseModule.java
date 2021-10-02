package Server.DatabaseModules;

import Server.DatabaseFiles.Requests.DatabaseRequest;
import Server.DatabaseFiles.Responses.IDatabaseResponse;

public interface IDatabaseModule {
    public IDatabaseResponse execute(DatabaseRequest request);
}
