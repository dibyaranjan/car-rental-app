package gcom.dr.carrental.controller;

import gcom.dr.carrental.app.Main;
import gcom.dr.carrental.controller.model.JsonResult;
import gcom.dr.carrental.controller.model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Main.class})
public class LoginControllerIT {
    @Autowired
    private LoginController loginController;

    @Test
    public void testLogin_withEmptyUserValues() {
        User user = User.createInstance(null, null);
        JsonResult<Boolean> login = loginController.login(user);

        Assert.assertFalse("Login should fail", login.getData());
    }

    @Test
    public void testLogin_withInvalidUsername() {
        User user = User.createInstance("asdfa", "jkl");
        JsonResult<Boolean> login = loginController.login(user);

        Assert.assertFalse("Login should fail", login.getData());
    }

    @Test
    public void testLogin_withInvalidPassword() {
        User user = User.createInstance("asdf", "jkl");
        JsonResult<Boolean> login = loginController.login(user);

        Assert.assertFalse("Login should fail", login.getData());
    }

    @Test
    public void testLogin_withValidCredential() {
        User user = User.createInstance("asdf", "asdf");
        JsonResult<Boolean> login = loginController.login(user);

        Assert.assertTrue("Login should be successful", login.getData());
    }
}
