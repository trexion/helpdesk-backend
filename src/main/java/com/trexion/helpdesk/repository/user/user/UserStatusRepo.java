package com.trexion.helpdesk.repository.user.user;

import com.trexion.helpdesk.entity.user.user.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserStatusRepo extends JpaRepository<UserStatus, Integer> {
    Optional<UserStatus> findByName(String userStatusName);
}
