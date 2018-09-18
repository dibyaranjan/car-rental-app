package gcom.dr.carrental.dao;

import gcom.dr.carrental.model.UserDetails;

import java.util.ArrayList;
import java.util.List;

public class UserDetailsDao implements UserDao {
    private static List<UserDetails> userDetails;
    static {
        userDetails = new ArrayList<>();
        userDetails.add(new UserDetails("asdf", "asdf", "Dibya", "Ranjan", "Panda"));
    }
    @Override
    public UserDetails getUserDetailsByUserName(String userName) {
        for(UserDetails userDetail : userDetails) {
            if (userName.equals(userDetail.getUserName())) {
                return userDetail;
            }
        }

        return null;
    }
}