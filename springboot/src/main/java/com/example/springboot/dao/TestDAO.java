package com.example.springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class TestDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 查询所有用户
    public List<Map<String, Object>> getUser() {
        return jdbcTemplate.queryForList("select * from user");
    }

}
