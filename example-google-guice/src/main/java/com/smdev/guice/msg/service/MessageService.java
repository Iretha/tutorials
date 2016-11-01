package com.smdev.guice.msg.service;

import com.smdev.guice.msg.domain.Message;

public interface MessageService {
	
	boolean sendMessage(Message message);
}
