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
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloController {
	Log log = LogFactory.getLog(HelloController.class);

	@RequestMapping("/hello")
	public String hello() {
		log.info("hello");
		return "Hello World ";
	}

	@RequestMapping("/upLoadPost")
	public ModelAndView upLoad() {
		ModelAndView mv = new ModelAndView("upLoad.html");
		return mv;
	}

}