package Server.DatabaseFiles;

public class Database implements IDatabase {
    private volatile static Database instance;
    private Database() { }

    public static Database getInstance() {
        if (instance == null) {
            synchronized (Database.class) {
                if (instance == null)
                    instance = new Database();
            }
        }
        return instance;
    }

    @Override
    public void execute() {

    }
}