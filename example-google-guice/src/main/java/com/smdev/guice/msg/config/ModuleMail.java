package com.smdev.guice.msg.config;

import com.google.inject.Scopes;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.smdev.guice.msg.domain.DomainFactory;
import com.smdev.guice.msg.domain.message.Message;
import com.smdev.guice.msg.domain.user.User;
import com.smdev.guice.msg.service.ActivityService;
import com.smdev.guice.msg.service.MessageService;
import com.smdev.guice.msg.service.mail.MailActivityService;
import com.smdev.guice.msg.service.mail.MailMessage;
import com.smdev.guice.msg.service.mail.MailMessageService;
import com.smdev.guice.msg.service.mail.MailType;
import com.smdev.guice.msg.service.mail.MailUser;

/**
 * Specific configuration of the mail module
 *
 * @author Ireth
 */
public class ModuleMail extends ModuleBase {

	@Override
	protected void configure() {
		super.configure();
		/* Factory for specific mail object types */
		install(new FactoryModuleBuilder().implement(User.class, MailUser.class)
				.implement(Message.class, MailMessage.class).build(DomainFactory.class));

		/* Linked binding -> maps a type to its implementation
		 *
		 * In this case we will use only one implementation at a time. Linked
		 * bindings can also be chained.
		 *
		 * Scopes.SINGLETON ensures that we have only one instance of the type
		 * for the whole application at a time */
		bind(MessageService.class).to(MailMessageService.class).in(Scopes.SINGLETON);

		/* Built-in binding annotation @Named -> maps an annotated type to its
		 * implementation
		 *
		 * Custom annotation type -> maps an annotated type to its
		 * implementation */
		bind(ActivityService.class).annotatedWith(MailType.class).to(MailActivityService.class)
				.in(Scopes.SINGLETON);
	}
}
