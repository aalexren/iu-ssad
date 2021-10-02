package Server.DatabaseFiles.Requests;

import SupportFiles.PaymentMethods;
import SupportFiles.Location;

public class BuyTicketRequest extends DatabaseRequest{

    private PaymentMethods paymentMethod;
    private Location from;
    private Location to;

    public BuyTicketRequest(PaymentMethods paymentMethod, Location from, Location to){
        super("BuyTicket");
        this.paymentMethod = paymentMethod;
        this.from = from;
        this.to = to;
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

}