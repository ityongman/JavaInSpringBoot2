package com.ityongman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

//@RestController
@Controller
@Slf4j
public class HelloController {
	@Value("${age}")
	private String age ;
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	@ResponseBody
	public String test() {
		log.debug("Logger Level ：DEBUG");
		log.info("Logger Level ：INFO");
		log.error("Logger Level ：ERROR");
		
		return age;
	}
	
	@RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value="/hello", method=RequestMethod.GET)
    public String hello() {
        return "hello";
    }
    
    @RequestMapping("/login")
    public String login() {
    	System.out.println("age == > " + age);
        return "login";
    }
}
