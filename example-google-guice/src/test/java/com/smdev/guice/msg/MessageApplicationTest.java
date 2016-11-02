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
		return new Correspondent("@" + name, name);
	}

	private static List<Correspondent> createCorrespList(String... names) {
		List<Correspondent> list = new ArrayList<>();
		for (String name : names) {
			list.add(createCorresp(name));
		}
		return list;
	}

	@Test
	public void testSendFbMessage() {
		Injector inj = Guice.createInjector(new ModuleFacebook());
		MessageApp app = inj.getInstance(MessageApp.class);

		try {
			app.sendMessage(
					new Message(createCorrespList("Miller", "Peter"), createCorresp("Ivan"), "FB message"));
		} catch (MessageException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testSendMailMessage() {
		Injector inj = Guice.createInjector(new ModuleMail());
		MessageApp app = inj.getInstance(MessageApp.class);

		try {
			app.sendMessage(
					new Message(createCorrespList("Miller", "Peter"), createCorresp("Ivan"), "Email message"));
		} catch (MessageException e) {
			Assert.fail(e.getMessage());
		}
	}

}
