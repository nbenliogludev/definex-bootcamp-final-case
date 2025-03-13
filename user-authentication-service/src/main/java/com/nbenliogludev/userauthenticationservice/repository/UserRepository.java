package com.nbenliogludev.userauthenticationservice.repository;

import com.nbenliogludev.userauthenticationservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author nbenliogludev
 */
public interface UserRepository extends JpaRepository<User, Long> {
}

