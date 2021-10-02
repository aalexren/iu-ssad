package Server;
import Server.DatabaseFiles.*;
import Server.DatabaseFiles.Requests.*;
import Server.DatabaseFiles.Responses.*;
import Server.DatabaseModules.*;

public class Firewall implements IDatabase {
    private ServerManager serverManager;

    //Firewall should ckeck if it can connect server with client
    private boolean checkConnection() {
        //Some check stuf
        return true;
    }

    public Firewall() {
        this.serverManager = new ServerManager(new PaymentModule(), new ValidationModule());
    }

    @Override
    public IDataBaseResponse execute(DataBaseRequest request) {
        if (checkConnection()){
            return serverManager.execute(request);
        }
        return new DataBaseResponse(DataBaseResponseStatus.FAILURE);
    }
    
}