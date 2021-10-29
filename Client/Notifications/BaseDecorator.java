package Client.Notifications;

import Client.Modules.*;

/*
 * This base decorator for notifier.
 */
class BaseDecorator extends Notifier {
    private Notifier wrapper;

    public BaseDecorator(Notifier notifier) {
        wrapper = notifier;
    }

    public void send(TransferModule transferModule) {
        wrapper.send(transferModule);
    }
}