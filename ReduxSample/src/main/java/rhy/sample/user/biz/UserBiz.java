package rhy.sample.user.biz;

import rhy.sample.user.entity.User;

public interface UserBiz {

    public User createUser(User user) throws Exception;
    
    public User saveUser(User user);    
    
    public boolean isExistsUser(String loginId);
    
    public User loginUser(User user);
    
    
}
