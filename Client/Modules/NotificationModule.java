package Client.Modules;

import Client.Notifications.Notifier;

/*
 * Module to send notifications
 */
public class NotificationModule {
    private TransferModule transferModule;
    private Notifier stack;

    public NotificationModule(TransferModule transferModule) {
        this.transferModule = transferModule;
        this.stack = new Notifier();
    }

    public void setNotificationStack(Notifier stack){
        this.stack = stack;
    }

    public void sendNotification() {
        this.stack.send(transferModule);
    }
}
