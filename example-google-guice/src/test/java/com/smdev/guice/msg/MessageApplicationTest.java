package com.smdev.guice.msg;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.smdev.guice.msg.domain.MessageException;
import com.smdev.guice.msg.domain.Message;
import com.smdev.guice.msg.domain.Correspondent;

public class MessageApplicationTest {

	private static Correspondent createCorresp(String name) {
		return new Correspondent("@"+name , name);
	}

	private static List<Correspondent> createCorrespList(String... names) {
		List<Correspondent> list = new ArrayList<>();
		for (String name : names) {
			list.add(createCorresp(name));
		}
		return list;
	}

	@Test
	public void testSendMessage() {
		Injector injector = Guice.createInjector(new MessageAppInjector());
		MessageApp app = injector.getInstance(MessageApp.class);

		try {
			app.sendMessage(new Message(createCorrespList("Miller", "Peter"), createCorresp("Ivan"), "exmple message"));
		} catch (MessageException e) {
			Assert.fail(e.getMessage());
		}
	}

}
