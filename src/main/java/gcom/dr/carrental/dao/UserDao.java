package gcom.dr.carrental.dao;

import gcom.dr.carrental.model.UserDetails;

public interface UserDao {
    UserDetails getUserDetailsByUserName(String userName);
}
