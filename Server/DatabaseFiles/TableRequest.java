package Server.DatabaseFiles;

public abstract class TableRequest{
    protected DatabaseTables dbTable;

    public DatabaseTables getTableType(){
        return this.dbTable;
    };
}
