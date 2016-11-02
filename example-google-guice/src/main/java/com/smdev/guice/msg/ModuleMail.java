package com.smdev.guice.msg;

import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.smdev.guice.msg.domain.user.User;
import com.smdev.guice.msg.domain.user.UserFactory;
import com.smdev.guice.msg.service.MessageService;
import com.smdev.guice.msg.service.module.mail.MailService;
import com.smdev.guice.msg.service.module.mail.MailUser;

/**
 * Google Guice DI configuration
 * 
 * @author Ireth
 */
public class ModuleMail extends ModuleBase {

	@Override
	protected void configure() {
		super.configure();
		/*
		 * Linked binding -> maps a type to its implementation
		 * 
		 * In this case we will use only one implementation at a time. Linked
		 * bindings can also be chained.
		 * 
		 * Scopes.SINGLETON ensures that we have only one instance of the type
		 * for the whole application at a time
		 */
		bind(MessageService.class).to(MailService.class);

		/*
		 * Factory for email users
		 */
		install(new FactoryModuleBuilder().implement(User.class, MailUser.class).build(UserFactory.class));
	}

}
