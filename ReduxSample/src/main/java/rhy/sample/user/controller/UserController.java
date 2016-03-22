package rhy.sample.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rhy.sample.user.entity.User;
import rhy.sample.user.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;
    
	@RequestMapping(value="/createUser", method = RequestMethod.POST)
	public User createUser(@RequestBody User user) throws Exception {
	    return userService.createUser(user);
	}

	@RequestMapping(value="/session", method = RequestMethod.POST)
    public User login(@RequestBody User user) throws Exception {
        return userService.login(user);
    }
	
	@RequestMapping(value="/session", method = RequestMethod.GET)
    public User getSession(@RequestBody User user) throws Exception {
        return userService.createUser(user);
    }
	
	@RequestMapping(value="/session", method = RequestMethod.DELETE)
    public User logout(@RequestBody User user) throws Exception {
        return userService.createUser(user);
    }
}
