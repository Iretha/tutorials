package com.smdev.guice.msg.service.backup;

import com.smdev.guice.msg.domain.Message;
import com.smdev.guice.msg.service.BackupService;

/**
 * Service, responsible for backuping messages in the file system
 * 
 * @author Ireth
 */
public class FileSystemBackupService implements BackupService {

	@Override
	public void backup(Message message) {
		// TODO impl me
		System.out.println("File system backup created-> " + message);
	}
}
