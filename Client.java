interface IClient {
    public Ticket buyTicket(Location from, Location to);
    public GateResponse activateInGate(Ticket ticket);
    public GateResponse activateOutGate(Ticket ticket); 
}

public class Client implements IClient {

    @Override
    public Ticket buyTicket(Location from, Location to) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public GateResponse activateInGate(Ticket ticket) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public GateResponse activateOutGate(Ticket ticket) {
        // TODO Auto-generated method stub
        return null;
    }

}
