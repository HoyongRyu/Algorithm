package rhy.sample.user.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rhy.sample.common.util.StringUtil;
import rhy.sample.user.biz.UserBiz;
import rhy.sample.user.entity.User;
import rhy.sample.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    
	@Autowired
	private UserBiz userBiz;
	
	public User createUser(User user) throws Exception{
		/*-FD-DO-START-0001---------------------------------
		 * User 서비스의 등록 API를 호출한다.
		 *--------------------------------------------------*/
	    user = userBiz.createUser(user);
		/*-FD-DO-END-0001-----------------------------------*/
		/*-FD-IF-0002---------------------------------------
		 * 등록 결과에 usrId가 들어있으면 DB에 저장
		 *--------------------------------------------------*/
		if(StringUtil.isNotEmpty(user.getUsrId())) {
		    user.setAuthFg(true);
		    userBiz.saveUser(user);
		}
		/*-FD-ELSE-0003-------------------------------------
		 * 들어있지 않으면 에러코드에 따라 응답코드 리턴
		 *--------------------------------------------------*/
		else {
		    //TODO 로직 구현
		}
		return user;
	}
	
	public User login(User user) throws Exception{
	    return userBiz.loginUser(user);
	}
}
