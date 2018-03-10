/*
 * 工程：boot
 * 文件：org.ldj.test.UserMapperTest.java
 * 创建日期：2018年3月10日
 * 创建者：ldj
 *
 */
package org.ldj.test.springboot;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ldj.test.entity.User;
import org.ldj.test.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ldj
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
	
	@Autowired
	private UserMapper userMapper;
	
	
	@Test
    public void testInsert() throws Exception {
		userMapper.insert(new User(3,"ada", "a123d456"));

        Assert.assertEquals(2, userMapper.getAll().size());
    }
	@Test
    public void testQuery() throws Exception {
		
        List<User> users = userMapper.getAll();
        System.out.println("查询到结果 ："+users.toString());
    }

}
