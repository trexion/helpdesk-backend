package com.trexion.helpdesk.repository.group;

import com.trexion.helpdesk.entity.group.AccessGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccessGroupRepo extends JpaRepository<AccessGroup, Integer> {
    List<AccessGroup> findAllByGroupId(Integer groupId);
}
