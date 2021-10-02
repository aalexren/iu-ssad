package Server.DatabaseFiles.Responses;

public class DataBaseResponse implements IDataBaseResponse {
    private DataBaseResponseStatus status;

    public DataBaseResponse(DataBaseResponseStatus status) {
        this.status = status;
    }

    public DataBaseResponseStatus getStatus() {
        return status;
    }

    public void setStatus(DataBaseResponseStatus status) {
        this.status = status;
    }
}