package com.smdev.guice.msg.services;

import com.smdev.guice.msg.domain.Message;

public interface BackupService {

	void backup(long time, Message message);
}
