package Gates;

import SupportFiles.*;

/*
* Gate of exit
*/
public class OutGate implements IGate {

    private GateManager gateManager;
    private Location location;

    public OutGate(GateManager gateManager, Location location) {
        this.gateManager = gateManager;
        this.location = location;
    }

    @Override
    public GateResponse open() {
        return GateResponse.ACCEPTED;
    }

    @Override
    public GateResponse close() {
        return GateResponse.ACCEPTED;
    }

    @Override
    public GateResponse manageRequest(Ticket ticket) {
        TicketStatus ticketStatus = gateManager.getTicketStatus(ticket);

        if (ticketStatus != TicketStatus.IN_PROCESS || verifyLocation(ticket.getToLocation()) != GateResponse.ACCEPTED
                || open() != GateResponse.ACCEPTED) {
            return GateResponse.DENIED;
        }

        gateManager.setTicketStatus(ticket, TicketStatus.UTILIZED);
        close();
        return GateResponse.ACCEPTED;
    }

    @Override
    public GateResponse verifyLocation(Location locationToCompare) {
        if (locationToCompare.getLocation().compareTo(this.location.getLocation()) == 0) {
            return GateResponse.ACCEPTED;
        }
        return GateResponse.DENIED;
    }

}