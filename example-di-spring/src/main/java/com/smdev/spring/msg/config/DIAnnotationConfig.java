package com.smdev.spring.msg.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.smdev.spring.msg.domain.Type;
import com.smdev.spring.msg.domain.msg.Message;
import com.smdev.spring.msg.domain.user.User;
import com.smdev.spring.msg.service.BackupService;
import com.smdev.spring.msg.service.backup.FileSystemBackupService;
import com.smdev.spring.msg.service.fb.FBMessage;
import com.smdev.spring.msg.service.fb.FBUser;
import com.smdev.spring.msg.service.mail.MailMessage;
import com.smdev.spring.msg.service.mail.MailUser;

/**
 * Spring configuration
 *
 * @author Ireth
 */
@Configuration
@ComponentScan(value = { "com.smdev.spring.msg" })
@PropertySource("classpath:props.properties")
public class DIAnnotationConfig {

	/**
	 * Property placeholder configurer needed to process @Value annotations
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	/**
	 * @return {@linkplain FileSystemBackupService}
	 */
	@Bean
	@Scope("singleton")
	public BackupService getBackupService() {
		return new FileSystemBackupService();
	}

	/**
	 * Creates new instance of a message, depending on the type - FB or Mail
	 *
	 * @param type
	 * @param recipients
	 * @param sender
	 * @param text
	 * @return message
	 */
	@Bean
	@Scope("prototype")
	public Message getMessage(Type type, List<User> recipients, User sender, String text) {
		if (type.equals(Type.FB)) {
			return new FBMessage(recipients, sender, text);
		} else {
			return new MailMessage(recipients, sender, text);
		}
	}

	/**
	 * Creates new instance of a user, depending on the type - FB or Mail
	 *
	 * @param type
	 * @param userName
	 * @param name
	 * @return user
	 */
	@Bean
	@Scope("prototype")
	public User getUser(Type type, String userName, String name) {
		if (type.equals(Type.FB)) {
			return new FBUser(userName, name);
		} else {
			return new MailUser(userName, name);
		}
	}
}
