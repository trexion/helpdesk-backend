package com.trexion.helpdesk.repository.user.user;

import com.trexion.helpdesk.entity.user.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<User, UUID> {
}
