package com.smdev.spring.msg.service.mail;

import org.springframework.stereotype.Component;

import com.smdev.spring.msg.service.ActivityService;

/**
 * Service for tracking mail activity
 *
 * @author Ireth
 */
@Component("mailActivity")
public class MailActivityService implements ActivityService {

	@Override
	public void track(String activity) {
		System.out.println("MAIL: " + activity);
	}

}
