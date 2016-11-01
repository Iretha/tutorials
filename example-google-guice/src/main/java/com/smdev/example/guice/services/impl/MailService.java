package com.smdev.example.guice.services.impl;

import javax.inject.Singleton;

import com.smdev.example.guice.domain.Message;
import com.smdev.example.guice.services.MessageService;

@Singleton
public class MailService implements MessageService {

	@Override
	public boolean sendMessage(Message message){
		// TODO Auto-generated method stub
		System.out.println("Email Message sent ");
		return true;
	}
}
