package Middleware.RequestHandlers;

import Server.ServerManager;
import Server.DatabaseFiles.Requests.IServerRequest;
import Server.DatabaseFiles.Responses.IResponse;

public class FinalHandler implements IRequestHandler {
    private ServerManager serverManager;

    public FinalHandler(ServerManager serverManager) {
        this.serverManager = serverManager;
    }

    @Override
    public void setNextHandler(IRequestHandler handler) {
        return;
    }

    @Override
    public IResponse handleRequest(IServerRequest request) {
        return this.serverManager.execute(request);
    }

}