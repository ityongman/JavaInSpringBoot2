package com.ityongman.log;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ShowLog4j2 {
	public void logApp(){
	    log.debug("log4j2 success ===== debug");
	    log.warn("log4j2 success ===== warn");
	    log.info("log4j2 success ===== info");
	    log.error(System.getProperty("user.home") + " ===== error");
	  }

	  public static void main(String[] args) {
		ShowLog4j2 application = new ShowLog4j2();
	    application.logApp();
	  }
}
