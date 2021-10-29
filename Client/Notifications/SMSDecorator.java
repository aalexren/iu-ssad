package Client.Notifications;

import Client.Modules.*;
import Server.DatabaseFiles.Requests.NotificationRequest;
import SupportFiles.NotifierType;

/*
 * SMS decorator for Notifier.
 */
public class SMSDecorator extends BaseDecorator{

    public SMSDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(TransferModule transferModule){
        transferModule.sendRequest(new NotificationRequest(NotifierType.SMS));
        System.out.println("\t\tSMS notfication was sent successfully!");
        super.send(transferModule);
    }
}