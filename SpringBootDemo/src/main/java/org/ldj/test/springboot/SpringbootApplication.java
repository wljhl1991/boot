/*
 * 工程：boot
 * 文件：org.ldj.test.SpringbootApplication.java
 * 创建日期：2018年3月9日
 * 创建者：ldj
 *
 */
package org.ldj.test.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ldj
 *
 */
@SpringBootApplication
@MapperScan("org.ldj.test.mapper")
//@ComponentScan(basePackages={"org.ldj.test.entity"})
public class SpringbootApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 SpringApplication.run(SpringbootApplication.class, args);
	}

}
