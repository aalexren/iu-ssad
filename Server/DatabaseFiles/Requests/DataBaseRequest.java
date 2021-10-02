package Server.DatabaseFiles.Requests;

public class DatabaseRequest implements IDatabaseRequest {
    private String header;

    public DatabaseRequest(String header) {
        this.header = header;
    }

    public String getHeader() {
        return this.header;
    }
} 