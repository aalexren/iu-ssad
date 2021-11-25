package Client.Notifications;

import Client.Modules.*;
import Server.DatabaseFiles.Requests.NotificationRequest;
import SupportFiles.NotifierType;

/*
 * Telegram decorator for Notifier.
 */
public class TelegramDecorator extends BaseDecorator{

    public TelegramDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(TransferModule transferModule){
        transferModule.sendRequest(new NotificationRequest(NotifierType.Telegram));
        System.out.println("\t\tTelegram notification was sent successfully!");
        super.send(transferModule);
    }
}