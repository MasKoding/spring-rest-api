package com.learn.tutorial.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learn.tutorial.model.UserInfo;
import com.learn.tutorial.repository.UserRepository;

@RestController
@RequestMapping("api/users")
public class UserController {
	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public ResponseEntity<Object> getAll(){
		HashMap<String, Object> users = new HashMap<String, Object>();
		users.put("data", userRepo.findAll());
		users.put("status", HttpStatus.OK);
		
		return ResponseEntity.ok(users);
	}
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public ResponseEntity<Object> save(@Valid @RequestBody UserInfo user){
		HashMap<String, Object> users = new HashMap<String, Object>();
		userRepo.save(user);
		users.put("status", HttpStatus.OK);
		
		return ResponseEntity.ok(users);
	}
	
	@RequestMapping(value = "/edit",method = RequestMethod.PUT)
	public ResponseEntity<Object> edit(@Valid @RequestBody UserInfo newUser){
		HashMap<String, Object> users = new HashMap<String, Object>();
		newUser.getId();
		userRepo.save(newUser);
		users.put("status", HttpStatus.OK);
		
		return ResponseEntity.ok(users);
		
	}
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable long id){
		HashMap<String, Object> users = new HashMap<String, Object>();
		userRepo.deleteById(id);
		users.put("status", HttpStatus.OK);
		return ResponseEntity.ok(users);
	}
	@RequestMapping(value = "/findById/{id}",method = RequestMethod.GET)
	public ResponseEntity<Object> findById(@PathVariable long id){
		HashMap<String, Object> users = new HashMap<String, Object>();
		users.put("data", userRepo.findById(id));
		users.put("status", HttpStatus.OK);
		
		return ResponseEntity.ok(users);
	}
}
