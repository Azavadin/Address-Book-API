package io.charan.elastic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.charan.elastic.model.User;
import io.charan.elastic.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public void addUsers(User users) {
		repository.save(users);
	}
	
	public List<User> displayAllContactByName(){
		return (List<User>) repository.findAll();
	}
	
	public User findContactByName(String text) {
		return repository.findByName(text);
	}

	public void deleteContactByName(String name) {
		 repository.deleteByName(name);
	}
	
	public void updateByName(String name) {
		repository.updateByName(name);
	}

}