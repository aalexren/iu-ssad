package Client.Modules;

import Server.DatabaseFiles.IDatabase;
import Server.DatabaseFiles.Crypter.RequestCipher;
import Server.DatabaseFiles.Requests.IServerRequest;
import Server.DatabaseFiles.Responses.IResponse;
import Server.DatabaseFiles.Crypter.ResponseCipher;

/*
* This module is used to take requests from other modules, encrypt them,
* send to database and return decrypted response
*/
public class TransferModule {
    private IDatabase fireWall;

    public TransferModule(IDatabase firewall) {
        this.fireWall = firewall;
    }

    public IResponse sendRequest(IServerRequest databaseRequest) {
        RequestCipher requestCipher = new RequestCipher(databaseRequest);
        IResponse databaseResponse = fireWall.execute(requestCipher);
        return ((ResponseCipher)databaseResponse).decrypt();
    }
}
