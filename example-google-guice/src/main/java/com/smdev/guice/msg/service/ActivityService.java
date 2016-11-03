package com.smdev.guice.msg.service;

/**
 * Service for tracking activity
 *
 * @author Ireth
 */
public interface ActivityService {
	/**
	 * @param activity
	 */
	void track(String activity);
}
