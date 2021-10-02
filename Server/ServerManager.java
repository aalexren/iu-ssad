package Server;
import Server.DatabaseFiles.*;
import Server.DatabaseFiles.Requests.DataBaseRequest;
import Server.DatabaseFiles.Responses.IDataBaseResponse;
import Server.DatabaseModules.IPaymentModule;
import Server.DatabaseModules.IValidationModule;

public class ServerManager implements IDatabase {
    private Database database;

    private IPaymentModule paymentModule;
    private IValidationModule validationModule;

    public ServerManager(IPaymentModule paymentModule, IValidationModule validationModule) {
        this.database = Database.getInstance();
        this.paymentModule = paymentModule;
        this.validationModule = validationModule;
    }

    @Override
    public IDataBaseResponse execute(DataBaseRequest request) {
        // TODO Auto-generated method stub
        return null;
    }
}
