package com.smdev.guice.msg.service.backup;

import com.smdev.guice.msg.domain.Message;
import com.smdev.guice.msg.service.BackupService;

public class FileSystemBackupService implements BackupService {

	@Override
	public void backup(long time, Message message) {
		System.out.println("Backuping " + message + " at " + time);
	}
}
