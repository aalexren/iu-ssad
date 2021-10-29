package Server.DatabaseFiles.TableRequests;

import Server.DatabaseFiles.Tables.DatabaseTables;
import Server.DatabaseFiles.TicketData;

/*
 * Request to Ticket Table in Database
 */
public class TicketTableRequest extends TableRequest {

    private TicketData value = null;
    private Long key;

    public TicketTableRequest(Long key, TicketData value) {
        this.key = key;
        this.dbTable = DatabaseTables.TicketTable;
        this.value = value;
    }

    public TicketTableRequest(Long key) {
        this.key = key;
        this.dbTable = DatabaseTables.TicketTable;
    }

    public TicketData getValue() {
        return this.value;
    }

    public Long getKey() {
        return this.key;
    }

}