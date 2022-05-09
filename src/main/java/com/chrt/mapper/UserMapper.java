package com.chrt.mapper;

import com.chrt.pojo.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    // 根据用户名查找id
    @Select("select id from tb_user where binary username=#{username}")
    Integer findIdByUsername(User user);

    // 根据用户名和密码查找用户
    @Select("select * from tb_user where binary username=#{username} and binary password=#{password}")
    User findByUnAndPwd(User user);

    // 根据用户名查找用户
    @Select("select * from tb_user where binary username=#{username}")
    User findByUsername(String username);
}
