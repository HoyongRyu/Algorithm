package rhy.sample.user.biz.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rhy.sample.common.config.RHYConfig;
import rhy.sample.common.util.EntityUtil;
import rhy.sample.common.util.HTTPClientUtil;
import rhy.sample.common.util.JSONUtil;
import rhy.sample.common.util.TDevBaaSUtil;
import rhy.sample.user.biz.UserBiz;
import rhy.sample.user.entity.User;
import rhy.sample.user.repository.UserRepository;

@Service
public class UserBizImpl implements UserBiz {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserBizImpl.class);
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) throws Exception {
        String body = "{\"username\": \"" + user.getLoginId() 
                + "\",\"password\": \"" + user.getPassword() + "\"}";
        
        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("User Create Request Info : {}", body);
        }
        
        String url = RHYConfig.getUserServiceURL() + "/v1/baas/users";
        Map<String, Object> result = JSONUtil.convertJSONtoMap(HTTPClientUtil.processHttpClientPost(url, body, TDevBaaSUtil.getHeaderMap()));
        
        if (result.containsKey("objectId")){
            user.setUsrId((String)result.get("objectId"));
            user.setSessionToken((String)result.get("sessionToken"));
            user.setPassword(null);
        }else if (result.containsKey("error")
                && "0059".equals(((Map)result.get("error")).get("code"))){
            //TODO 
            
        }else {
            
        }
        return user;
    }

    @Override
    public User saveUser(User user) {
        EntityUtil.setManagementColumn(user, user.getUsrId());
        userRepository.save(user);
        return user;
    }

    @Override
    public boolean isExistsUser(String loginId) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public User loginUser(User user) {
        String url = RHYConfig.getUserServiceURL() + "/v1/baas/login";
        Map<String, Object> result = JSONUtil.convertJSONtoMap(
                HTTPClientUtil.processHttpClientGet(url,
                        HTTPClientUtil.setParameters("username", user.getLoginId(),
                                                     "password", user.getPassword()),
                        TDevBaaSUtil.getHeaderMap()));
        
        if (result.containsKey("sessionToken")){
            user.setSessionToken((String)result.get("sessionToken"));
            user.setUsrId((String)result.get("objectId"));
            user.setLoginId((String)result.get("username"));
        }else {
            //TODO 에러 처리
        }
        
        
        return user;
    }
    
    
}
