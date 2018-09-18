package gcom.dr.carrental.controller.validator;

import gcom.dr.carrental.dao.UserDao;
import gcom.dr.carrental.dao.UserDetailsDao;
import gcom.dr.carrental.model.UserDetails;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;

public class OfflineUserValidatorTest {
    private UserValidatorImpl validator;
    private UserDao userDao;

    @Before
    public void setUp() {
        userDao = Mockito.mock(UserDetailsDao.class);

        validator = new UserValidatorImpl();
        validator.setUserDao(userDao);
    }

    @After
    public void tearDown() {
        validator = null;
        userDao = null;
    }

    @Test
    public void testIsValid_withEmptyUser() {
        boolean valid = validator.isValid(null, null);

        Assert.assertFalse("Should not be valid", valid);
    }

    @Test
    public void testIsValid_withoutSettingUpCsv() {
        Mockito.when(userDao.getUserDetailsByUserName("asdf")).thenReturn(null);

        boolean valid = validator.isValid("asdf", "asdf");
        Assert.assertFalse("Should not be valid", valid);
    }

    @Test
    public void testIsValid_withIncorrectPassword() {
        Mockito.when(userDao.getUserDetailsByUserName("asdf")).thenReturn(new UserDetails("asdf", "jkl", "","",
                ""));

        boolean valid = validator.isValid("asdf", "asdf");
        Assert.assertFalse("Should not be valid", valid);
    }


    @Test
    public void testIsValid_withCorrectDetails() {
        Mockito.when(userDao.getUserDetailsByUserName("asdf")).thenReturn(new UserDetails("asdf", "asdf", "","",
                ""));

        boolean valid = validator.isValid("asdf", "asdf");
        Assert.assertTrue("Should not be valid", valid);
    }

}