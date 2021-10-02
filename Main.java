import Client.*;
import Gates.*;
import Server.*;
import SupportFiles.*;

public class Main {
    // Simulation
    public static void main(String[] args) {
        Firewall firewall = new Firewall();

        Client client = new Client(firewall);
        
        GateManager gateManager = new GateManager(firewall);        

        Location locationFrom = new Location("Kazan");
        InGate inGate = new InGate(gateManager, locationFrom);

        Location locationTo = new Location("Moscow");
        OutGate outGate = new OutGate(gateManager, locationTo);

        Location wrongLocation = new Location("Samara");
        InGate wrongInGate = new InGate(gateManager, wrongLocation);
        OutGate wrongOutGate = new OutGate(gateManager, wrongLocation);
        
        client.makeGateRequest(client.getTicket(), inGate); // No ticket, shouldn't open
        
        client.buyTicket(locationFrom, locationTo, PaymentMethods.APPLE_PAY);

        client.makeGateRequest(client.getTicket(), wrongInGate); // Wrong entrance location, shouldn't open

        client.makeGateRequest(client.getTicket(), inGate); // We've bought ticket, should open

        client.makeGateRequest(client.getTicket(), inGate); // Want to exit at wrong station, shouldn't open

        client.makeGateRequest(client.getTicket(), outGate); // Correct location, can exit -> should open

        client.makeGateRequest(client.getTicket(), inGate); // No ticket, shouldn't open
    }
}