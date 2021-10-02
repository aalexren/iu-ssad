package Gates;

import SupportFiles.*;

public class InGate implements IGate {

    private GateManager gateManager;
    private Location location;

    public InGate(GateManager gateManager, Location location) {
        this.gateManager = gateManager;
        this.location = location;
    }

    @Override
    public GateResponse open() {
        System.out.println("Open InGate");
        return GateResponse.ACCEPTED;
    }

    @Override
    public GateResponse close() {
        System.out.println("Close InGate");
        return GateResponse.ACCEPTED;
    }

    @Override
    public GateResponse manageRequest(Ticket ticket) {
        TicketStatus ticketStatus = gateManager.getTicketStatus(ticket);

        if (ticketStatus != TicketStatus.BOUGHT || verifyLocation(ticket.getFromLocation()) != GateResponse.ACCEPTED
                || open() != GateResponse.ACCEPTED) {
            return GateResponse.DENIED;
        }

        gateManager.setTicketStatus(ticket, TicketStatus.IN_PROCESS);
        close();
        return GateResponse.ACCEPTED;
    }

    @Override
    public GateResponse verifyLocation(Location locationToCompare) {
        if (locationToCompare.getLocation().compareTo(this.location.getLocation()) == 0){
            return GateResponse.ACCEPTED;
        }
        return GateResponse.DENIED;
    }

}