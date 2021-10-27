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

        BuyTicketRequest formalRequest = (BuyTicketRequest) request;

        // Registry transaction
        TransactionTableRequest createTransactionRequest = new TransactionTableRequest(formalRequest.getTransactionID(),
                false);
        db.create(createTransactionRequest);

        if (!sendMoney(formalRequest.getPaymentMethod()) || !checkMoneyReceiving()) {
            return new TicketResponse(DatabaseResponseStatus.FAILURE, null);
        }

        // Update transaction
        TransactionTableRequest updateTransactionRequest = new TransactionTableRequest(formalRequest.getTransactionID(),
                true);
        db.update(updateTransactionRequest);

        Ticket ticket = new Ticket(ticketID, formalRequest.getLocationFrom(), formalRequest.getLocationTo(),
                generatePrice(formalRequest.getLocationFrom(), formalRequest.getLocationTo()));

        TicketTableRequest createTicketRequest = new TicketTableRequest(ticketID, new TicketData(ticket));
        db.create(createTicketRequest);

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