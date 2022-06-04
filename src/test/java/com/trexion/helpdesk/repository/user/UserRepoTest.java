package com.trexion.helpdesk.repository.user;

import com.trexion.helpdesk.Entities;
import com.trexion.helpdesk.entity.user.user.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@Slf4j
class UserRepoTest {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserAccessRepo userAccessRepo;

    @Test
    @DisplayName("save should persist a given unpersisted entity")
    void save_() {
        //Given
        User user = Entities.randomUser();
        userAccessRepo.save(user.getAccess());
        //When
        userRepo.save(user);
        //Then
        assertThat(userRepo.getById(user.getId())).isEqualTo(user);
    }
}