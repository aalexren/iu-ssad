package Server.DatabaseFiles.Responses;

public class DatabaseResponse implements IDatabaseResponse {
    private DatabaseResponseStatus status;

    public DatabaseResponse(DatabaseResponseStatus status) {
        this.status = status;
    }

    public DatabaseResponseStatus getStatus() {
        return status;
    }

    public void setStatus(DatabaseResponseStatus status) {
        this.status = status;
    }
}