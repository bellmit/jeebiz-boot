/** 
 * Copyright (C) 2018 Jeebiz (http://jeebiz.net).
 * All Rights Reserved. 
 */
package net.jeebiz.boot.autoconfigure;

import org.springframework.biz.context.SpringContextAwareContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"net.jeebiz.**.setup", "net.jeebiz.**.service", "net.jeebiz.**.aspect", "net.jeebiz.**.task"})
public class DefaultSpringContextConfiguration {
	
	@Bean
	public SpringContextAwareContext springContextAwareContext() {
		return new SpringContextAwareContext();
	}
	
}


