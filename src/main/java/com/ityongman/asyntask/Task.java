package com.ityongman.asyntask;

import java.util.Random;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Task {
	public static Random random = new Random();
	
	@Async("taskExecutor")
	public void taskOne() throws InterruptedException {
		log.info("开始做任务一");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		
		log.info("完成任务一, 耗时: " + (end - start) + " ms");
	}
	
	@Async("taskExecutor")
	public void taskTwo() throws InterruptedException {
		log.info("开始做任务二");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		
		log.info("完成任务二, 耗时: " + (end - start) + " ms");
	}
	
	@Async("taskExecutor")	
	public void taskThree() throws InterruptedException {
		log.info("开始做任务三");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		
		log.info("完成任务三, 耗时: " + (end - start) + " ms");
	}
	
	/*@Async
	public Future<String> taskOne() throws InterruptedException {
		System.out.println("开始做任务一");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		
		System.out.println("完成任务一, 耗时: " + (end - start) + " ms");
		
		return new AsyncResult<String>("任务一完成");
	}
	
	@Async
	public Future<String> taskTwo() throws InterruptedException {
		System.out.println("开始做任务二");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		
		System.out.println("完成任务二, 耗时: " + (end - start) + " ms");
		
		return new AsyncResult<String>("任务一完成");
	}
	
	@Async	
	public Future<String> taskThree() throws InterruptedException {
		System.out.println("开始做任务三");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		
		System.out.println("完成任务三, 耗时: " + (end - start) + " ms");
		
		return new AsyncResult<String>("任务一完成");
	}*/
}
