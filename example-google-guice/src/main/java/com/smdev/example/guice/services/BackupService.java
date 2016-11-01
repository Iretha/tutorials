package com.smdev.example.guice.services;

import com.smdev.example.guice.domain.Message;

public interface BackupService {

	void backup(long time, Message message);
}
