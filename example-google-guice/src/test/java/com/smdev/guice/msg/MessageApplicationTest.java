package com.smdev.guice.msg;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.smdev.guice.msg.domain.AppException;
import com.smdev.guice.msg.domain.Message;
import com.smdev.guice.msg.domain.Referent;

public class MessageApplicationTest {

	@Test
	public void testSendMessage(){
		Injector injector = Guice.createInjector(new MessageApplicationInjector());

		MessageApplication app = injector.getInstance(MessageApplication.class);

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
