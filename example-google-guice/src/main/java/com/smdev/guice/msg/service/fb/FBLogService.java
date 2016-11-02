package com.smdev.guice.msg.service.fb;

import javax.inject.Singleton;

import com.smdev.guice.msg.service.LogService;

@Singleton
public class FBLogService implements LogService {

	@Override
	public void log(String log) {
		System.out.println("FB: " + log);
	}

}
