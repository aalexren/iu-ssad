package Middleware;

import Middleware.RequestHandlers.*;
import Server.ServerManager;
import Server.DatabaseFiles.*;
import Server.DatabaseFiles.Requests.*;
import Server.DatabaseFiles.Responses.*;
import Server.DatabaseModules.*;
import Server.ServerModules.NotifierModule;

/*
* Firewall is used to control access to server manager
*/
public class Firewall implements IDatabase {
    private ServerManager serverManager;

    public Firewall() {
        this.serverManager = new ServerManager(new PaymentModule(), new TicketStatusCheckingModule(),
                new TicketStatusUpdatingModule(), new TicketExtractionModule(), new NotifierModule());
    }

    @Override
    public IResponse execute(IServerRequest request) {
        // Final Handler passes request to Server Manager
        FinalHandler finalHandler = new FinalHandler(serverManager);
        BaseRequestHandler.setFinalHandler(finalHandler);

        // Different validators form a chain
        BaseRequestHandler ddosHandler = new DDoSPreventer();
        BaseRequestHandler originHandler = new OriginValidator();
        BaseRequestHandler authHandler = new AuthenticationValidator();

        // Chain of Responsibility
        originHandler.setNextHandler(authHandler);
        ddosHandler.setNextHandler(originHandler);

        return ddosHandler.handleRequest(request);
    }

}