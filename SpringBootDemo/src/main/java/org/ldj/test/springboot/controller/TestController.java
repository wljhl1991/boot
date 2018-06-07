/*
 * 工程：boot
 * 文件：org.ldj.test.controller.TestController.java
 * 创建日期：2018年3月9日
 * 创建者：ldj
 *
 */
package org.ldj.test.springboot.controller;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ldj.test.entity.User;
import org.ldj.test.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ldj
 *
 */
@RestController
public class TestController {
	
	private static final Logger logger = LogManager.getLogger("TestController");
	@Autowired
	private UserMapper userMapper;
	
	@GetMapping("/helloworld")
	public String helloworld(){
		logger.info("helloworld");
		return "helloworld";
	}
	@GetMapping("/helloDog")
	public String helloDog(){
		logger.info("helloDog");
		return "helloDog";
	}
	@GetMapping("/insert")
	public String insert(){
		logger.info("insert");
		Random r = new Random();
		userMapper.insert(new User(r.nextInt(),"ada"+r.nextInt(), "a123d456"+r.nextInt()));
		
		return "insert";
	}
	@RequestMapping(params={"id"},path="")
	public String insertOne(String id){
		logger.info("insertOne");
		
		userMapper.insert(new User(new Integer(id),id+"ada", "a123d456"+id));

		return "insertOne";
	}
	
	
	
}
