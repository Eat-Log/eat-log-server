package com.kuba.eatlog.repository;

import com.kuba.eatlog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
