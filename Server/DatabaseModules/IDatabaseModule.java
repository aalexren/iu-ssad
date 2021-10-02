package Server.DatabaseModules;

import Server.DatabaseFiles.Responses.IDatabaseResponse;
import Server.DatabaseFiles.Requests.IDatabaseRequest;

public interface IDatabaseModule {
    public IDatabaseResponse execute(IDatabaseRequest request);
}
