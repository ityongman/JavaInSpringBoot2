package com.ityongman.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.ityongman.eo.User;

@Mapper
public interface UserMapper {
	/**
	 * 根据用户名查询用户信息 
	 */
	@Results({
		@Result(column="name", property="name"),
		@Result(column="age", property="age")
	})
	@Select("SELECT name, age FROM user WHERE name = #{name}")
	User findByName(@Param("name") String name);
	
	/**
	 * 向数据库中插入用户信息
	 */
	@Insert("INSERT INTO user (name,age) VALUES (#{name}, #{age}) ")
	int insert(User user);
}
