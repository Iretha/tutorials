package com.smdev.guice.msg.service.mail;

import com.google.inject.BindingAnnotation;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

@BindingAnnotation
@Target({ FIELD, PARAMETER, METHOD })
@Retention(RUNTIME)
public @interface MailType {
	/*
	 * @BindingAnnotation tells Guice that this is a binding annotation. Guice
	 * will produce an error if ever multiple binding annotations apply to the
	 * same member.
	 * 
	 * @Target({FIELD, PARAMETER, METHOD}) is a courtesy to your users. It
	 * prevents @PayPal from being accidentally being applied where it serves no
	 * purpose.
	 * 
	 * @Retention(RUNTIME) makes the annotation available at runtime.
	 */
}