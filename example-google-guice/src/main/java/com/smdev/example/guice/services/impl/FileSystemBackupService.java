package com.smdev.example.guice.services.impl;

import com.smdev.example.guice.domain.Message;
import com.smdev.example.guice.services.BackupService;

public class FileSystemBackupService implements BackupService {

	@Override
	public void backup(long time, Message message) {
		System.out.println("Backuping " + message + " at " + time);
	}
}
