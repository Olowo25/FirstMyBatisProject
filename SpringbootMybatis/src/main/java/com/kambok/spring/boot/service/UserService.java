package com.kambok.spring.boot.service;



import com.kambok.spring.boot.entity.MUser;
import java.util.List;

public interface UserService {

public void signup(MUser user );

public List<MUser> getUsers();

public MUser getUserOne(String userId );

public void updateUserOne(String userId ,
String password ,
String userName );

public void deleteUserOne(String userId );
}