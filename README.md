##1.MyBatis Mapper 接口开发
### #说明：mapper代理的方法（开发者只需要编写mapper接口（相当于DAO接口））
#### # 思路（mapper代理开发规范）
####开发者需要编写mapper.xml映射文件
####开发者需要mapper接口 需要遵循一些开发的规范,mybatis可以自动生成mapper实现类的代理对象
####开发规范：
#####1、在mapper.xml中，namespace 等于 mapper.java 接口的全限定名
#####2、在mapper.java接口中的方法名和mapper.xml中statement的id一致
######3、mapper接口中，方法的输入参数类型和mapper.xml中的statement的parameterType一致
######4、mapper接口中，方法的返回值类型和mapper.xml中statement的resultType一致
######例如：
```
<mapper namespace="com.jaon.demo.mapper.IUserMapper">
    <select id="findAll" resultType="User">
        select id,name,code from user
    </select>
</mapper>
```
```
@Mapper
@Repository
public interface IUserMapper {
    List<User> findAll();
}
```
	
#####ps:github上添加的内容
