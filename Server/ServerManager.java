package Server;

import Server.DatabaseFiles.*;
import Server.DatabaseFiles.Crypter.RequestCrypter;
import Server.DatabaseFiles.Crypter.ResponseCrypter;
import Server.DatabaseFiles.Responses.*;
import Server.DatabaseModules.*;
import Server.ServerModules.IServerModule;
import Server.DatabaseFiles.Requests.IServerRequest;

/*
* Manage requests to and responses from database
*/
public class ServerManager implements IDatabase {
    private IDatabaseModule paymentModule;
    private IDatabaseModule ticketStatusCheckingModule;
    private IDatabaseModule ticketStatusUpdationModule;
    private IDatabaseModule ticketExtractionModule;
    private IServerModule notificationModule;

    public ServerManager(IDatabaseModule paymentModule, IDatabaseModule ticketStatusCheckingModule,
            IDatabaseModule ticketStatusUpdationModule, IDatabaseModule ticketExtractionModule,
            IServerModule notificationModule) {
        this.paymentModule = paymentModule;
        this.ticketStatusCheckingModule = ticketStatusCheckingModule;
        this.ticketStatusUpdationModule = ticketStatusUpdationModule;
        this.ticketExtractionModule = ticketStatusUpdationModule;
        this.notificationModule = notificationModule;
    }

    public ServerManager() {
        paymentModule = new PaymentModule();
        ticketStatusCheckingModule = new TicketStatusCheckingModule();
        ticketStatusUpdationModule = new TicketStatusUpdationModule();
        ticketExtractionModule = new TicketExtractionModule();
    }

    @Override
    public IResponse execute(IServerRequest request) {
        IResponse response;
        request = ((RequestCrypter)request).decrypt();

        switch (request.getHeader()) {
        case "BuyTicket":
            // database.readModule.get("Ticket table", info);
            response = paymentModule.execute(request);
            break;
        case "GetTicketStatus":
            response = ticketStatusCheckingModule.execute(request);
            break;
        case "SetTicketStatus":
            response = ticketStatusUpdationModule.execute(request);
            break;
        case "GetTicket":
            response = ticketExtractionModule.execute(request);
            break;
        case "NotificationRequest":
            response = notificationModule.execute(request);
            break;
        default:
            System.out.println("Something went wrong in Server Manager");
            response = new ServerResponse(ResponseStatus.FAILURE);
        }

        return new ResponseCrypter(response);
    }
}
