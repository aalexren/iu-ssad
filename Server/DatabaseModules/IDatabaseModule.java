package Server.DatabaseModules;

import Server.DatabaseFiles.Responses.IResponse;
import Server.DatabaseFiles.Requests.IServerRequest;

public interface IDatabaseModule {
    public IResponse execute(IServerRequest request);
}
