package com.leszek.demoapp.domain.Repositories;

import com.leszek.demoapp.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
