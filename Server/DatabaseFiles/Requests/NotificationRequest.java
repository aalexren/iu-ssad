package Server.DatabaseFiles.Requests;

import SupportFiles.*;

public class NotificationRequest extends ServerRequest{

    private NotifierType notifierType;

	public NotificationRequest(NotifierType notifierType) {
		super("NotificationRequest");
        this.notifierType = notifierType;
	}

    public NotifierType getNotifierType(){
        return this.notifierType;
    }
}