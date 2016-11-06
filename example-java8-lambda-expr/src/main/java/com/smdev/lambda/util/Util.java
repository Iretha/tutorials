package com.smdev.lambda.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.smdev.lambda.Person;

/**
 * @author Ireth
 */
public class Util {

	/**
	 * Reads file from resources dir and returns it's path
	 * 
	 * @param clz
	 * @param fileName
	 * @return path
	 * @throws URISyntaxException
	 */
	public static Path get(Class<?> clz, String fileName) throws URISyntaxException {
		return Paths.get(clz.getClassLoader().getResource(fileName).toURI());
	}

	/**
	 * Returns list of persons from file in resources dir
	 * 
	 * @param clz
	 * @param fileName
	 * @return list of persons
	 * @throws URISyntaxException
	 */
	public static List<Person> create(Class<?> clz, String fileName) throws URISyntaxException {
		Path path = get(clz, fileName);
		List<Person> p = new ArrayList<>();
		try (Stream<String> stream = Files.lines(path, Charset.defaultCharset())) {
			stream.forEach(str -> {
				String[] pdata = str.split(" ");
				p.add(new Person(pdata[0], pdata[1]));
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
		return p;
	}
}
