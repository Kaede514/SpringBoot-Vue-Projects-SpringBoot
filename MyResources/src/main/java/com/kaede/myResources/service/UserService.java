package com.kaede.myResources.service;

import com.kaede.myResources.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author kaede
 * @create 2022-08-14 17:46
 */

public interface UserService {

    //根据用户名查询用户
    User getUserByName(String userName);

    //根据id查询用户信息
    User selectById(@Param("id") Integer id);

    //修改用户信息
    void update(User user);

}
