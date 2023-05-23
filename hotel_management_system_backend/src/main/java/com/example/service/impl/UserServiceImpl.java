package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.exception.ResourceNotFoundException;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	/*
	 * public UserServiceImpl(UserRepository userRepository) { super();
	 * this.userRepository=userRepository; }
	 */
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}
	@Override
	public User loginUser(User user) {
		
		return this.userRepository.findByUserNameAndPassword(user.getUserName(),user.getPassword()).orElseThrow(()->new ResourceNotFoundException("User ", "userName",user.getUserName()+" and password "+user.getPassword() ));
	}
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		System.out.println("getallusers service");
		return userRepository.findAll();
	}

	@Override
	public User getUserById(long userId) {
		// TODO Auto-generated method stub
		/*
		 * Optional<Reservation> Reservation=ReservationRepository.findById(id);
		 * if(Reservation.isPresent()) { return Reservation.get(); }else throw new
		 * ResourceNotFoundException("Reservation","id",id);
		 */
		return userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
	}

	@Override
	public User updateUser(User user, long userId) {
		// TODO Auto-generated method stub
		User existingUser = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		existingUser.setUserid(user.getUserid());
		existingUser.setUserName(user.getUserName());
		existingUser.setName(user.getName());
		existingUser.setContactNumber(user.getContactNumber());
		existingUser.setAadharNumber(user.getAadharNumber());
		existingUser.setPassword(user.getPassword());
		existingUser.setActive(user.isActive());
		existingUser.setRoles(user.getRoles());
		userRepository.save(existingUser);
		return existingUser;
	}

	@Override
	public void deleteUser(long userId) {
		// TODO Auto-generated method stub
		userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		userRepository.deleteById(userId);
	}
	@Override
	public User getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return userRepository.findByUserName(userName)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userName", userName));
	}

}
