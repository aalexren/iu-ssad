package Server.DatabaseFiles.Requests;

import SupportFiles.PaymentMethods;
import SupportFiles.Location;

public class BuyTicketRequest extends DatabaseRequest{

    private PaymentMethods paymentMethod;
    private Location from;
    private Location to;
    private long transactionID;

    public BuyTicketRequest(PaymentMethods paymentMethod, Location from, Location to, long transactionID){
        super("BuyTicket");
        this.paymentMethod = paymentMethod;
        this.from = from;
        this.to = to;
        this.transactionID = transactionID;
    }

    public PaymentMethods getPaymentMethod(){
        return paymentMethod;
    }

    public Location getLocationFrom(){
        return from;
    }

    public Location getLocationTo(){
        return to;
    }

    public long getTransactionID(){
        return transactionID;
    }

}