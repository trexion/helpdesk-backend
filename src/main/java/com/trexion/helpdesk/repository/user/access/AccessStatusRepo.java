package com.trexion.helpdesk.repository.user.access;

import com.trexion.helpdesk.entity.user.access.AccessStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessStatusRepo extends JpaRepository<AccessStatus, Integer> {
}
