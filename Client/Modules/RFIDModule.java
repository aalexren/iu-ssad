package Client.Modules;

import Gates.GateResponse;
import SupportFiles.Ticket;
import SupportFiles.Location;
import Client.Modules.RFIDModule;
import Client.Modules.TicketModule;
import Gates.GateResponse;
import Gates.InGate;
import Gates.IGate;

public class RFIDModule {

    GateResponse sendRequest(Ticket ticket, IGate gate){
        return gate.manageRequest(ticket);
    }
}