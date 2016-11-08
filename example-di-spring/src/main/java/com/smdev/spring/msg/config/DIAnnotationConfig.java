package com.smdev.spring.msg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.smdev.spring.msg.service.BackupService;
import com.smdev.spring.msg.service.MessageService;
import com.smdev.spring.msg.service.backup.FileSystemBackupService;
import com.smdev.spring.msg.service.fb.FBMessageService;

/**
 * @author Ireth
 */
@Configuration
@ComponentScan(value = { "com.smdev.spring.msg" })
@PropertySource("classpath:annotConfig.properties")
public class DIAnnotationConfig {

	@Bean
	public MessageService getMessageService() {
		return new FBMessageService();
	}

	@Bean
	public BackupService getBackupService() {
		return new FileSystemBackupService();
	}

	/**
	 * Property placeholder configurer needed to process @Value annotations
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
