package gcom.dr.carrental.dao;

import gcom.dr.carrental.model.UserDetails;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDetailsDao implements UserDao {
    private static List<UserDetails> userDetails;
    static {
        userDetails = new ArrayList<>();
        userDetails.add(new UserDetails("asdf", "asdf", "Dibya", "Ranjan", "Panda"));
    }
    @Override
    public UserDetails getUserDetailsByUserName(String userName) {
        Optional<UserDetails> userDetails = UserDetailsDao.userDetails.stream().filter(user -> {
            if (StringUtils.equals(userName, user.getUserName())) {
                return true;
            }
            return false;
        }).findFirst();

        return userDetails.orElse(null);
    }
}