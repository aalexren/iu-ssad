package Middleware.RequestHandlers;

import Server.DatabaseFiles.Cipher.ResponseCipher;
import Server.DatabaseFiles.Requests.IServerRequest;
import Server.DatabaseFiles.Responses.IResponse;
import Server.DatabaseFiles.Responses.ResponseStatus;
import Server.DatabaseFiles.Responses.ServerResponse;

public class OriginValidator extends BaseRequestHandler {

    @Override
    public IResponse handleRequest(IServerRequest request) {
        if (!isAllowedOrigin(request)) {
            // Origin is not allowed
            return new ResponseCipher(new ServerResponse(ResponseStatus.FAILURE));
        }

        return super.handleRequest(request);
    }

    private boolean isAllowedOrigin(IServerRequest request) {
        // Check that request came from verified origin
        return true;
    }

}
