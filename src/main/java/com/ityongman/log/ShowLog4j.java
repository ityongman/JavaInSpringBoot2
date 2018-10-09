package com.ityongman.log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class ShowLog4j {
	
	@Scheduled(fixedRate = 10000 * 60)
	public void printLog() {
		Date now = new Date() ;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		log.info(df.format(now));
		log.debug("-----DEBUG------");
		log.warn(System.currentTimeMillis());
		log.error(now.getTime());
				
	}
}
