package com.kambok.spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kambok.spring.boot.entity.MUser;
import com.kambok.spring.boot.repository.UserMapper;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper ;
	/** User signup */
	@Override
	public void signup(MUser user ) {
	user.setDepartmentId(1);
	user.setRole("ROLE_GENERAL");
	mapper.insertOne(user);
}
	
	@Override
	public List<MUser> getUsers() {
	return mapper.findMany();
	}
	
	@Override
	public MUser getUserOne(String userId ) {
	return mapper.findOne(userId );
	}
	
	
	@Override
	public void updateUserOne(String userId ,
	String password ,
	String userName ) {
	mapper .updateOne(userId , password , userName );
	}
	
	@Override
	public void deleteUserOne(String userId ) {
	int count = mapper .deleteOne(userId );
	}
}
