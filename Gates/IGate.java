package Gates;
import SupportFiles.Location;
import SupportFiles.Ticket; 

public interface IGate {
    public GateResponse manageRequest(Ticket ticket);
    public GateResponse verifyLocation(Location locationToCompare);
    public GateResponse open();
    // Close the door with some delay
    public GateResponse close();
}
