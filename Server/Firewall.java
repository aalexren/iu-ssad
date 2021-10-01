package Server;
import Server.DatabaseFiles.*;

public class Firewall extends ServerManager {
    private ServerManager serverManager;

    public Firewall(ServerManager serverManager) {
        this.serverManager = serverManager;
    }
}