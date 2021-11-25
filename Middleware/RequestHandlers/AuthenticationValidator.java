package Middleware.RequestHandlers;

import Server.DatabaseFiles.Cipher.ResponseCipher;
import Server.DatabaseFiles.Requests.IServerRequest;
import Server.DatabaseFiles.Responses.IResponse;
import Server.DatabaseFiles.Responses.ResponseStatus;
import Server.DatabaseFiles.Responses.ServerResponse;

public class AuthenticationValidator extends BaseRequestHandler {
    @Override
    public IResponse handleRequest(IServerRequest request) {
        if (!isAuthenticated(request)) {
            // User is not authenticated
            return new ResponseCipher(new ServerResponse(ResponseStatus.FAILURE));
        }

        return super.handleRequest(request);
    }

    private boolean isAuthenticated(IServerRequest request) {
        // Check that request came from authenticated user
        return true;
    }
}
