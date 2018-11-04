package com.chaika.files.repositories;

import com.chaika.files.models.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by echaika on 03.11.2018
 */

public interface UserRepository extends JpaRepository<User, Long> {
}
