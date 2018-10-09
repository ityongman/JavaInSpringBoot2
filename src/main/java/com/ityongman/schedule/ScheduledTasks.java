package com.ityongman.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedRate = 10000 * 60)
	public void reportCurrentTime() {
		System.out.println("现在时间: " + sdf.format(new Date()));
	}
}
