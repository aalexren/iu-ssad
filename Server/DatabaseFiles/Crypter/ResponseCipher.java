package Server.DatabaseFiles.Crypter;

import Server.DatabaseFiles.Responses.ResponseStatus;
import Server.DatabaseFiles.Responses.IResponse;

/*
 * Used for encrypting and decrypting objects that implement IDatabaseResponse
 */
public class ResponseCipher implements IResponse {
    private IResponse databaseResponse;
    private boolean encrypted;

    @Override
    public ResponseStatus getStatus() {
        return databaseResponse.getStatus();
    }

    public ResponseCipher(IResponse databaseResponse) {
        this.databaseResponse = databaseResponse;
        this.encrypted = true;
    }

    public IResponse decrypt() {
        this.encrypted = false;

        return databaseResponse;
    }
}
