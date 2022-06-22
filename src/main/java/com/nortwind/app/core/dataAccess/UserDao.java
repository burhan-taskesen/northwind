package com.nortwind.app.core.dataAccess;

import com.nortwind.app.core.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
    User findByEmail(String email);
}
