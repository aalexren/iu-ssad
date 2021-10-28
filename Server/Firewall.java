package Server;

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

    // Firewall should ckeck if it can connect server with client
    private boolean checkConnection() {
        // Some check stuf
        return true;
    }

    public Firewall() {
        this.serverManager = new ServerManager(new PaymentModule(), new TicketStatusCheckingModule(),
                new TicketStatusUpdationModule(), new TicketExtractionModule(), new NotifierModule());
    }

    @Override
    public IResponse execute(IServerRequest request) {
        if (checkConnection()) {
            return serverManager.execute(request);
        }
        return new ServerResponse(ResponseStatus.FAILURE);
    }

}