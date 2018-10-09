package com.ityongman.test;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ityongman.eo.User;
import com.ityongman.eo.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Ch09ApplicationTest2 {
	@Autowired
	private UserRepository userRepository ;
	
	
	/**
	 * 	ISOLATION :
	 * 
	 * 	DEFAULT(-1),
	    READ_UNCOMMITTED(1),
	    READ_COMMITTED(2),
	    REPEATABLE_READ(4),
	    SERIALIZABLE(8);
	    
	    Propagation :
	    
	    REQUIRED(0),
	    SUPPORTS(1),
	    MANDATORY(2),
	    REQUIRES_NEW(3),
	    NOT_SUPPORTED(4),
	    NEVER(5),
	    NESTED(6);
	 */
	@Test
	@Transactional  // if not Transaction , database will insert some data
	public void testTransaction() {
		// 创建10条记录
		userRepository.save(new User("AAA", 10));
		userRepository.save(new User("BBB", 20));
		userRepository.save(new User("CCC", 30));
		userRepository.save(new User("DDD", 40));
		userRepository.save(new User("EEE", 50));
		userRepository.save(new User("FFF", 60));
		userRepository.save(new User("GGG", 70));
		userRepository.save(new User("HHHHHHHHH", 80));
		userRepository.save(new User("III", 90));
		userRepository.save(new User("JJJ", 100));
	}
}
