package com.smdev.guice.msg;

import com.smdev.guice.msg.service.MessageService;
import com.smdev.guice.msg.service.send.FacebookService;

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
	}

}
