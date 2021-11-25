package Server.DatabaseFiles.Cipher;

import Server.DatabaseFiles.Requests.IServerRequest;

/*
* Used for encrypting and decrypting objects that implement IDatabaseRequest
*/
public class RequestCipher implements IServerRequest {
    private IServerRequest databaseRequest;
    private boolean encrypted;

    public RequestCipher(IServerRequest databaseRequest) {
        this.databaseRequest = databaseRequest;
        this.encrypted = true;
    }

    public IServerRequest decrypt() {
        this.encrypted = false;

        return databaseRequest;
    }

    @Override
    public String getHeader() {
        return databaseRequest.getHeader();
    }
}