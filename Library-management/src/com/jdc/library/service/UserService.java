package com.jdc.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jdc.library.libraryException;
import com.jdc.library.entity.User;
import com.jdc.library.repository.UserRepo;


@Service
public class UserService {
	
	@Autowired
	private UserRepo repo;

	public User findBylogin(String name,String pass) {
		
		if(StringUtils.isEmpty(name)) {
			throw new libraryException("Please Type your login_id");
		}
		if(StringUtils.isEmpty(pass)) {
			throw new libraryException("Please Type your password");
		}
		
		User user=repo.findByLoginId(name);
		
		
		if(user==null) {
			throw new libraryException("Please check your user name");
		}
		if(!user.getPassword().equals(pass)) {
			throw new libraryException("Please check your password");
		}
		
		
		 return user;
	}

}
