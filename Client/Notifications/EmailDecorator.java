package Client.Notifications;

import Client.Modules.*;
import Server.DatabaseFiles.Requests.NotificationRequest;
import SupportFiles.NotifierType;

public class EmailDecorator extends BaseDecorator {

    public EmailDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(TransferModule transferModule){
        transferModule.sendRequest(new NotificationRequest(NotifierType.Email));
        System.out.println("\t\tEmail notfication was sent successfully!");
        super.send(transferModule);
    }
}