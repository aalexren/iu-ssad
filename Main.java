import Client.*;
import Gates.*;
import Middleware.Firewall;
import Server.*;
import SupportFiles.*;

public class Main {
    // Simulation
    public static void main(String[] args) {

        /* Setup global section */
        // Firewall which will be used to accumulate client requests
        Firewall firewall = new Firewall();

        // User device client
        Client client = new Client(firewall);

        // Set notification types | SMS - on, Email - off, Telegram - on
        // Now a notification will be received for the selected type
        client.setNotifications(true, false, true);

        // Physical device which manages communication between open/close gates and
        // server
        GateManager gateManager = new GateManager(firewall);

        /* Setup physical gates section */
        Location Kazan = new Location("Kazan"); // Location
        InGate KazanInGate = new InGate(gateManager, Kazan); // Entrance gate in Kazan station
        OutGate KazanOutGate = new OutGate(gateManager, Kazan); // Exit gate in Kazan station

        Location Moscow = new Location("Moscow");
        InGate MoscowInGate = new InGate(gateManager, Moscow);
        OutGate MoscowOutGate = new OutGate(gateManager, Moscow);

        Location Samara = new Location("Samara");
        InGate SamaraInGate = new InGate(gateManager, Samara);
        OutGate SamaraOutGate = new OutGate(gateManager, Samara);

        Location Innopolis = new Location("Innopolis");
        InGate InnopolisInGate = new InGate(gateManager, Innopolis);
        OutGate InnopolisOutGate = new OutGate(gateManager, Innopolis);

        /* Testing section */

        /* Test #1 */
        /*
         * Situation: Try to enter transport without ticket
         */
        /*
         * Result: Gate should not open --> DENIED
         */
        System.out.println("Test #1 --> DENIED");
        client.makeGateRequest(client.chooseTicket(Kazan, Moscow), KazanInGate);
        System.out.println();

        /* Test #2 */
        /*
         * Situation: Buy ticket from Kazan to Moscow, but make a try to enter transport
         * in Samara
         */
        /*
         * Result: Gate should not open, because of wrong location destination -->
         * DENIED
         */
        System.out.println("Test #2 --> DENIED");
        client.buyTicket(Kazan, Moscow, PaymentMethods.APPLE_PAY);
        client.makeGateRequest(client.chooseTicket(Kazan, Moscow), SamaraInGate);
        System.out.println();

        /* Test #3 */
        /*
         * Situation: We have bought ticket from Kazan to Moscow, and make a try to
         * enter transport in Kazan
         */
        /*
         * Result: Gate should open, all is correct --> ACCEPTED
         */
        System.out.println("Test #3 --> ACCEPTED");
        client.makeGateRequest(client.chooseTicket(Kazan, Moscow), KazanInGate);
        System.out.println();

        /* Test #4 */
        /*
         * Situation: We have used ticket from Kazan to Moscow, but make a try to enter
         * transport in Kazan once again
         */
        /*
         * Result: Gate should not open (we already use this ticket for entrance) -->
         * DENIED
         */
        System.out.println("Test #4 --> DENIED");
        client.makeGateRequest(client.chooseTicket(Kazan, Moscow), KazanInGate);
        System.out.println();

        /* Test #5 */
        /*
         * Situation: We have ticket from Kazan to Moscow, but make a try to exit
         * transport in Samara
         */
        /*
         * Result: Gate should not open (wrong destination location) --> DENIED
         */
        System.out.println("Test #5 --> DENIED");
        client.makeGateRequest(client.chooseTicket(Kazan, Moscow), SamaraOutGate);
        System.out.println();


        // Set notification types | SMS - off, Email - on, Telegram - off
        // Now a notification will be received for the selected type
        client.setNotifications(false, true, false);

        /* Test #6 */
        /*
         * Situation: We have ticket from Kazan to Moscow, and make a try to exit
         * transport in Moscow
         */
        /*
         * Result: Gate should open, all is correct --> ACCEPTED
         */
        System.out.println("Test #6 --> ACCEPTED");
        client.makeGateRequest(client.chooseTicket(Kazan, Moscow), MoscowOutGate);
        System.out.println();

        /* Test #7 */
        /*
         * Situation: We buy ticket from Moscow to Innopolis, and make a try to enter
         * transport in Moscow
         */
        /*
         * Result: Gate should open, all is correct --> ACCEPTED
         */
        System.out.println("Test #7 --> ACCEPTED");
        client.buyTicket(Moscow, Innopolis, PaymentMethods.CARD);
        client.makeGateRequest(client.chooseTicket(Moscow, Innopolis), MoscowInGate);
        System.out.println();

        /* Test #8 */
        /*
         * Situation: We have bought 2 tickets with different "from" locations, but same
         * "to" location (imagine that you bought a ticket for yourself and another
         * person). We trying to use both tickets in one time.
         */
        /*
         * Result: Both gates should open, correct in gates --> ACCEPTED ACCEPTED
         */
        System.out.println("Test #8 --> ACCEPTED, ACCEPTED");
        client.buyTicket(Samara, Innopolis, PaymentMethods.GOOGLE_PAY);
        client.buyTicket(Kazan, Innopolis, PaymentMethods.PAYPAL);
        client.makeGateRequest(client.chooseTicket(Samara, Innopolis), SamaraInGate);
        client.makeGateRequest(client.chooseTicket(Kazan, Innopolis), KazanInGate);
        System.out.println();

        /* Test #9 */
        /*
         * Situation: We have bought 2 tickets with different "from" locations, and try
         * exit transports with corresponding correct locations
         */
        /*
         * Result: Both gates should open, correct out gates --> ACCEPTED ACCEPTED
         */
        System.out.println("Test #9 --> ACCEPTED, ACCEPTED");
        client.makeGateRequest(client.chooseTicket(Samara, Innopolis), InnopolisOutGate);
        client.makeGateRequest(client.chooseTicket(Kazan, Innopolis), InnopolisOutGate);
        System.out.println();

    }
}