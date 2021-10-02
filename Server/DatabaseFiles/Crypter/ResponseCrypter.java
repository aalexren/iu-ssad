package Server.DatabaseFiles.Crypter;

import Server.DatabaseFiles.Responses.DatabaseResponseStatus;
import Server.DatabaseFiles.Responses.IDatabaseResponse;

public class ResponseCrypter implements IDatabaseResponse{
    private IDatabaseResponse databaseResponse;
    private boolean encrypted;

    @Override
    public DatabaseResponseStatus getStatus() {
        return databaseResponse.getStatus();
    }

    public ResponseCrypter(IDatabaseResponse databaseResponse){
        this.databaseResponse = databaseResponse;
        encrypted = true;
    }
    
    public IDatabaseResponse decrypt(){
        encrypted = false;
        return databaseResponse;
    }
}
