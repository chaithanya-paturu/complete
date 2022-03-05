package com.example.restservice;

public class Greeting {

	private final long id;
	private final String content;
	private final String message;


	public Greeting(long id, String content, String message) {
		this.id = id;
		this.content = content;
		this.message = message;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}
