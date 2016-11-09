package com.smdev.spring.msg;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.smdev.spring.msg.config.DIAnnotationConfig;
import com.smdev.spring.msg.domain.Type;
import com.smdev.spring.msg.domain.msg.Message;
import com.smdev.spring.msg.domain.user.User;

/**
 * @author Ireth
 */
public class MessageAppTest {

	/**
	 * Sending fake messages by type
	 * 
	 * @param type
	 */
	private static void sendMessage(Type type) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DIAnnotationConfig.class);
		MessageApp app = context.getBean(MessageApp.class);

		User sender = (User) context.getBean("getUser", type, "@Sender", "Sender");
		User recipient1 = (User) context.getBean("getUser", type, "@Rec1", "Rec1");
		User recipient2 = (User) context.getBean("getUser", type, "@Rec2", "Rec2");
		Message message = (Message) context.getBean("getMessage", type,
				Arrays.asList(recipient1, recipient2), sender, "message");
		try {
			app.sendMessage(type, message);
		} catch (MessageAppException e) {
			e.printStackTrace();
		} finally {
			context.close(); // close the context
		}
	}

	/** Sending Facebook message */
	@Test
	public void testSendFBMessage() {
		sendMessage(Type.FB);
	}

	/** Sending E-Mail */
	@Test
	public void testSendMailMessage() {
		sendMessage(Type.MAIL);
	}

}
