package Client;

import SupportFiles.Ticket;
import SupportFiles.Location;
import Client.Modules.RFIDModule;
import Client.Modules.TicketModule;
import Gates.GateResponse;

interface IClient {
    public Ticket buyTicket(Location from, Location to);
    public GateResponse activateInGate(Ticket ticket);
    public GateResponse activateOutGate(Ticket ticket); 
}

public class Client implements IClient {

    public Client() {

    }

    @Override
    public Ticket buyTicket(Location from, Location to) {

        return null;
    }

    @Override
    public GateResponse activateInGate(Ticket ticket) {

        return null;
    }

    @Override
    public GateResponse activateOutGate(Ticket ticket) {

        return null;
    }

    private RFIDModule rfidModule;
    private TicketModule ticketModule;
}