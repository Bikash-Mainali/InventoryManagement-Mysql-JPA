package com.inventory.user.restcontroller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.user.model.User;
import com.inventory.user.repository.UserRepository;
import com.inventory.validator.ResponseValidator;

@RestController
@RequestMapping("basePath")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	
	User user=new User();
	
	StringBuilder admin=new StringBuilder("ADMIN");
	
	@GetMapping(value="api/user/findUser",produces = "application/json")
	public List<String> findUser()
	{
		
		
		List<String> userList=userRepository.findUser();
		ResponseValidator.validateUser(userList);		
		return userList;
		
	}
	
	@PostMapping(value="api/user/addUser",produces = "application/json")
	public String addUser(@RequestBody User user)
	{
	
		
		user.setStatus(admin+"  added a user");
		userRepository.save(user);
		return "added successfully";
		
	}
	@PutMapping(value="api/user/updateUser",produces = "application/json")
	public User updateUser(@RequestParam int id,@RequestBody User user)
	{
		user.setStatus(admin+"  updated a user");
		return userRepository.save(user);	
	}
	
	@DeleteMapping(value="api/user/deleteUser",produces = "application/json")
	public String deleteUser(@PathParam(value = "id") Long id)
	{
		user.setStatus(admin+"  removed a user");
		userRepository.deleteById(id);		
		return "user is deleted";
	}

}
