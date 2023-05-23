package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	//save,findById, findAll, delete 
		//select *from users where username='varad'
		//user table username,password,active, id 
		//user entity username,password, active,id 
		
		public Optional<User> findByUserName(String username);
		//findByPassword(String password)
		// select *from user where password =password
	//Optional<User> findByUserNameandPassword(string username,string password);
		//select *from user where username=username and password=password;

		public Optional<User> findByUserNameAndPassword(String userName, String password);
}
