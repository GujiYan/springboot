package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao {

    User query(String username);
}
