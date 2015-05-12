package com.jsebfranck.kata.portfolio;

import java.util.ArrayList;
import java.util.List;

import com.jsebfranck.kata.account.Account;

public class PortfolioService {

	public List<Account> getAccountsAllowingNewsletter(List<Account> accounts) {
		List<Account> accountsAllowingNewsletter = new ArrayList<Account>();

		for (Account account : accounts) {
			if (account.allowNewsletterSubscription()) {
				accountsAllowingNewsletter.add(account);
			}
		}

		return accountsAllowingNewsletter;
	}
}
