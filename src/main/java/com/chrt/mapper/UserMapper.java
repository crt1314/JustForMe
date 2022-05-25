package com.chrt.mapper;

import com.chrt.pojo.User;
import org.apache.ibatis.annotations.Select;

/**
 * user相关mapper
 * @author chrt
 * @version 1.0.0
 */
public interface UserMapper {

    /**
     * 根据用户的username查找id
     * @param user 用户信息
     * @return 用户id
     */
    @Select("select id from tb_user where binary username=#{username}")
    Integer findIdByUsername(User user);

    /**
     * 根据用户名和密码查找用户是否存在
     * @param user 用户信息
     * @return 不存在返回null，存在返回该对象
     */
    @Select("select * from tb_user where binary username=#{username} and binary password=#{password}")
    User findByUnAndPwd(User user);

    /**
     * 根据用户名查找用户是否存在
     * @param username 用户名
     * @return 不存在返回null，存在返回该对象
     */
    @Select("select * from tb_user where binary username=#{username}")
    User findByUsername(String username);
}
