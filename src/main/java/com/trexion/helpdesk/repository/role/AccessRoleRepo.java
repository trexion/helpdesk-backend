package com.trexion.helpdesk.repository.role;

import com.trexion.helpdesk.entity.role.AccessRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccessRoleRepo extends JpaRepository<AccessRole, Integer> {
    List<AccessRole> findAllByRoleId(Integer roleId);
}
