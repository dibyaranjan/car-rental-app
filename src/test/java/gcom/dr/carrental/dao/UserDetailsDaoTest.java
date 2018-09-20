package gcom.dr.carrental.dao;

import gcom.dr.carrental.model.UserDetails;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class UserDetailsDaoTest {
    private UserDetailsDao dao;

    @Before
    public void setUp() {
        dao = new UserDetailsDao();
    }

    @After
    public void tearDown() {
        dao = null;
    }

    @Test
    public void testGetUserDetailsByName_withNonExistingUser() {
        UserDetails userDetails = dao.getUserDetailsByUserName("asdfa");

        assertNull("Should be null", userDetails);
    }

    @Test
    public void testGetUserDetailsByName_withExistingUser() {
        UserDetails userDetails = dao.getUserDetailsByUserName("asdf");

        assertNotNull("Should not be null", userDetails);
        assertEquals("Username should be same", userDetails.getUserName(), "asdf");
    }
}