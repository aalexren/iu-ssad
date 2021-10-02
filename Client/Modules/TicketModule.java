package Client.Modules;

import SupportFiles.Ticket;
import Server.DatabaseFiles.Requests.BuyTicketRequest;
import Server.DatabaseFiles.Requests.DatabaseRequest;
import Server.DatabaseFiles.Responses.TicketResponse;
import SupportFiles.Location;
import SupportFiles.PaymentMethods;

public class TicketModule {
    private TransferModule transferModule;

    public TicketModule(TransferModule transferModule){
        this.transferModule = transferModule;
    }

    public Ticket sendBuyTicketRequest(PaymentMethods paymentMethod, Location from, Location to){
        DatabaseRequest buyTicketRequest = new BuyTicketRequest(paymentMethod, from, to, generateTrasnsactionID());
        TicketResponse ticketResponse = (TicketResponse) transferModule.sendRequest(buyTicketRequest);
        Ticket ticket = ticketResponse.getTicket();

        if (ticket == null){
            System.out.println("Payment error");
        }
        return ticketResponse.getTicket();
    }

    private long generateTrasnsactionID(){
        return System.currentTimeMillis();
    }
}