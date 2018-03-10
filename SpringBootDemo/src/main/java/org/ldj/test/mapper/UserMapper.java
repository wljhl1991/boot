/*
 * 工程：boot
 * 文件：org.ldj.mapper.UserMapper.java
 * 创建日期：2018年3月10日
 * 创建者：ldj
 *
 */
package org.ldj.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.ldj.test.entity.User;

/**
 * @author ldj
 *
 */
public interface UserMapper {

	@Select("SELECT * FROM user")
	@Results({
        @Result(property = "sex",  column = "sex"),
//        @Result(property = "userex",  column = "sex", javaType = userexEnum.class),
        @Result(property = "name", column = "name")
    })
    List<User> getAll();
	
	
	@Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
        @Result(property = "sex",  column = "sex"),
        @Result(property = "name", column = "name")
    })
    User getOne(Long id);
	
	
	 @Insert("INSERT INTO user(id,name,sex) VALUES(#{id},#{name}, #{sex})")
	    void insert(User user);

	    @Update("UPDATE user SET name=#{name},sex=#{sex} WHERE id =#{id}")
	    void update(User user);

	    @Delete("DELETE FROM user WHERE id =#{id}")
	    void delete(Long id);

}
