package Client.Modules;

import SupportFiles.Ticket;

import java.util.UUID;

import Server.DatabaseFiles.Requests.BuyTicketRequest;
import Server.DatabaseFiles.Requests.ServerRequest;
import Server.DatabaseFiles.Responses.IResponse;
import Server.DatabaseFiles.Responses.ResponseStatus;
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
        ServerRequest buyTicketRequest = new BuyTicketRequest(paymentMethod, from, to, generateTrasnsactionID());
        IResponse response = transferModule.sendRequest(buyTicketRequest);

        if (response.getStatus() == ResponseStatus.FAILURE){
            // Error in middleware
            System.out.println("Middleware checks error");
            return null;
        }

        TicketResponse ticketResponse = (TicketResponse) response;
        Ticket ticket = ticketResponse.getTicket();

        if (ticket == null) {
            // Here we can handle payment errors
            System.out.println("Payment error");
            return null;
        }

        return ticketResponse.getTicket();
    }

    private Long generateTrasnsactionID() {
        return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }
}