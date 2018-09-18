package com.demo;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.filter.AuthFilter;
import com.demo.filter.CustomFilter;

@SpringBootApplication
@EnableAutoConfiguration
@ServletComponentScan
public class application implements EmbeddedServletContainerCustomizer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(application.class, args);
	}

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		// 指定项目名称
		container.setContextPath("/test");
		// 指定端口地址
		container.setPort(8090);
	}

//	@Bean
//	public FilterRegistrationBean filterRegistrationBean1() {
//		FilterRegistrationBean registration = new FilterRegistrationBean();
//		// 当过滤器有注入其他bean类时，可直接通过@bean的方式进行实体类过滤器，这样不可自动注入过滤器使用的其他bean类。
//		// 当然，若无其他bean需要获取时，可直接new CustomFilter()，也可使用getBean的方式。
//		registration.setFilter(authFilter());
//		// 过滤器名称
//		registration.setName("authFilter");
//		// 拦截路径
//		registration.addUrlPatterns("/*");
//		// 设置顺序
//		registration.setOrder(6);
//		return registration;
//	}
//
//	@Bean
//	public Filter authFilter() {
//		return new AuthFilter();
//	}
}
