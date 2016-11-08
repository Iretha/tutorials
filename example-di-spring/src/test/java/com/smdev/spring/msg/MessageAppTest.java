package com.smdev.spring.msg;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.smdev.spring.msg.config.DIAnnotationConfig;
import com.smdev.spring.msg.domain.msg.Message;
import com.smdev.spring.msg.domain.user.User;
import com.smdev.spring.msg.service.fb.FBMessage;
import com.smdev.spring.msg.service.fb.FBUser;

public class MessageAppTest {

	// private static User createUser(DomainFactory factory, String name) {
	// return factory.createUser("@" + name, name);
	// }
	//
	// private static List<User> createUserList(DomainFactory factory, String... names) {
	// List<User> list = new ArrayList<>();
	// for (String name : names) {
	// list.add(createUser(factory, name));
	// }
	// return list;
	// }
	//
	// /**
	// * @param inj
	// */
	// private void sendMessage(Injector inj, String msgText) {
	// MessageApp app = inj.getInstance(MessageApp.class);
	//
	// DomainFactory factory = inj.getInstance(DomainFactory.class);
	// Message msg = factory.createMessage(createUserList(factory, "Miller", "Peter"),
	// createUser(factory, "Ivan"), msgText);
	// try {
	// app.sendMessage(msg);
	// } catch (MessageAppException e) {
	// Assert.fail(e.getMessage());
	// }
	// }
	//
	// @Test
	// public void testSendFbMessage() {
	// Injector inj = Guice.createInjector(new ModuleFacebook());
	// sendMessage(inj, "FB message");
	// }
	//
	// @Test
	// public void testSendMailMessage() {
	// Injector inj = Guice.createInjector(new ModuleMail());
	// sendMessage(inj, "Mail message");
	// }

	@Test
	public void testSendFBMessage_Annot_Config() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DIAnnotationConfig.class);
		MessageConfigWithAnnotApp app = context.getBean(MessageConfigWithAnnotApp.class);

		User sender = new FBUser("@fbSender", "fbSender");
		User recipient = new FBUser("@fbRec", "fbRec");
		Message message = new FBMessage(Arrays.asList(recipient), sender, "fbMessage");
		try {
			app.sendMessage(message);
		} catch (MessageAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// close the context
			context.close();
		}
	}

}
