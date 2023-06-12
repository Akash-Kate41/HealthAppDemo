package com.example.demo.Controller;

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

import com.example.demo.Payloads.ApiResponse;
import com.example.demo.Payloads.UserDto;
import com.example.demo.Service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;
	

	@PostMapping
	public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto){
		UserDto saveUserDto =this.userService.saveUser(userDto);
	return new ResponseEntity<>(saveUserDto,HttpStatus.CREATED);	
	}
	
     //build get all students REST API
	@GetMapping
	public ResponseEntity<List<UserDto>>getAllUsers(){
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	// build get employee by id REST API
	// http://localhost:8080/api/students/1
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable("id") String userId){
		return  ResponseEntity.ok(this.userService.getUserById(userId));
	}
	//build update students REST API
	// http://localhost:8080/api/students/1
	@PutMapping("/{id}")
     public ResponseEntity<UserDto> updateUser(@PathVariable("id") String userId,@RequestBody UserDto userDto){
		UserDto updatedUser=this.userService.updateUser(userDto,userId);
		
		return  ResponseEntity.ok(updatedUser);
	}
	//build update students REST API
		// http://localhost:8080/api/students/1
		@DeleteMapping("/{id}")
	     public ResponseEntity<ApiResponse> deleteUser(@PathVariable("id") String userId){
			//delete student from DB
			this.userService.deleteUser(userId);
			
			return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted sucessfully",true), HttpStatus.OK);
		
		}
	
	
}
