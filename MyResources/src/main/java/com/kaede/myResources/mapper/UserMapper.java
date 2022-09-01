package com.kaede.myResources.mapper;

import com.kaede.myResources.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 @author kaede
 @create 2022-08-14 17:45
 */

@Mapper
public interface UserMapper {

    //根据用户名查询用户
    User getUserByName(@Param("userName") String userName);

    //根据id查询用户信息
    User selectById(@Param("id") Integer id);

    //修改用户信息
    void update(User user);

}
