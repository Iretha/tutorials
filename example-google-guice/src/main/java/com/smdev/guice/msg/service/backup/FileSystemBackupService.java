package com.smdev.guice.msg.service.backup;

import javax.inject.Singleton;

import com.smdev.guice.msg.domain.message.Message;
import com.smdev.guice.msg.service.BackupService;

/**
 * Singleton Service, responsible for backuping messages in the file system.
 * <br>
 *
 * Singleton means that we have only one instance for the whole application at a
 * time.
 *
 * @author Ireth
 */
@Singleton
public class FileSystemBackupService implements BackupService {

	@Override
	public void backup(Message message) {
		// TODO custom implementation
		System.out.println("File system backup created-> " + message.getCreateTime());
	}
}
