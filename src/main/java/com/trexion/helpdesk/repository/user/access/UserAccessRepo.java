package com.trexion.helpdesk.repository.user.access;

import com.trexion.helpdesk.entity.user.access.UserAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccessRepo extends JpaRepository<UserAccess, Long> {
    Optional<UserAccess> findByUserName(String userName);
}
