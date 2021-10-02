package Client.Modules;

import SupportFiles.Ticket;
import Server.DatabaseFiles.IDatabase;
import Server.DatabaseFiles.Requests.BuyTicketRequest;
import Server.DatabaseFiles.Requests.DatabaseRequest;
import Server.DatabaseFiles.Responses.BuyTicketResponse;
import SupportFiles.Location;
import SupportFiles.PaymentMethods;

public class TicketModule {
    private IDatabase fireWall;

    public TicketModule(IDatabase firewall){
        this.fireWall = firewall;
    }

    public Ticket sendBuyTicketRequest(PaymentMethods paymentMethod, Location from, Location to){
        DatabaseRequest buyTicketRequest = new BuyTicketRequest(paymentMethod, from, to);
        BuyTicketResponse ticketResponse = (BuyTicketResponse) fireWall.execute(buyTicketRequest);
        Ticket ticket = ticketResponse.getTicket();

        if (ticket == null){
            System.out.println("Payment error");
        }
        return ticketResponse.getTicket();
    }
}