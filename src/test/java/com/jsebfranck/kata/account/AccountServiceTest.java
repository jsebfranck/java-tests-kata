package com.jsebfranck.kata.account;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

/**
 * @see AccountService
 */
public class AccountServiceTest {

	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";
	private static final Account EXISTING_ACCOUNT = new Account(LOGIN, PASSWORD);

	@InjectMocks
	private AccountService accountService;

	@Mock
	private AccountRepository accountRepository;

	@Test
	public void getAccountByLogin_withExistingAccount_shouldReturnTheAccount() throws Exception {
		// Given
		doReturn(EXISTING_ACCOUNT).when(accountRepository).findAccount(LOGIN);

		// When
		Account result = accountService.getAccountByLogin(LOGIN);

		// Then
		assertEquals(EXISTING_ACCOUNT, result);
		verify(accountRepository).findAccount(LOGIN);
		verifyNoMoreInteractions(accountRepository);
	}

	@Test
	public void getAccountByLogin_withUnexistingAccount_shouldReturnNull() throws Exception {
		// Given
		doThrow(new RuntimeException()).when(accountRepository).findAccount(LOGIN);

		// When
		Account result = accountService.getAccountByLogin(LOGIN);

		// Then
		assertNull(result);
	}

	@Test
	public void createAccount_nominalCase_shouldCreateTheAccount() throws Exception {
		// Given
		doReturn(null).when(accountRepository).findAccount(LOGIN);

		// When
		accountService.createAccount(LOGIN, PASSWORD);

		// Then
		verify(accountRepository).createAccount(EXISTING_ACCOUNT);
		verify(accountRepository).findAccount(LOGIN);
		verifyNoMoreInteractions(accountRepository);
	}

	@Test(expected = ServiceException.class)
	public void createAccount_withAnExistingAccount_shouldThrowsServiceException() throws Exception {
		// Given
		doReturn(EXISTING_ACCOUNT).when(accountRepository).findAccount(LOGIN);

		// When
		accountService.createAccount(LOGIN, PASSWORD);

		// Then assert that a ServiceException is thrown
	}

	@Test(expected = ServiceException.class)
	public void createAccount_withNullLogin_shouldThrowsServiceException() throws Exception {
		// When
		accountService.createAccount(null, PASSWORD);

		// Then assert that a ServiceException is thrown
	}

	@Test(expected = ServiceException.class)
	public void createAccount_withNullPassword_shouldThrowsServiceException() throws Exception {
		// When
		accountService.createAccount(LOGIN, null);

		// Then assert that a ServiceException is thrown
	}
}
