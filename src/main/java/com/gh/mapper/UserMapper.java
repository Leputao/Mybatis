package com.gh.mapper;

import com.gh.entity.User;

import java.util.List;

/**
 * @Author zhanghai
 * @create 2019/11/27 10:01
 */
public interface UserMapper {

    User findById(Integer id);

    void add(User user);

    void deleteById(Integer id);

    void update(User user);

    List<User> findByLikeName(String username);
}
