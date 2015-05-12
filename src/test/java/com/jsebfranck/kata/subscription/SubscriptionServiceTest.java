package com.jsebfranck.kata.subscription;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.jsebfranck.kata.account.Account;
import com.jsebfranck.kata.account.AccountService;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * @see SubscriptionService
 */
@RunWith(MockitoJUnitRunner.class)
public class SubscriptionServiceTest {

	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";
	private static final int NEWSLETTER_ID = 100;

	@InjectMocks
	@Spy
	private SubscriptionService subscriptionService;

	@Mock
	private AccountService accountService;

	@Test
	public void suscribeToNewsletter_withValidSubscription() {
		Account account = new Account(LOGIN, PASSWORD, true);
		doReturn(account).when(accountService).getAccountByLogin(LOGIN);
		doReturn(true).when(subscriptionService).doSubscribeStuff(account, NEWSLETTER_ID);

		boolean isSubscribed = subscriptionService.subscribeToNewsletter(LOGIN, NEWSLETTER_ID);

		assertTrue(isSubscribed);
	}

	@Test
	public void suscribeToNewsletter_withInvalidAccount_shouldNotBeSubscribed() {
		Account account = new Account(LOGIN, PASSWORD, false);
		doReturn(account).when(accountService).getAccountByLogin(LOGIN);
		doReturn(true).when(subscriptionService).doSubscribeStuff(account, NEWSLETTER_ID);

		boolean isSubscribed = subscriptionService.subscribeToNewsletter(LOGIN, NEWSLETTER_ID);

		assertFalse(isSubscribed);
	}

	@Test
	public void suscribeToNewsletter_withFailingSubscription_shouldNotBeSubscribed() {
		Account account = new Account(LOGIN, PASSWORD, true);
		doReturn(account).when(accountService).getAccountByLogin(LOGIN);
		doReturn(false).when(subscriptionService).doSubscribeStuff(account, NEWSLETTER_ID);

		boolean isSubscribed = subscriptionService.subscribeToNewsletter(LOGIN, NEWSLETTER_ID);

		assertFalse(isSubscribed);
	}
}
