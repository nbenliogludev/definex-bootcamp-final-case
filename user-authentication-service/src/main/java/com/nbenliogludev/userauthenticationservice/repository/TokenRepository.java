package com.nbenliogludev.userauthenticationservice.repository;

import com.nbenliogludev.userauthenticationservice.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Integer> {
}
