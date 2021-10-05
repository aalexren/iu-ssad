package Client.Modules;

import SupportFiles.Ticket;

import java.util.UUID;

import Server.DatabaseFiles.Requests.BuyTicketRequest;
import Server.DatabaseFiles.Requests.DatabaseRequest;
import Server.DatabaseFiles.Responses.TicketResponse;
import SupportFiles.Location;
import SupportFiles.PaymentMethods;

// Module for buying tickets
public class TicketModule {
    private TransferModule transferModule;

    public TicketModule(TransferModule transferModule) {
        this.transferModule = transferModule;
    }

    public Ticket sendBuyTicketRequest(PaymentMethods paymentMethod, Location from, Location to) {
        DatabaseRequest buyTicketRequest = new BuyTicketRequest(paymentMethod, from, to, generateTrasnsactionID());
        TicketResponse ticketResponse = (TicketResponse)transferModule.sendRequest(buyTicketRequest);
        Ticket ticket = ticketResponse.getTicket();

        if (ticket == null) {
            // Here we can handle payment errors
            System.out.println("Payment error");
        }

        return ticketResponse.getTicket();
    }

    private Long generateTrasnsactionID() {
        return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }
}