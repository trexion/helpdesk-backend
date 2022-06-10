package com.trexion.helpdesk.repository.role;

import com.trexion.helpdesk.entity.role.RoleAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleAdminRepo extends JpaRepository<RoleAdmin, Integer> {
    List<RoleAdmin> findAllByRoleId(Integer roleId);
}
