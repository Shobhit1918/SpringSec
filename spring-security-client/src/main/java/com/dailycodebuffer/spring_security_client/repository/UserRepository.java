package com.dailycodebuffer.spring_security_client.repository;

import com.dailycodebuffer.spring_security_client.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
