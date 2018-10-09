package com.ityongman.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ityongman.eo.User;
import com.ityongman.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Ch09ApplicationTest {
	
	@Autowired
	private UserMapper userMapper ;
	
	@Test
	@Rollback
	public void testMybatis() {
		User user = new User();
		user.setName("AAA");
		user.setAge(25);
		userMapper.insert(user);
		
		User selectUser = userMapper.findByName("AAA");
		Assert.assertEquals(25, selectUser.getAge().intValue());
	}
}	
