package com.smdev.guice.msg;

import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.smdev.guice.msg.domain.user.User;
import com.smdev.guice.msg.domain.user.UserFactory;
import com.smdev.guice.msg.service.MessageService;
import com.smdev.guice.msg.service.module.fb.FBUser;
import com.smdev.guice.msg.service.module.fb.FacebookService;

/**
 * Google Guice DI configuration
 * 
 * @author Ireth
 */
public class ModuleFacebook extends ModuleBase {

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
		bind(MessageService.class).to(FacebookService.class);
		
		/*
		 * Factory for facebook users
		 */
		install(new FactoryModuleBuilder().implement(User.class, FBUser.class).build(UserFactory.class));
	}

}
