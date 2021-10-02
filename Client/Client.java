package Client;

import SupportFiles.Ticket;
import SupportFiles.TicketStatus;
import SupportFiles.Location;
import SupportFiles.PaymentMethods;
import Client.Modules.RFIDModule;
import Client.Modules.TicketModule;
import Client.Modules.TransferModule;
import Client.Modules.UpdaterModule;
import Gates.GateResponse;
import Gates.IGate;

import java.util.ArrayList;


interface IClient {
    public void buyTicket(Location from, Location to, PaymentMethods paymentMethod);
    public void makeGateRequest(Ticket ticket, IGate gate);
    public void updateTickets();
}

public class Client implements IClient {

    private TransferModule transferModule;
    private RFIDModule rfidModule;
    private TicketModule ticketModule;
    private UpdaterModule updaterModule;
    private ArrayList<Ticket> ticketList;

    public Client(RFIDModule rfidModule, TicketModule ticketModule) {
        this.rfidModule   = rfidModule;
        this.ticketModule = ticketModule;
        this.ticketList   = new ArrayList<Ticket>();
    }

    public Client() {
        this.rfidModule     = new RFIDModule();
        this.transferModule = new TransferModule();
        this.updaterModule  = new UpdaterModule(transferModule);
        this.ticketModule   = new TicketModule(transferModule);
        this.ticketList     = new ArrayList<Ticket>();
    }

    public Ticket getTicket() {
        if (ticketList.isEmpty()) return null;

        return ticketList.stream()
                         .filter(x -> x.getTicketStatus() == TicketStatus.BOUGHT)
                         .findFirst()
                         .get();
    }

    @Override
    public void buyTicket(Location from, Location to, PaymentMethods paymentMethod) {
        Ticket ticket = ticketModule.sendBuyTicketRequest(paymentMethod, from, to);

        if (ticket != null){
            ticketList.add(ticket);
        }
    }

    // Simulates situation when we attach ticket to the gate
    // (RFID detects gate)
    @Override
    public void makeGateRequest(Ticket ticket, IGate gate) {
        GateResponse response = rfidModule.sendRequest(ticket, gate);
        System.out.println(response.toString());
    }

    public void updateTickets() {
        ArrayList<Ticket> temp = new ArrayList<Ticket>();
        for (int i = 0; i < ticketList.size(); ++i) {
            temp.add(updaterModule.getTicket(ticketList.get(i)));
        }
        ticketList = temp;
    }

}