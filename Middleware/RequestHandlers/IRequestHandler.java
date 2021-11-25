package Middleware.RequestHandlers;

import Server.DatabaseFiles.Requests.IServerRequest;
import Server.DatabaseFiles.Responses.IResponse;

public interface IRequestHandler {
    public void setNextHandler(IRequestHandler handler);
    public IResponse handleRequest(IServerRequest request);
}