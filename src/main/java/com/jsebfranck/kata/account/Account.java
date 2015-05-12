package com.jsebfranck.kata.account;

public class Account {
	private final String login;
	private final String password;
	private final boolean allowNewsletterSubscription;

	public Account(String login, String password) {
		this(login, password, false);
	}

	public Account(String login, String password, boolean allowNewsletterSubscription) {
		this.login = login;
		this.password = password;
		this.allowNewsletterSubscription = allowNewsletterSubscription;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public boolean allowNewsletterSubscription() {
		return allowNewsletterSubscription;
	}
}
