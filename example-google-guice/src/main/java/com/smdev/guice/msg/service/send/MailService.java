package com.smdev.guice.msg.service.send;

import javax.inject.Singleton;

import com.smdev.guice.msg.domain.Message;
import com.smdev.guice.msg.service.MessageService;

@Singleton
public class MailService implements MessageService {

	@Override
	public boolean sendMessage(Message message){
		// TODO Auto-generated method stub
		System.out.println("Email Message sent ");
		return true;
	}
}
