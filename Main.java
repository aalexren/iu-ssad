import Client.*;
import Client.Modules.*;

import Gates.*;

import Server.*;
import Server.DatabaseFiles.*;
import Server.DatabaseFiles.Responses.*;

import SupportFiles.*;

public class Main {
    // Simulation
    public static void main(String[] args) {
        Client client = new Client();

        Firewall firewall = new Firewall();
        
        GateManager gateManager = new GateManager(firewall);        

        Location locationTo = new Location("Moscow");
        OutGate outGate = new OutGate(gateManager, locationTo);

        Location locationFrom = new Location("Kazan");
        InGate inGate = new InGate(gateManager, locationFrom);

        Location wrongLocation = new Location("Samara");
        InGate wrongInGate = new InGate(gateManager, wrongLocation);
        
        client.makeGateRequest(client.getTicket(), inGate); // No ticket, shouldn't open
        
        client.buyTicket(locationFrom, locationTo, PaymentMethods.APPLE_PAY);

        client.makeGateRequest(client.getTicket(), wrongInGate); // Wrong entrance location, shouldn't open

        client.makeGateRequest(client.getTicket(), inGate); // We've bought ticket, should open

        client.makeGateRequest(client.getTicket(), outGate); // Correct location, can exit -> should open
    }
}