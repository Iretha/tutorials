package com.smdev.guice.msg;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.smdev.guice.msg.domain.MessageException;
import com.smdev.guice.msg.domain.user.User;
import com.smdev.guice.msg.domain.user.UserFactory;
import com.smdev.guice.msg.domain.Message;

public class MessageAppTest {

	private static User createUser(Injector inj, String name) {
		UserFactory factory = inj.getInstance(UserFactory.class);
		return factory.createUser("@" + name, name);
	}

	private static List<User> createUserList(Injector inj, String... names) {
		List<User> list = new ArrayList<>();
		for (String name : names) {
			list.add(createUser(inj, name));
		}
		return list;
	}

	@Test
	public void testSendFbMessage() {
		Injector inj = Guice.createInjector(new ModuleFacebook());
		MessageApp app = inj.getInstance(MessageApp.class);

		try {
			app.sendMessage(new Message(createUserList(inj, "Miller", "Peter"), createUser(inj, "Ivan"), "FB message"));
		} catch (MessageException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testSendMailMessage() {
		Injector inj = Guice.createInjector(new ModuleMail());
		MessageApp app = inj.getInstance(MessageApp.class);

		try {
			app.sendMessage(new Message(createUserList(inj, "Miller", "Peter"), createUser(inj, "Ivan"), "Email message"));
		} catch (MessageException e) {
			Assert.fail(e.getMessage());
		}
	}

}
