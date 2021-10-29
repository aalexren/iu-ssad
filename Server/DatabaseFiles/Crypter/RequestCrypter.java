package Server.DatabaseFiles.Crypter;

import Server.DatabaseFiles.Requests.IServerRequest;

/* 
* Used for encrypting and decrypting objects that implement IDatabaseRequest
*/
public class RequestCrypter implements IServerRequest {
    private IServerRequest databaseRequest;
    private boolean encrypted;

    public RequestCrypter(IServerRequest databaseRequest) {
        this.databaseRequest = databaseRequest;
        encrypted = true;
    }

    public IServerRequest decrypt() {
        encrypted = false;
        return databaseRequest;
    }

    @Override
    public String getHeader() {
        return databaseRequest.getHeader();
    }
}