package rhy.sample.user.service;

import rhy.sample.user.entity.User;

public interface UserService {

    public User createUser(User user) throws Exception;
    
    public User login(User user) throws Exception;
}
