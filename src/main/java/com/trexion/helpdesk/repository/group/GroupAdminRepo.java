package com.trexion.helpdesk.repository.group;

import com.trexion.helpdesk.entity.group.GroupAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupAdminRepo extends JpaRepository<GroupAdmin, Integer> {
    List<GroupAdmin> findAllByGroupId(Integer groupId);
}
