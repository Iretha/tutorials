package com.smdev.guice.msg.service.fb;

import javax.inject.Inject;
import com.smdev.guice.msg.domain.message.Message;
import com.smdev.guice.msg.service.ActivityService;
import com.smdev.guice.msg.service.MessageService;

/**
 * Service for sending Facebook messages
 * 
 * @author Ireth
 */
public class FBMessageService implements MessageService {

	@Inject
	private @FBType ActivityService fbActivity;

	@Override
	public boolean send(Message message) {
		this.fbActivity.track("Sending message " + message + "...");
		// TODO custom implementation
		return true;
	}

}
