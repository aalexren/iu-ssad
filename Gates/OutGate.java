package Gates;
import SupportFiles.*;

public class OutGate implements IGate {

	private GateManager gateManager;
    private Location location;
    // private static String secret =

    public OutGate(GateManager gateManager, Location location) {
        this.gateManager = gateManager;
        this.location = location;
    }

    
    @Override
    public GateResponse open() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public GateResponse close() {
        // TODO Auto-generated method stub
        return null;
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
        if (locationToCompare.getLocation() == this.location.getLocation()){
            return GateResponse.ACCEPTED;
        }
        return GateResponse.DENIED;
    }

    
}