package com.smdev.spring.msg.service.fb;

import javax.annotation.Resource;

import com.smdev.spring.msg.domain.msg.Message;
import com.smdev.spring.msg.service.ActivityService;
import com.smdev.spring.msg.service.MessageService;

/**
 * Service for sending Facebook messages
 *
 * @author Ireth
 */
public class FBMessageService implements MessageService {

	@Resource(name = "fbActivity")
	private ActivityService fbActivity;

	@Override
	public boolean send(Message message) {
		this.fbActivity.track("Sending message " + message + "...");
		// TODO custom implementation
		return true;
	}

}
