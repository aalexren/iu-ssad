package Server;

import Server.DatabaseFiles.*;
import Server.DatabaseFiles.Crypter.RequestCrypter;
import Server.DatabaseFiles.Crypter.ResponseCrypter;
import Server.DatabaseFiles.Responses.*;
import Server.DatabaseModules.*;
import Server.DatabaseFiles.Requests.IDatabaseRequest;

/* 
* Manage requests to and responses from database
*/
public class ServerManager implements IDatabase {
    private IDatabaseModule paymentModule;
    private IDatabaseModule ticketStatusCheckingModule;
    private IDatabaseModule ticketStatusUpdationModule;
    private IDatabaseModule ticketExtractionModule;

    public ServerManager(IDatabaseModule paymentModule, IDatabaseModule ticketStatusCheckingModule,
            IDatabaseModule ticketStatusUpdationModule, IDatabaseModule ticketExtractionModule) {
        this.paymentModule = paymentModule;
        this.ticketStatusCheckingModule = ticketStatusCheckingModule;
        this.ticketStatusUpdationModule = ticketStatusUpdationModule;
        this.ticketExtractionModule = ticketStatusUpdationModule;
    }

    public ServerManager() {
        paymentModule = new PaymentModule();
        ticketStatusCheckingModule = new TicketStatusCheckingModule();
        ticketStatusUpdationModule = new TicketStatusUpdationModule();
        ticketExtractionModule = new TicketExtractionModule();
    }

    @Override
    public IDatabaseResponse execute(IDatabaseRequest request) {
        IDatabaseResponse databaseResponse;
        request = ((RequestCrypter)request).decrypt();

        switch (request.getHeader()) {
        case "BuyTicket":
            databaseResponse = paymentModule.execute(request);
            break;
        case "GetTicketStatus":
            databaseResponse = ticketStatusCheckingModule.execute(request);
            break;
        case "SetTicketStatus":
            databaseResponse = ticketStatusUpdationModule.execute(request);
            break;
        case "GetTicket":
            databaseResponse = ticketExtractionModule.execute(request);
            break;
        default:
            System.out.println("Something went wrong in Server Manager");
            databaseResponse = new DatabaseResponse(DatabaseResponseStatus.FAILURE);
        }

        return new ResponseCrypter(databaseResponse);
    }
}
