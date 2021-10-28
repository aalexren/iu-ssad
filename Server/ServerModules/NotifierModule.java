package Server.ServerModules;

import Server.DatabaseFiles.Requests.IServerRequest;
import Server.DatabaseFiles.Requests.NotificationRequest;
import Server.DatabaseFiles.Responses.*;

public class NotifierModule implements IServerModule {

	@Override
	public IResponse execute(IServerRequest request) {
		NotificationRequest formalRequest = (NotificationRequest) request;

		ServerResponse response = new ServerResponse(ResponseStatus.SUCCESS);

		switch (formalRequest.getNotifierType()) {
		case SMS:
			sendSMS();
			break;
		case Email:
			sendEmailMessage();
			break;
		case Telegram:
			sendTelegramMessage();
			break;
		default:
			response = new ServerResponse(ResponseStatus.FAILURE);
			break;
		}

		return response;

	}

	private void sendSMS() {
	}

	private void sendEmailMessage() {
	}

	private void sendTelegramMessage() {
	}
}