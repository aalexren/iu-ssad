package Middleware.RequestHandlers;

import Server.DatabaseFiles.Requests.IServerRequest;
import Server.DatabaseFiles.Responses.IResponse;
import Server.DatabaseFiles.Responses.ResponseStatus;
import Server.DatabaseFiles.Responses.ServerResponse;
import Server.DatabaseFiles.Cipher.ResponseCipher;

public class DDoSPreventer extends BaseRequestHandler {

    @Override
    public IResponse handleRequest(IServerRequest request) {
        if (isDDoS(request)) {
            // There is DDoS attack
            return new ResponseCipher(new ServerResponse(ResponseStatus.FAILURE));
        }

        return super.handleRequest(request);
    }

    private boolean isDDoS(IServerRequest request) {
        // Check if there is DDoS attack on server
        return false;
    }
}
