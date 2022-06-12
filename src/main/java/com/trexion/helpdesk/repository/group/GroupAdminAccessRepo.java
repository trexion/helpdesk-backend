package com.trexion.helpdesk.repository.group;

import com.trexion.helpdesk.entity.group.GroupAdminAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupAdminAccessRepo extends JpaRepository<GroupAdminAccess, Integer> {
    GroupAdminAccess findByName(String name);
}
