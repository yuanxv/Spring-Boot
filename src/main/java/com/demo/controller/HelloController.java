/**
 * 
 */
/**
 * @author Administrator
 *
 */
package com.demo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	Log log = LogFactory.getLog(HelloController.class);

	@RequestMapping("/hello1")
	public String index() {
		log.info(1);
		return "Hello World ";
	}

	@RequestMapping("/hello2")
	public String index2() {
		log.info(2);
		return "Hello World ";
	}

	@RequestMapping("/hello3")
	public String index3() {
		log.info(3);
		return "Hello World ";
	}

	@RequestMapping("/home")
	public String home() {
		log.info("index");
		return "index";
	}

}