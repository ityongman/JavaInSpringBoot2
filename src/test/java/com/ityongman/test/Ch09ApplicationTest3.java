package com.ityongman.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ityongman.asyntask.Task;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Ch09ApplicationTest3 {
	
	@Autowired
	private Task task ;
	
	@Test
	public void testTask() throws InterruptedException {
		task.taskOne();
		task.taskTwo();
		task.taskThree();
		
		Thread.currentThread().join();
	}
	
	@Test
	public void testAsyncTask() throws InterruptedException {
		/*long start = System.currentTimeMillis() ;
		
		Future<String> taskOne = task.taskOne();
		Future<String> taskTwo = task.taskTwo();
		Future<String> taskThree = task.taskThree();
		
		while(true) {
			if(taskOne.isDone() && taskTwo.isDone() && taskThree.isDone()) {
				// 三个任务已经执行完, 退出循环
				break ;
			}
			
			Thread.sleep(1000);
		}
		
		long end = System.currentTimeMillis();
		System.out.println("任务全部完成, 总耗时: " + (end - start) + " ms");
		*/
	}
}	
