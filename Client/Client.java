package Client;

import SupportFiles.Ticket;
import SupportFiles.Location;
import Client.Modules.RFIDModule;
import Client.Modules.TicketModule;
import Gates.GateResponse;
import Gates.InGate;
import Gates.IGate;

interface IClient {
    public Ticket buyTicket(Location from, Location to);

    public void makeGateRequest(Ticket ticket, IGate gate);
}

public class Client implements IClient {

    private RFIDModule rfidModule;
    private TicketModule ticketModule;

    public Client() {

    }

    @Override
    public Ticket buyTicket(Location from, Location to) {

        return null;
    }

    // Simulates situation when we attach ticket to the gate
    // (RFID detects gate)
    @Override
    public void makeGateRequest(Ticket ticket, IGate gate) {
        GateResponse response = rfidModule.sendRequest(ticket, gate);
        System.out.println(response);
    }

}