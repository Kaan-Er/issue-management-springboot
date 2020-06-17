package com.champ.issuemanagement.repository;

import com.champ.issuemanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);
}
