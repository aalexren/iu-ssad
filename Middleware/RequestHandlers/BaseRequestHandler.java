package Middleware.RequestHandlers;

import Server.DatabaseFiles.Requests.IServerRequest;
import Server.DatabaseFiles.Responses.IResponse;

public class BaseRequestHandler implements IRequestHandler {
    private IRequestHandler nextHandler;
    private static FinalHandler finalHandler;

    public BaseRequestHandler() {
        // nextHandler is set to finalHandler by default
        this.nextHandler = finalHandler;
    }

    public static void setFinalHandler(FinalHandler handler) {
        finalHandler = handler;
    }

    public void setNextHandler(IRequestHandler handler) {
        this.nextHandler = handler;
    }

    public IResponse handleRequest(IServerRequest request) {
        return this.nextHandler.handleRequest(request);
    }
}