package com.leszek.demoapp.domain.Repositories;

import com.leszek.demoapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
