package com.smdev.example.guice.services.impl;

import javax.inject.Singleton;

import com.smdev.example.guice.domain.Message;
import com.smdev.example.guice.services.MessageService;

@Singleton
public class FacebookService implements MessageService {

	@Override
	public boolean sendMessage(Message message){
		//TODO
		System.out.println("FB Message sent");
		return true;
	}

}
