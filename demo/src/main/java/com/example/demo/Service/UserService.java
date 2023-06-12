package com.example.demo.Service;

import java.util.List;

import com.example.demo.Payloads.UserDto;

public interface UserService {

	UserDto saveUser(UserDto user);
	
	List<UserDto> getAllUsers();
	
	UserDto getUserById(String userId);
	
     UserDto updateUser(UserDto user,String userId);
     
     void deleteUser(String userId);

}
