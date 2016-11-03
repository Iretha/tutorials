package com.smdev.guice.msg.service.mail;

import javax.inject.Singleton;

import com.smdev.guice.msg.service.ActivityService;

/**
 * Service for tracking mail activity
 *
 * @author Ireth
 */
@Singleton
public class MailActivityService implements ActivityService {

	@Override
	public void track(String activity) {
		System.out.println("MAIL: " + activity);
	}

}
