package com.trexion.helpdesk.repository.user;

import com.trexion.helpdesk.entity.user.UserAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserAccessRepo extends JpaRepository<UserAccess, UUID> {
}
