package com.healthelp.users.dao;

import com.healthelp.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
}
