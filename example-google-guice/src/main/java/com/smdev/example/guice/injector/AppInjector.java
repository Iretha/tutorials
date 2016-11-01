package com.smdev.example.guice.injector;

import com.google.inject.AbstractModule;
import com.smdev.example.guice.services.MessageService;
import com.smdev.example.guice.services.impl.EmailService;

public class AppInjector extends AbstractModule {

	@Override
	protected void configure() {
		bind(MessageService.class).to(EmailService.class);
	}

}
