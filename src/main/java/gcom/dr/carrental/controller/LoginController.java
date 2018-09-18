package gcom.dr.carrental.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import gcom.dr.carrental.controller.model.JsonResult;
import gcom.dr.carrental.controller.model.User;
import gcom.dr.carrental.controller.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "login.action", method = RequestMethod.POST)
    public JsonResult<Boolean> login(@RequestBody User user) {
        if (user.isValid(userValidator)) {
            return new JsonResult<>(Boolean.TRUE, "Login successful");
        }
        return new JsonResult<>(Boolean.FALSE, "Failed login");
    }

    @RequestMapping(value = "test", method = RequestMethod.POST)
    public String test(@RequestBody POJO pojo) {
        if (pojo == null) {
            return "pojo is null";
        }

        if (pojo.name == null) {
            return "name is null";
        }

        return "sic";
    }
}
