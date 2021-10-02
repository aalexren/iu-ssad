package Server.DatabaseFiles.Crypter;

import Server.DatabaseFiles.Requests.IDatabaseRequest;

public class RequestCrypter implements IDatabaseRequest {
    private IDatabaseRequest databaseRequest;
    private boolean encrypted;

    public RequestCrypter(IDatabaseRequest databaseRequest) {
        this.databaseRequest = databaseRequest;
        encrypted = true;
    }
    
    public IDatabaseRequest decrypt() {
        encrypted = false;
        return databaseRequest;
    }

    @Override
    public String getHeader() {
        return databaseRequest.getHeader();
    }   
}