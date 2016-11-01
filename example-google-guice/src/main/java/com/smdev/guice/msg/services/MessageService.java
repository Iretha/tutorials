package com.smdev.guice.msg.services;

import com.smdev.guice.msg.domain.Message;

public interface MessageService {
	
	boolean sendMessage(Message message);
}
