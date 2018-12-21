package pl.sidor.dao;

import java.util.List;

import pl.sidor.model.User;

public interface UserDao {

	User findByName(String name);
	
	List<User> findAll();

}