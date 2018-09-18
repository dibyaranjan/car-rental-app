package gcom.dr.carrental.controller.validator;

import gcom.dr.carrental.dao.UserDao;
import gcom.dr.carrental.model.UserDetails;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class UserValidatorImpl implements UserValidator {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean isValid(String userName, String password) {
        if (StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
            return false;
        }

        UserDetails userDetails = userDao.getUserDetailsByUserName(userName);

        if (userDetails == null) {
            return false;
        }

        if (userName.equals(userDetails.getUserName()) && password.equals(userDetails.getPassword())) {
            return true;
        }

        return false;
    }
}
