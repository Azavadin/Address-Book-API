package io.charan.elastic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.charan.elastic.model.User;
import io.charan.elastic.service.UserService;

@RestController
@RequestMapping("/contact")
public class UserController {

      @Autowired
      UserService userService;
     
      
     public  UserController(UserService userService) {
    	  this.userService = userService;
	  }
      
      @PostMapping()
      public void saveContact(User user) {
    	  try {
      	  userService.addUsers(user);
    	  }
    	  catch(Exception e) {
    		  e.printStackTrace();
    	  }
      }
     
      @GetMapping()
      public List<User> displayAllContactByName() {
		return userService.displayAllContactByName();
    	  
      }
      
      
      @GetMapping("/{name}")
      public User findContactByName(@PathVariable String name) {
    	  return userService.findContactByName(name);
    	  }
      
      @PutMapping("/{name}")
      public void updateContactByName(@PathVariable String name) {
    	  try {
    		  userService.updateByName(name);
    	  }catch(Exception e) {
    		  e.printStackTrace();
    	  }
      }
      
      
      @DeleteMapping("/{name}")
      public void deleteContactByName(@PathVariable String name) {
    	 try {
    	   userService.deleteContactByName(name);
    	 } catch(Exception e){
    		 e.printStackTrace();
    	 }
      }

}
