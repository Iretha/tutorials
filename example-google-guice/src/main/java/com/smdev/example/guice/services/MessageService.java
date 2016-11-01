package com.smdev.example.guice.services;

import com.smdev.example.guice.domain.Message;

public interface MessageService {
	
	boolean sendMessage(Message message) throws MessageException;
}
