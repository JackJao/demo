package com.jaon.demo.mapper;

import com.jaon.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 这里的Mapper接口替换了原来的DAO层，用mapper做数据访问，底层mybatis自动生成该接口的实现类的代理对象
 * @author Administrator
 */
@Mapper
@Repository
public interface IUserMapper {

	/**
	 * 查找所有用户
	 * @return allUserInfo
	 */
	List<User> findAll();

	/**
     * 根据姓名查询用户
	 * @param name
     * @return
     */
	User selectUserByName(String name);

	int insert(User user);
}
