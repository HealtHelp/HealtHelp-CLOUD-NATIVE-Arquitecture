package com.healthelp.users.dao;

import com.healthelp.users.model.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserDao extends PagingAndSortingRepository<User,Integer> {

    User findByUsername(String username);
}
