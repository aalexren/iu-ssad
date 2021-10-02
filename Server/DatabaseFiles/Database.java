package Server.DatabaseFiles;

import Server.DatabaseFiles.Responses.IDataBaseResponse;
import Server.DatabaseFiles.Requests.DataBaseRequest;

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
	public IDataBaseResponse execute(DataBaseRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
}