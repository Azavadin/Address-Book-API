package io.charan.elastic.controllerTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToLongBiFunction;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import io.charan.elastic.controller.UserController;
import io.charan.elastic.model.User;
import io.charan.elastic.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
	
	
	@Mock
	UserController userController;
	
	UserService userService;
	
	private static User user1;
	
	private static User user2;
	
	
	@Before
	public void setUp() {
		userController = mock(UserController.class);
		Long id = (long) 10000000;
		Long salary = (long) 25000000;
		user1 = new User("Charan",id,"ComputerScience",salary);
		user2 = new User("Ajay",id,"InformationTechnology",salary);
		
		when(userController.displayAllContactByName()).thenReturn(Arrays.asList(user1,user2));
	}
	
	@Test
	 public void displayAllContactByName() throws Exception {
		List<User> userList= userController.displayAllContactByName();
		assertEquals(2, userList.size());
		
	}

}
	


