package Client.Modules;

import Gates.GateResponse;
import SupportFiles.Ticket;

import Client.Modules.RFIDModule;
import Gates.IGate;

import java.util.UUID;

/*
 * This class supposed to be just a mediator between the gates and the client.
 */
public class RFIDModule {

    private final UUID id; // Unique hash to identify the RFID

    public RFIDModule() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return this.id;
    }

    public GateResponse sendRequest(Ticket ticket, IGate gate) {
        return gate.manageRequest(ticket);
    }
}