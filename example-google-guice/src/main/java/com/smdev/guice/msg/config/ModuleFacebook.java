package com.smdev.guice.msg.config;

import com.google.inject.Scopes;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.smdev.guice.msg.domain.DomainFactory;
import com.smdev.guice.msg.domain.message.Message;
import com.smdev.guice.msg.domain.user.User;
import com.smdev.guice.msg.service.ActivityService;
import com.smdev.guice.msg.service.MessageService;
import com.smdev.guice.msg.service.fb.FBType;
import com.smdev.guice.msg.service.fb.FBActivityService;
import com.smdev.guice.msg.service.fb.FBMessage;
import com.smdev.guice.msg.service.fb.FBUser;
import com.smdev.guice.msg.service.fb.FBMessageService;

/**
 * Specific configuration of the Facebook module
 * 
 * @author Ireth
 */
public class ModuleFacebook extends ModuleBase {

	@Override
	protected void configure() {
		super.configure();
		/*
		 * Factory for specific facebook object types
		 */
		install(new FactoryModuleBuilder().implement(User.class, FBUser.class).implement(Message.class, FBMessage.class)
				.build(DomainFactory.class));

		/*
		 * Linked binding -> maps a type to its implementation
		 * 
		 * In this case we will use only one implementation at a time. Linked
		 * bindings can also be chained.
		 * 
		 * Scopes.SINGLETON ensures that we have only one instance of the type
		 * for the whole application at a time
		 */
		bind(MessageService.class).to(FBMessageService.class).in(Scopes.SINGLETON);

		/*
		 * Custom annotation type -> maps an annotated type to its
		 * implementation
		 */
		bind(ActivityService.class).annotatedWith(FBType.class).to(FBActivityService.class).in(Scopes.SINGLETON);
	
	}
}
