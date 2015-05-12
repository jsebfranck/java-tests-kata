package com.jsebfranck.kata.subscription;

import javax.inject.Inject;

import com.jsebfranck.kata.account.Account;
import com.jsebfranck.kata.account.AccountService;

public class SubscriptionService {

	@Inject
	private AccountService accountService;

	/**
	 * @return true if the user has been successfully subscribed to the newsletter.
	 */
	public boolean subscribeToNewsletter(String login, int newsletterId) {
		Account account = accountService.getAccountByLogin(login);

		if (account.allowNewsletterSubscription()) {
			return false;
		}

		return doSubscribeStuff(account, newsletterId);
	}

	boolean doSubscribeStuff(Account account, int newsletterId) {
		throw new UnsupportedOperationException("This method is very complex and is hard to be tested");
	}
}
