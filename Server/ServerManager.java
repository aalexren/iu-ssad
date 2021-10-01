package Server;
import Server.DatabaseFiles.*;

public class ServerManager implements IDatabase {
    private Database database;

    public ServerManager() {
        database = Database.getInstance();
    }

    @Override
    public void execute() {

    }
}
