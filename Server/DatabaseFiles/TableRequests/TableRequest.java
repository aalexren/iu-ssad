package Server.DatabaseFiles.TableRequests;

import Server.DatabaseFiles.Tables.DatabaseTables;
/*
 * Table Request for Database
 */
public abstract class TableRequest {
    protected DatabaseTables dbTable;

    public DatabaseTables getTableType() {
        return this.dbTable;
    };
}
