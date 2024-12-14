package com.epic.tracking.repository;

import com.epic.tracking.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
