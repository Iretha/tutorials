package com.smdev.example.guice.domain;

public class Referent {

	private String address;
	private String name;

	public Referent(String address, String name) {
		super();
		this.address = address;
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public String getName() {
		return name;
	}

}