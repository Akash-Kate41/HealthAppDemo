package com.example.demo.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Payloads.UserDto;
import com.example.demo.Repository.UserRepo;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepository;
   @Autowired
	private ModelMapper modelMapper;


	@Override
	public UserDto saveUser(UserDto userDto) {
		User user =this.dtoToUser(userDto);
		user.setPassword(userDto.getPassword());
		User savedUser = this.userRepository.save(user);
		return this.userToDto(savedUser);
	//	return null;
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users =this.userRepository.findAll();
		
		List<UserDto> userDtos=users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
		//return null;
	}

	@Override
	public UserDto getUserById(String userId) {
		User user=this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		return this.userToDto(user);
	}

	@Override
	public UserDto updateUser(UserDto userDto, String userId) {
		User user=this.userRepository.findById(userId).orElseThrow();
		
		user.setPassword(userDto.getPassword());
		user.setName(userDto.getName());
		user.setAddress(userDto.getAddress());
		user.setEmailId(userDto.getEmailId());
		user.setDOB(userDto.getDOB());
		user.setBloodGroup(userDto.getBloodGroup());
		user.setGender(userDto.getGender());
		//user.setDesignation(userDto.getDesignation());
		user.setContactNo(userDto.getContactNo());
		
		User upadateUser =this.userRepository.save(user);
		UserDto userDto1 =this.userToDto(upadateUser);
		
		return userDto1;	
		}

	@Override
	public void deleteUser(String userId) {
		User user=this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));	
		this.userRepository.delete(user);

	}
	public User dtoToUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		return user;
	}
	public UserDto userToDto(User user) {
		UserDto userDto =this.modelMapper.map(user, UserDto.class);
		return userDto;
	}

}
