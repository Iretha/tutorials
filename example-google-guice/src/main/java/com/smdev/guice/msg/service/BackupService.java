package com.smdev.guice.msg.service;

import com.smdev.guice.msg.domain.Message;

public interface BackupService {

	void backup(long time, Message message);
}
