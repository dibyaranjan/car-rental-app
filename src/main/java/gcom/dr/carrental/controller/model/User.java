package gcom.dr.carrental.controller.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import gcom.dr.carrental.controller.validator.UserValidator;
import gcom.dr.carrental.model.JsonRequest;

public class User implements JsonRequest {
    private String userName;
    private String password;

    private User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public static User createInstance(String userName, String password) {
        return new User(userName, password);
    }

    public boolean isValid(UserValidator userValidator) {
        return userValidator.isValid(userName, password);
    }
}
