package Server.DatabaseFiles.Requests;

public abstract class DataBaseRequest {
    private String header;

    public DataBaseRequest(String header) {
        this.header = header;
    }

    public String getHeader() {
        return this.header;
    }
} 