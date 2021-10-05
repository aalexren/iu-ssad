package Server.DatabaseFiles.Requests;

import SupportFiles.PaymentMethods;

import SupportFiles.Location;

public class BuyTicketRequest extends DatabaseRequest {

    private PaymentMethods paymentMethod;
    private Location from;
    private Location to;
    private Long transactionID;

    public BuyTicketRequest(PaymentMethods paymentMethod, Location from, Location to, Long transactionID) {
        super("BuyTicket");
        this.paymentMethod = paymentMethod;
        this.from = from;
        this.to = to;
        this.transactionID = transactionID;
    }

    public PaymentMethods getPaymentMethod() {
        return paymentMethod;
    }

    public Location getLocationFrom() {
        return from;
    }

    public Location getLocationTo() {
        return to;
    }

    public Long getTransactionID() {
        return transactionID;
    }

}