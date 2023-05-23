package com.example.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.model.MyUserDetails;
import com.example.model.User;
import com.example.repository.UserRepository;

@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//return new MyUserDetails(s);
		User user=userRepository.findByUserName(username).get();//connecting to database by using userrepository	
		if(user==null)
		{
			throw new UsernameNotFoundException("User Not Found");
			
		}
		return new MyUserDetails(user);
	}

}
