package Server.DatabaseFiles.TableRequests;

import Server.DatabaseFiles.Tables.DatabaseTables;

/*
 * Request to Transaction Table in Database
 */
public class TransactionTableRequest extends TableRequest {

    private Boolean value = null;
    private Long key;

    public TransactionTableRequest(Long key, Boolean value) {
        this.key = key;
        this.dbTable = DatabaseTables.TransactionTable;
        this.value = value;
    }

    public TransactionTableRequest(Long key) {
        this.key = key;
        this.dbTable = DatabaseTables.TicketTable;
    }

    public Boolean getValue() {
        return this.value;
    }

    public Long getKey() {
        return this.key;
    }

}