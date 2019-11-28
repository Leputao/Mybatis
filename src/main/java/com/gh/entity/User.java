package com.gh.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author zhanghai
 * @create 2019/11/26 17:28
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private List<Score> scores;
}
