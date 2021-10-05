package Server.DatabaseModules;

import java.util.UUID;

import Server.DatabaseFiles.*;
import Server.DatabaseFiles.Requests.BuyTicketRequest;
import Server.DatabaseFiles.Responses.TicketResponse;
import Server.DatabaseFiles.Responses.DatabaseResponseStatus;
import Server.DatabaseFiles.Responses.IDatabaseResponse;
import Server.DatabaseFiles.Requests.IDatabaseRequest;
import SupportFiles.*;

public class PaymentModule implements IDatabaseModule {
    public IDatabaseResponse execute(IDatabaseRequest request) {
        Long ticketID = generateTicketID();
        Database db = Database.getInstance();

        BuyTicketRequest formalRequest = (BuyTicketRequest)request;

        // Registry transaction
        db.setTransaction(formalRequest.getTransactionID(), false);

        if (!sendMoney(formalRequest.getPaymentMethod()) || !checkMoneyReceiving()) {
            return new TicketResponse(DatabaseResponseStatus.FAILURE, null);
        }

        db.setTransaction(formalRequest.getTransactionID(), true);

        Ticket ticket = new Ticket(ticketID, formalRequest.getLocationFrom(), formalRequest.getLocationTo(),
                generatePrice(formalRequest.getLocationFrom(), formalRequest.getLocationTo()));
        db.addTicket(ticketID, new TicketData(ticket));

        return new TicketResponse(DatabaseResponseStatus.SUCCESS, ticket);
    }

    private boolean sendMoney(PaymentMethods paymentMethods) {
        /* Some very complicated algorithm */
        return true;
    }

    // check if we get money for ticket
    private boolean checkMoneyReceiving() {
        /* Some very complicated algorithm */
        return true;
    }

    private Long generateTicketID() {
        return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }

    private double generatePrice(Location from, Location to) {
        /* Some very complicated algorithm */
        return 10.5;
    }
}