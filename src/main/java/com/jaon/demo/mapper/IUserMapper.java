package com.jaon.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jaon.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
