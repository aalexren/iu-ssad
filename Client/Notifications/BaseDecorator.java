package Client.Notifications;

import Client.Modules.*;

class BaseDecorator extends Notifier {
    private Notifier wrappee;

    public BaseDecorator(Notifier notifier) {
        wrappee = notifier;
    }

    public void send(TransferModule transferModule) {
        wrappee.send(transferModule);
    }
}