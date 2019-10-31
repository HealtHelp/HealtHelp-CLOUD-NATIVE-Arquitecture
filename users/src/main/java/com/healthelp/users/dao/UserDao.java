package com.healthelp.users.dao;

import com.healthelp.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User,Integer> {

    //@Query(value="select u.id, u.username, u.password, u.tenant_id, u.profile_id, u.email, u.enabled from users u where u.username=:userName",nativeQuery = true)
    User findByUsername(@Param("userName")String username);


}
