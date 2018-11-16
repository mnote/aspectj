package io.github.mnote.aspectj;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class AccountTest {

    private Account account;

    @Before
    public void before() {
        account = new Account();
    }

    @Test
    public void success() {
        assertTrue(account.withdraw(5));
    }

    @Test
    public void fail() {
        assertFalse(account.withdraw(100));
    }

}
