package com.trexion.helpdesk.repository.user.role;

import com.trexion.helpdesk.entity.role.RoleAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleAdminRepo extends JpaRepository<RoleAdmin, Integer> {
}
