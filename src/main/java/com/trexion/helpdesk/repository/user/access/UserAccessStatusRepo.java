package com.trexion.helpdesk.repository.user.access;

import com.trexion.helpdesk.entity.user.access.UserAccessStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccessStatusRepo extends JpaRepository<UserAccessStatus, Integer> {
    Optional<UserAccessStatus> findByName(String accessStatusName);
}
