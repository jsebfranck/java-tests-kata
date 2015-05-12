package com.jsebfranck.kata.password;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jsebfranck.kata.password.PasswordUtils;

/**
 * @see PasswordUtils
 */
public class PasswordUtilsTest {

	@Test
	public void isPasswordValid_withValidPassword() {
		assertTrue(PasswordUtils.isPasswordValid("aB+1aaaa"));
	}

	@Test
	public void isPasswordValid_withShortPassword_shouldBeInvalid() {
		assertFalse(PasswordUtils.isPasswordValid("aB+1aaa"));
	}

	@Test
	public void isPasswordValid_withoutSpecialCharacter_shouldBeInvalid() {
		assertFalse(PasswordUtils.isPasswordValid("aBa1aaaa"));
	}

	@Test
	public void isPasswordValid_withoutDigit_shouldBeInvalid() {
		assertFalse(PasswordUtils.isPasswordValid("aB+aaaaa"));
	}

	@Test
	public void isPasswordValid_withoutLowerCaseLetter_shouldBeInvalid() {
		assertFalse(PasswordUtils.isPasswordValid("aa+1aaaa"));
	}

	@Test
	public void isPasswordValid_withoutUpperCaseLetter_shouldBeInvalid() {
		assertFalse(PasswordUtils.isPasswordValid("AB+1AAAA"));
	}
}
