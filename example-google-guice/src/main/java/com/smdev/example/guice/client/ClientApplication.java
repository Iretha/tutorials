package com.smdev.example.guice.client;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.smdev.example.guice.consumer.MyApplication;
import com.smdev.example.guice.domain.Message;
import com.smdev.example.guice.domain.Referent;
import com.smdev.example.guice.injector.AppInjector;
import com.smdev.example.guice.services.MessageException;

public class ClientApplication {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new AppInjector());		
		
		MyApplication app = injector.getInstance(MyApplication.class);
		
		List<Referent> recipients = new ArrayList<>();
		recipients.add(new Referent("rAddress", "rName"));
		Referent sender = new Referent("sAddress", "sName");
		Message message = new Message(recipients, sender, "text");
		try {
			app.sendMessage(message);
		} catch (MessageException e) {
			// TODO
			e.printStackTrace();
		}
	}
}
