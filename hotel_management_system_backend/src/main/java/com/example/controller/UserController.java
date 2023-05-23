package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UserController {
	@Autowired
	private UserService userService;

	
	public UserController(UserService userService) { 
		
		super();
		System.out.println("usercontroller");
		this.userService =userService; 
		
		}
	

	// http://localhost:8089/api/users
	@PostMapping("/api/register")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		System.out.println(user);
		return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
	}
	@PostMapping("/api/login")
	public  ResponseEntity<User> loginCustomer( @RequestBody User user)
	{
		return new ResponseEntity<User>(userService.loginUser(user),HttpStatus.OK);
		
	}

	// http://localhost:8089/api/users
	@GetMapping("/api/users")
	public List<User> getAllUsers() {
		System.out.println("get all users controller");
		List<User> UserList=userService.getAllUser();
		System.out.println(UserList);
		return UserList;
	}

	// http://localhost:8089/api/users/2
	@GetMapping("/api/users/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") int userId) {
		return new ResponseEntity<User>(userService.getUserById(userId), HttpStatus.OK);
	}
	
	@GetMapping("/api/users/byName/{userName}")
	public ResponseEntity<User> getUserByName(@PathVariable("userName") String userName) {
		System.out.println(userName);
		return new ResponseEntity<User>(userService.getUserByUserName(userName), HttpStatus.OK);
	}
	
	// http://localhost:8089/api/users/2
	@PutMapping("/api/users/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable("userId") int userId, @RequestBody User user) {
		return new ResponseEntity<User>(userService.updateUser(user, userId), HttpStatus.OK);
	}

	// http://localhost:8089/api/users/6
	@DeleteMapping("/api/users/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable("userId") int userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);
	}
}
