package Server.DatabaseFiles.Responses;

public class ServerResponse implements IResponse{
    private ResponseStatus status;

    public ServerResponse(ResponseStatus status) {
        this.status = status;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }
}