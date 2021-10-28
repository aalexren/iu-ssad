package Server.ServerModules;

import Server.DatabaseFiles.Responses.IResponse;
import Server.DatabaseFiles.Requests.IServerRequest;

public interface IServerModule {
    public IResponse execute(IServerRequest request);
}
