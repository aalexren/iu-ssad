package Client.Notifications;

import Client.Modules.*;

/*
 * This base decorator for notifier.
 */
class BaseDecorator extends Notifier {
    private Notifier NotifierWrapper;

    public BaseDecorator(Notifier notifier) {
        NotifierWrapper = notifier;
    }

    public void send(TransferModule transferModule) {
        NotifierWrapper.send(transferModule);
    }
}