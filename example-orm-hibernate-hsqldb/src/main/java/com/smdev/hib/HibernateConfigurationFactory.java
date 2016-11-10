package com.smdev.hib;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * @author Ireth
 */
public class HibernateConfigurationFactory {

	/**
	 * Load properties file by file path
	 *
	 * @param path
	 * @return Properties
	 * @throws AppException
	 */
	private static Properties loadProperties(String path) throws AppException {
		Properties props = null;
		try (InputStream inputStream = HibernateConfigurationFactory.class
				.getResourceAsStream(path);) {
			props = new Properties();
			props.load(inputStream);
		} catch (IOException e) {
			throw new AppException(e);
		}
		return props;
	}

	/** Path to hibernate configuration file */
	private String hibClassesPath;

	/** Path to hibernate annotated classes file */
	private String hibConfPath;

	/**
	 * @param hibConfPath
	 * @param hibClassesPath
	 */
	public HibernateConfigurationFactory(String hibConfPath, String hibClassesPath) {
		super();
		this.hibConfPath = hibConfPath;
		this.hibClassesPath = hibClassesPath;
	}

	/**
	 * Configures hibernate and initializes hibernate session factory
	 *
	 * @throws AppException
	 */
	public void initialize() throws AppException {
		try {
			Properties hibernateClasses = loadProperties(this.hibClassesPath);

			// configure hibernate
			Configuration configuration = new Configuration()
					.configure(this.getClass().getResource(this.hibConfPath));

			// add annotated classes
			Enumeration<?> classNames = hibernateClasses.propertyNames();
			Class<?> entityClz = null;
			while (classNames.hasMoreElements()) {
				entityClz = Class.forName(
						hibernateClasses.getProperty(String.valueOf(classNames.nextElement())));
				configuration.addAnnotatedClass(entityClz);
			}

			// create factory
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
			builder.applySettings(configuration.getProperties());

			HibernateSessionFactory.getInstance()
					.initializeFactory(configuration.buildSessionFactory(builder.build()));
		} catch (ClassNotFoundException e) {
			throw new AppException(e);
		}
	}
}
