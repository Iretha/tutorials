package com.smdev.spring.msg.service.fb;

import org.springframework.stereotype.Component;

import com.smdev.spring.msg.service.ActivityService;

/**
 * Service for tracking facebook activity
 *
 * @author Ireth
 */
@Component("fbActivity")
public class FBActivityService implements ActivityService {

	@Override
	public void track(String activity) {
		System.out.println("FB: " + activity);
	}

}
