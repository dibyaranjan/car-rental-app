package gcom.dr.carrental.controller.validator;

import gcom.dr.carrental.controller.model.User;

public interface UserValidator {
    public boolean isValid(String userName, String password);
}
