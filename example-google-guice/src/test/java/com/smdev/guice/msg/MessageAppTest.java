package com.smdev.guice.msg;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.smdev.guice.msg.domain.DomainFactory;
import com.smdev.guice.msg.domain.message.Message;
import com.smdev.guice.msg.domain.user.User;
import com.smdev.guice.msg.config.ModuleFacebook;
import com.smdev.guice.msg.config.ModuleMail;

public class MessageAppTest {

	private static User createUser(DomainFactory factory, String name) {
		return factory.createUser("@" + name, name);
	}

	private static List<User> createUserList(DomainFactory factory, String... names) {
		List<User> list = new ArrayList<>();
		for (String name : names) {
			list.add(createUser(factory, name));
		}
		return list;
	}

	@Test
	public void testSendFbMessage() {
		Injector inj = Guice.createInjector(new ModuleFacebook());
		MessageApp app = inj.getInstance(MessageApp.class);
		
		DomainFactory factory = inj.getInstance(DomainFactory.class);
		Message msg = factory.createMessage(createUserList(factory, "Miller", "Peter"), createUser(factory, "Ivan"), "FB message");
		try {
			app.sendMessage(msg);
		} catch (MessageAppException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testSendMailMessage() {
		Injector inj = Guice.createInjector(new ModuleMail());
		MessageApp app = inj.getInstance(MessageApp.class);

		DomainFactory factory = inj.getInstance(DomainFactory.class);
		Message msg = factory.createMessage(createUserList(factory, "Miller", "Peter"), createUser(factory, "Ivan"), "Mail message");
		try {
			app.sendMessage(msg);
		} catch (MessageAppException e) {
			Assert.fail(e.getMessage());
		}
	}

}
