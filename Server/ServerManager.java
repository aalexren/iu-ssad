package Server;

import Server.DatabaseFiles.*;
import Server.DatabaseFiles.Requests.DatabaseRequest;
import Server.DatabaseFiles.Responses.*;
import Server.DatabaseModules.*;

public class ServerManager implements IDatabase {
    private Database Database;

    private IDatabaseModule paymentModule;
    private IDatabaseModule ticketStatusCheckingModule;
    private IDatabaseModule ticketStatusUpdationModule;

    public ServerManager(IDatabaseModule paymentModule, IDatabaseModule ticketStatusCheckingModule, IDatabaseModule ticketStatusUpdationModule) {
        // this.Database = Database.getInstance();
        this.paymentModule = paymentModule;
        this.ticketStatusCheckingModule = ticketStatusCheckingModule;
        this.ticketStatusUpdationModule = ticketStatusUpdationModule;
    }

    public ServerManager(){
        paymentModule = new PaymentModule();
        ticketStatusCheckingModule = new TicketStatusCheckingModule();
        ticketStatusUpdationModule = new TicketStatusUpdationModule();
    }

    @Override
    public IDatabaseResponse execute(DatabaseRequest request) {
        switch (request.getHeader()) {
            case "BuyTicket":
                return paymentModule.execute(request);
            case "GetTicketStatus":
                return ticketStatusCheckingModule.execute(request);
            case "SetTicketStatus":
                return ticketStatusUpdationModule.execute(request);
            default:
                System.out.println("Something went wrong in Server Manager");
        }

        return new DatabaseResponse(DatabaseResponseStatus.FAILURE);
    }
}
