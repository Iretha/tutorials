package com.smdev.spring.msg.service.backup;

import com.smdev.spring.msg.domain.msg.Message;
import com.smdev.spring.msg.service.BackupService;

/**
 * Singleton Service, responsible for backuping messages in the file system.
 * <br>
 *
 * Singleton means that we have only one instance for the whole application at a
 * time.
 *
 * @author Ireth
 */
public class FileSystemBackupService implements BackupService {

	@Override
	public void backup(Message message) {
		// TODO custom implementation
		System.out.println("File system backup created-> " + message.getCreateTime());
	}
}
