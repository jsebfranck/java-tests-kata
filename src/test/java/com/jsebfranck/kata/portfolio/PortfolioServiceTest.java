package com.jsebfranck.kata.portfolio;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.jsebfranck.kata.account.Account;

/**
 * @see PortfolioService
 */
public class PortfolioServiceTest {

	private PortfolioService portfolioService;

	@Before
	public void setUp() {
	}

	@Test
	public void getAccountsAllowingNewsletter_allowingNewsletter_shouldBeReturned() {
		// Given
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(new Account("login", "password", true));

		// When
		List<Account> result = portfolioService.getAccountsAllowingNewsletter(accounts);

		// Then
		assertEquals(1, result.size());
		assertEquals("login", result.get(0).getLogin());
	}

	@Test
	public void getAccountsAllowingNewsletter_refusingNewsletter_shouldBeFiltered() {
		// Given
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(new Account("login", "password", false));

		// When
		List<Account> result = portfolioService.getAccountsAllowingNewsletter(accounts);

		// Then
		assertNull(result);
		assertTrue(result.isEmpty());
	}

	@Test
	public void getAccountsAllowingNewsletter_withSeveralAccounts() {
		// Given
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(new Account("login1", "password", true));
		accounts.add(new Account("login2", "password", false));
		accounts.add(new Account("login3", "password", true));


		// When
		List<Account> result = portfolioService.getAccountsAllowingNewsletter(accounts);

		// Then
		assertEquals(2, result.size());
		assertEquals("login1", result.get(0).getLogin());
		assertEquals("login3", result.get(1).getLogin());
	}
}
