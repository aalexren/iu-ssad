package Client.Modules;

import Gates.GateResponse;
import SupportFiles.Ticket;
import Client.Modules.RFIDModule;
import Gates.IGate;

public class RFIDModule {

    int ID;

    public GateResponse sendRequest(Ticket ticket, IGate gate){
        return gate.manageRequest(ticket);
    }
}