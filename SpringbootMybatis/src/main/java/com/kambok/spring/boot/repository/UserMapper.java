package com.kambok.spring.boot.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.kambok.spring.boot.entity.MUser;

@Mapper 
public interface UserMapper {

public int insertOne(MUser user);

public List<MUser> findMany();

public MUser findOne(String userId );

/** Update user */
public void updateOne(@Param ("userId" ) String userId ,
@Param ("password" ) String password ,
@Param ("userName" ) String userName );
/** Delete user */
public int deleteOne(@Param ("userId" ) String userId );

}