package com.smdev.guice.msg;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.smdev.guice.msg.domain.MessageException;
import com.smdev.guice.msg.domain.Message;
import com.smdev.guice.msg.domain.MessageReferent;

public class MessageApplicationTest {

	@Test
	public void testSendMessage(){
		Injector injector = Guice.createInjector(new MessageAppInjector());

		MessageApp app = injector.getInstance(MessageApp.class);

		List<MessageReferent> recipients = Arrays.asList(new MessageReferent[] { new MessageReferent("Peter's Address", "Peter"),
				new MessageReferent("Miller's Address", "Miller") });

		MessageReferent sender = new MessageReferent("Ivan's Address", "Ivan");
		Message message = new Message(recipients, sender, "exmple message");
		try {
			app.sendMessage(message);
		} catch (MessageException e) {
			// TODO
			e.printStackTrace();
		}
	}
}
