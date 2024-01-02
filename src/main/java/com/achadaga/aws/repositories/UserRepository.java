package com.achadaga.aws.repositories;

import com.achadaga.aws.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
