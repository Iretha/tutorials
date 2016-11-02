package com.smdev.guice.msg.service.mail;

import javax.inject.Singleton;

import com.smdev.guice.msg.service.LogService;

@Singleton
public class MailLogService implements LogService {

	@Override
	public void log(String log) {

		System.out.println("MAIL: " + log);
	}

}
