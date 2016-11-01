package com.smdev.example.guice.client;

import java.util.Arrays;
import java.util.List;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.smdev.example.guice.consumer.MyApplication;
import com.smdev.example.guice.domain.AppException;
import com.smdev.example.guice.domain.Message;
import com.smdev.example.guice.domain.Referent;
import com.smdev.example.guice.injector.AppInjector;

public class ClientApplication {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new AppInjector());

		MyApplication app = injector.getInstance(MyApplication.class);

		List<Referent> recipients = Arrays.asList(new Referent[] { new Referent("Peter's Address", "Peter"),
				new Referent("Miller's Address", "Miller") });

		Referent sender = new Referent("Ivan's Address", "Ivan");
		Message message = new Message(recipients, sender, "exmple message");
		try {
			app.sendMessage(message);
		} catch (AppException e) {
			// TODO
			e.printStackTrace();
		}
	}
}
