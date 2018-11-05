package com.chaika.files.repository;

import com.chaika.files.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by echaika on 03.11.2018
 */

public interface UserRepository extends JpaRepository<User, Long> {
}
