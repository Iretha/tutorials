package com.smdev.spring.msg.service;

import com.smdev.spring.msg.domain.msg.Message;

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
