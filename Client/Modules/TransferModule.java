package Client.Modules;

import Server.DatabaseFiles.IDatabase;
import Server.DatabaseFiles.Crypter.RequestCrypter;
import Server.DatabaseFiles.Requests.IServerRequest;
import Server.DatabaseFiles.Responses.IResponse;
import Server.DatabaseFiles.Crypter.ResponseCrypter;

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
        RequestCrypter requestCrypter = new RequestCrypter(databaseRequest);
        IResponse databaseResponse = fireWall.execute(requestCrypter);
        return ((ResponseCrypter)databaseResponse).decrypt();
    }
}
