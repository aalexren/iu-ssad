package Server.DatabaseFiles.TableRequests;

import Server.DatabaseFiles.Tables.DatabaseTables;

public abstract class TableRequest {
    protected DatabaseTables dbTable;

    public DatabaseTables getTableType() {
        return this.dbTable;
    };
}
