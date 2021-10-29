package Server.DatabaseFiles.Requests;

public class ServerRequest implements IServerRequest {
    private String header;

    public ServerRequest(String header) {
        this.header = header;
    }

    public String getHeader() {
        return this.header;
    }
}