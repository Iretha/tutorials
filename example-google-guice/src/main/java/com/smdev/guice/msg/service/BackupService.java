package com.smdev.guice.msg.service;

import com.smdev.guice.msg.domain.message.Message;

/**
 * Service for backuping messages
 *
 * @author Ireth
 */
public interface BackupService {

	/**
	 * Backup a message
	 *
	 * @param message
	 */
	void backup(Message message);
}
