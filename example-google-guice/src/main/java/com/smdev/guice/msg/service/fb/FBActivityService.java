package com.smdev.guice.msg.service.fb;

import javax.inject.Singleton;

import com.smdev.guice.msg.service.ActivityService;

/**
 * Service for tracking facebook activity
 * @author Ireth
 */
@Singleton
public class FBActivityService implements ActivityService {

	@Override
	public void track(String activity) {
		System.out.println("FB: " + activity);
	}

}
