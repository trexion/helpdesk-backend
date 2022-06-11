package com.trexion.helpdesk.repository.role;

import com.trexion.helpdesk.entity.role.RoleAdminAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleAdminAccessRepo extends JpaRepository<RoleAdminAccess, Integer> {
    Optional<RoleAdminAccess> findByName(String name);
}
